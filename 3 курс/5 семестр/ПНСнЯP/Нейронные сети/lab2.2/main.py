def task4_a():
    print(input().count(' ') + 1)


def task4_b():
    s = input()
    first = s[:s.find(' ')]
    second = s[s.find(' ') + 1:]
    print(second + ' ' + first)


def task4_c():
    s = input()
    print(s.replace('1', 'one'))


def task5_a():
    s = input().split()
    print(s[::2])


def task5_b():
    s = [int(i) for i in input().split()]
    for i in range(1, len(s)):
        if s[i] > s[i - 1]:
            print(s[i])


def task5_c():
    s = [int(i) for i in input().split()]
    count = 0
    for i in range(1, len(s) - 1, 2):
        if s[i] > s[i - 1] and s[i] > s[i + 1]:
            count += 1
    print(count)


def task6_a():
    vowels = "aeiouy"
    consonants = "qwrtpsdfghjklzxcvbnm"
    s = input()
    res1 = 0
    res2 = 0
    for ch in vowels:
        rem = s.count(ch)
        res1 += rem
    for ch in consonants:
        rem = s.count(ch)
        res2 += rem
    print("Гласные", res1, " Согласные", res2)


def task6_b():
    s = input()
    c = s.count(' ')
    w = s.split()
    for i in range(0, c + 1):
        a = w[i]
        b = a[0].upper() + a[1:]
        print(''.join(b), end='. ')


def task6_c():
    chars = "qwertyuiopasdfghjklzxcvbnm"
    s = input()
    for char in chars:
        count = s.count(char)
        if count > 0:
            print(char, " - ", count)


def task6_d():
    s = input()
    index = 0

    c = s.count(' ')
    w = s.split()
    for i in range(0, c + 1):
        z = w[i]
        if z[0] == z[-1]:
            index += 1
    print(index)


def task6_f():
    list1 = [int(i) for i in input().split()]
    list2 = []
    zeros = 0

    for i in range(0, len(list1)):
        if list1[i] != 0:
            list2.append(list1[i])
        else:
            zeros += 1
    for i in range(0, zeros):
        list2.append(0)
    print(list2[:])


def task6_g():
    list1 = [int(i) for i in input().split()]
    list2 = []
    for i in range(0, len(list1), 2):
        if list1[i] > 0:
            list2.append(list1[i])
    print(list2[:])

if __name__ == '__main__':
    task6_c()
