import com.sun.org.apache.xerces.internal.util.FeatureState.of
import java.nio.file.Files
import java.nio.file.Path
import java.time.ZoneOffset.of
import java.util.EnumSet.of
import java.util.Optional.of
import kotlin.time.Duration
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

const val ITERATIONS = 8
const val test = 4
const val KEY = 788803241

@OptIn(ExperimentalTime::class)
fun timeTest(hugeFileName: String) {
    val elapsed: Duration = measureTime {
        val system = GCryptoSystem(788803241, 8)
        system.runHugeTest(hugeFileName, 100_000_000)
    }
    //last result = 56.7s
    println(elapsed)
}


fun main() {
    //10001001101011110100111011
    val system = HashSystem()
    println("Message hash : ${String(system.getHash("te.txt"))}")
    println("Message hash : ${String(system.getHash("test.txt"))}")

    for(i in 1..8) {
        val system = GCryptoSystem(KEY, i)
        val fileName = "coin-collection.jpg"
        val bytes = system.encodeFile(fileName)
        Files.write(Path.of("coin-encoded$i.jpg"), bytes);
    }
}
