import math


def task1_a():
    a = int(input("Input a number"))
    b = int(input("Input a number"))
    c = int(input("Input a number"))
    max (a, b ,c)
    print("Maximum is " , max (a, b ,c))


def task1_b():
    array = []
    array.append(int(input("Input a number")))
    array.append(int(input("Input a number")))
    array.append(int(input("Input a number")))
    res = set(array)
    if(len(res) == 3):
        print("0")
    if(len(res) == 2):
        print("2")
    if(len(res) == 1):
        print("3")

def task1_c():
    year = int(input("Enter a number"))
    if(year % 4 ==  0 or year % 400 == 0 and year % 100 != 0):
        print("Yes")
    else:
        print("No")


def task1_d():
    pos1 = (int(input("Input column")), int(input("Input row")))
    pos2 = (int(input("Input column")), int(input("Input row")))
    if(pos1[0] == pos2[0]):
        print("Yes")
    elif(pos1[1] == pos2[1]):
        print("Yes")
    elif(pos1[0] == pos2[0] and pos1[1] == pos2[1]):
        print("No")
    else:
        print("No")

def task2_a():
    a = int(input("Enter number"))
    i = 1
    while i <= a:
        i = i + 1
        if a % i == 0:
            print(i, "Наименьшие делитель отличный от 1")
            break

def task2_b():
    x = int(input("Input x"))
    y = int(input("Input y"))
    day = 1
    while (x < y):
        x *=1.1
        day += 1
    print(day, "Days")

def task2_c():
    x = int(input("Input x"))
    p = float(input("Input p"))/100
    y = int(input("Input y"))
    year = 1
    while (x < y):
        x *= 1 + p
        x = round_down(x, 2)
        year += 1
    print(year, "Years")

def round_down(n, decimals=0):
    multiplier = 10 ** decimals
    return math.floor(n * multiplier) / multiplier

def task2_d():
    a = int(input("Enter number"))
    b = 1
    c = 2
    i = 2
    while (a != c):
        if(c > a):
            print("Not Fibanchi")
            break
        else:
            i += 1
            rem = c
            c += b
            b = rem
    if(c == a):
        print(i)

def task3_a():
    print(int(input("Enter number")) % 10)

def task3_b():
    a = float(input("Enter float"))

    print(a - int(a))

def task3_c():
    a = float(input("Enter float"))
    res = a * 10
    res %= 10
    print(int(res))

def task3_d():
    a = float(input("Enter float"))
    check = a - int(a)
    if (check >= 0.5):
        print(int(a) + 1)
    else:
        print(int(a))

if __name__ == '__main__':
    task3_c()

