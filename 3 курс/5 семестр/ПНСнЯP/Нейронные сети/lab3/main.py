# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def task1_a():
    a = (1, [2, 3])
    print(a[1].append(4))


def task1_b():
    a = (1, [2, 3])
    b = [4,5,6]
    l = list(a)
    l.append(b)
    a = tuple(l)
    print(a)


def task1_c():
    a = (1, [2, 3])
    l = list(a)
    l.append("Hello")
    print(tuple(l))


def task1_d():
    a = (1, [2, 3])
    l = list(a)
    l[1] += a[1]
    print(tuple(l))


def task2_a():
    a = [1, 2, 3, 4]
    b = [1, 3, 5, 7, 9]
    print(len(a) + len(b))


def task2_b():
    array = [int(s) for s in input().split()]
    before = set()
    for n in array:
        if n in before:
            print("Yes")
        else:
            print("No")
        before.add(n)


def task2_c():
    inp = [int(s) for s in input().split()]
    n = inp[0]
    m = inp[1]
    a = set()
    b = set()
    print("Input Ann's cubes")
    for i in range(n):
        a.add(int(input()))
    print("Input Boris's cubes")
    for i in range(m):
        b.add(int(input()))
    print("Both got same cubes :", len(a & b), "  ", a & b)
    print("Cubes that Ann got :", len(a - b), "  ", a - b)
    print("Cubes that Boris got :", len(b - a), "  ", b - a)


def task2_d():
    N = int(input())
    numbers = set(range(1, N + 1))

    possible = numbers
    while True:
        guess = input()
        if guess == 'q':
            break
        guess = {int(x) for x in guess.split()}
        answer = input()

        if answer == 'yes':
            possible &= guess
        else:
            possible &= numbers - guess

    print('possible:')
    print(' '.join([str(x) for x in sorted(possible)]))


def task3_a():
    text = {}
    for i in input().split():
        text[i] = text.get(i, 0) + 1
        print(i, text[i] - 1)


def task3_b():
    n = int(input())
    p = dict(input().split() for j in range(n))
    k = input()

    for key, value in p.items():
        if k == value:
            print('synonym', key)
        if k == key:
            print('synonym:', value)


def task3_c():
    word_n = {}
    q = int(input())

    for i in range(q):
        line = input().split()

        for wrd in line:
            word_n[wrd] = word_n.get(wrd, 0) + 1

    max_count = max(word_n.values())
    most_frequent = [k for k, v in word_n.items() if v == max_count]
    print('most frequent:', min(most_frequent))


def task3_d():
    dictionary = {}

    for i in range(int(input())):
        for word in input().split():
            dictionary[word] = dictionary.get(word, 0) + 1
    print('\nwords:')
    for i in sorted(dictionary.items(), key=lambda x: (-x[1], x[0])):
        print(i[0])


if __name__ == '__main__':
    task2_b()

