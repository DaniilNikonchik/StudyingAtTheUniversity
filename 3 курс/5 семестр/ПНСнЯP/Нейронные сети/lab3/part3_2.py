def distance(x1, x2, y1, y2):
    try:
        result = ((x2 - x1) ** 2 + (y2 - y1) ** 2) ** 0.5
    except ArithmeticError:
        print('Error')
    print("Distance is ", result)


def power(a, n):
    res = 1
    for i in range(abs(n)):
        res *= a
    if n >= 0:
        return res
    else:
        return 1/res


def capitalize(word):
    small = word[0]
    big = chr(ord(small) - ord('a') + ord('A'))
    return big + word[1:]


def myfunc():
    source = input().split()
    res = []
    for word in source:
        res.append(capitalize(word))
    print(' '.join(res))


def max(*a):
    res = a[0]
    for val in a[1:]:
        if val > res:
            res = val
    return res






try:
    x1 = float(input())
    x2 = float(input())
    y1 = float(input())
    y2 = float(input())
except ValueError:
    print('Error. Enter float')

distance(x1, x2, y1, y2)

print(power(2, 8))

myfunc()

print(max(1, 3, 13, 1223, 213, 123, 12313))



