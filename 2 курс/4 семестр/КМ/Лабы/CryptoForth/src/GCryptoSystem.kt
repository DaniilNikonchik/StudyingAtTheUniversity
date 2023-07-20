import java.nio.file.Files
import java.nio.file.Paths
import kotlin.experimental.xor
import kotlin.math.pow
import kotlin.math.roundToInt

class GCryptoSystem(private val K: Int, private val iterations: Int) {

    private val sessionKeys: List<Byte>

    init {
        val keys = mutableListOf<Byte>()
        for (i in 0 until iterations) {
            keys += if (i <= 3) {
                extractSessionKey(i)
            } else {
                val key = keys[i - 3]
                key
            }
        }
        sessionKeys = keys
    }

    fun decodeFile(filePath: String): ByteArray {
        val path = Paths.get(filePath)
        val bytes = Files.readAllBytes(path)
        return decodeBytes(bytes)
    }

    private fun decodeBytes(bytes: ByteArray): ByteArray {
        var result = ByteArray(bytes.size)
        for (i in bytes.indices step 2) {
            if (i >= bytes.size - 1) {
                break
            }
            val y1 = bytes[i]
            val y2 = bytes[i + 1]
            val decoded = decode(iterations, y1, y2)
            result[i] = decoded.first
            result[i + 1] = decoded.second
        }
        return result
    }

    fun runHugeTest(filePath: String, bytesCount: Int): ByteArray {
        val path = Paths.get(filePath)
        val bytes = Files.readAllBytes(path)
        var result = ByteArray(bytes.size)
        for (i in 0..bytesCount step 2) {
            if (encodeBytes(i, bytes, result)) break
        }
        return result
    }


    fun encodeFile(filePath: String): ByteArray {
        val path = Paths.get(filePath)
        val bytes = Files.readAllBytes(path)
        return encodeBytes(bytes)
    }

    fun encodeBytes(bytes: ByteArray): ByteArray {
        var result = ByteArray(bytes.size)
        for (i in 0..bytes.size step 2) {
            if (encodeBytes(i, bytes, result)) break
        }
        return result
    }

    private fun encodeBytes(i: Int, bytes: ByteArray, result: ByteArray): Boolean {
        if (i >= bytes.size - 1) {
            return true
        }
        val x1 = bytes[i]
        val x2 = bytes[i + 1]
        val encoded = encode(iterations, x1, x2)
        result[i] = encoded.first
        result[i + 1] = encoded.second
        return false
    }


    private fun extractSessionKey(offset: Int): Byte {
        val tmp = K shl 8 * offset
        val result = tmp shr 24
        return result.toByte()
    }

    private fun decode(iterations: Int, x1: Byte, x2: Byte): Pair<Byte, Byte> {
        var y2 = x1
        var y1 = x2
        for (i in iterations - 1 downTo 0) {
            val tmp = y2.xor(sessionKeys[i])
            val afterFunc = f(tmp)
            val result = afterFunc.xor(y1)
            y1 = y2
            y2 = result
        }
        return Pair(y2, y1)
    }

    private fun encode(iterations: Int, x1: Byte, x2: Byte): Pair<Byte, Byte> {
        var y1 = x1
        var y2 = x2
        for (i in 0 until iterations) {
            val tmp = y2.xor(sessionKeys[i])
            val afterFunc = f(tmp)
            val result = afterFunc.xor(y1)
            y1 = y2
            y2 = result
        }

        return Pair(y1, y2)
    }

    private fun f(byte: Byte): Byte {
        //15 = 0000 1111
        val firstHalf = byte.toInt() and 15
        //240 = 1111 0000
        val secondHalf = (byte.toInt() and 240) shr 4

        val encodedFirst = s1(firstHalf)
        val encodedSecond = s2(secondHalf)
        var result = encodedSecond shl (4)
        result += encodedFirst
        val offsetResult = cyclicOffset(result)
        return offsetResult.toByte()
    }

    private fun cyclicOffset(result: Int): Int {
        val offsetToEnd = (result and 224) shr 5
        val offsetToBegin = (result and 31) shl 3
        return offsetToBegin + offsetToEnd
    }

    private fun s1(x: Int) = (((3.0.pow(x) % 17) + 2) % 16).roundToInt()


    private fun s2(x: Int) = (((5.0.pow(x) % 17) + 7) % 16).roundToInt()

}