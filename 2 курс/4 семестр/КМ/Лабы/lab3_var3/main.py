import random
import timeit
import scipy.special as sc
import math
import scipy.stats as st  # for pvalue
import RunsTest


def to_bits_array(text):
    i = 0
    bits = []
    n = len(text)
    while i < n:
        for j in range(0, 8):
            bits.append((text[i] >> j) & 1)
        i += 1
    return bits


class Crypto:
    # массив подключей Ki в зависимости от количества тактов
    keys = []

    # d - число тактов
    def __init__(self, key, d: int):
        if d < 0:
            return
        key = key
        self.d = d
        # int key_
        # 2**8 это один бит
        key_ = key
        for i in range(0, d):
            # в зависимости от количества тактов записываем побайтно ключи
            self.keys.append(key_ % (2 ** 8))
            # после записи делаем сдвиг на один байт
            key_ = key_ >> 8
            if d == 3:
                key_ = key
        self.keys.reverse()

    @staticmethod
    def unite(x1: int, x2: int):
        return (x1 << 4) | x2

    # чиклический побитовый сдвиг
    def right_way(self, x1: int, x2: int, key: int):
        y2 = x2 ^ key
        # деление на s блоки
        s = Crypto.divide(y2)
        # объединение блоков
        y2 = Crypto.unite(Crypto.s1(s[0]), Crypto.s2(s[1]))
        # циклический сдвиг вправо на 3 бита
        # y2 = Crypto.right(y2, 3)
        y2 = y2 << 3
        y2 = (y2 % (2 ** 8)) | (y2 >> 8)
        y2 = y2 ^ x1
        return y2

    def encrypt(self, text):
        # исходный текст в байтовом виде
        length = len(text)
        i = 0
        while i < length:
            if i + 2 >= length:
                break
            x1 = text[i]
            i = i + 1
            b = True
            x2 = text[i]
            y1: int
            y2: int
            for d_ in range(0, self.d):
                y1 = x2
                y2 = Crypto.right_way(self, x1, x2, self.keys[d_])
                x1 = y1
                x2 = y2

            text[i - 1] = y1
            text[i] = y2
            i += 1
        return text

    def decrypt(self, text):
        length = len(text)
        i = 0
        while i < length:
            if i + 2 >= length:
                break
            y1 = text[i]
            i = i + 1
            b = True
            y2 = text[i]
            x1: int
            x2: int
            j = self.d - 1
            while j >= 0:
                x2 = y1
                x1 = Crypto.right_way(self, y2, y1, self.keys[j])
                y1 = x1
                y2 = x2
                j -= 1
            text[i - 1] = x1
            text[i] = x2
            i = i + 1
        return text

    @staticmethod
    def divide(x: int):
        res = []
        res.append(x >> 4)
        res.append(x - (2 ** 4) * res[0])
        return res

    @staticmethod
    def left(x: int, delta: int):
        max = (2 ** 8)
        x = x % max
        x_ = x >> (8 - delta)
        x_ = ((x << delta) % max) | x_
        return x_

    @staticmethod
    def right(x: int, delta: int):
        max = (2 ** 8)
        x = x % max
        x_ = (x << (8 - delta)) % max
        x_ = x_ | (x >> delta)
        return x_

    @staticmethod
    def s1(x: int):
        return ((3 ** x) % 17 + 2) % 16

    @staticmethod
    def s2(x: int):
        return ((5 ** x) % 17 + 7) % 16

    def encrypt_from_file(self, filein):
        f = open(filein, "rb")
        text = bytearray(f.read())
        f.close()
        return self.encrypt(text)

    def encrypt_from_file_to_file(self, filein, fileout):
        text = self.encrypt_from_file(filein)
        f = open(fileout, "wb")
        f.write(text)
        f.close()
        return text

    def decrypt_from_file(self, filein):
        f = open(filein, "rb")
        text = bytearray(f.read())
        f.close()
        return self.decrypt(text)

    def decrypt_from_file_to_file(self, filein, fileout):
        text = self.decrypt_from_file(filein)
        f = open(fileout, "wb")
        f.write(text)
        f.close()
        return text


def test(filein, filekey, efileout, dfileout):
    f = open(filekey, 'rb')
    # из битов в инт трансформация
    key = int.from_bytes(f.read(4), 'little')
    f.close()
    # тестирование для для определенного числа тактов(1-8)
    for i in range(1, 9):
        cr = Crypto(key, i)
        start_time = timeit.default_timer()
        # шифровка
        etext = cr.encrypt_from_file_to_file(filein, efileout + str(i))
        end_time = timeit.default_timer()
        print('Encryption time:' + str(end_time - start_time))

        cr.decrypt_from_file_to_file(efileout + str(i), dfileout + str(i))

        RunsTest.RunsTest.Test(to_bits_array(etext))


if '__main__':
    test('Encrypt.txt', 'key.txt', 'encryptfileout', 'decryptfileout')
