import math
##############################################################################################
print('Task 1A')                                                                             #
a = int(input('Enter the first number: '))                                                   #
b = int(input('Enter the second number: '))                                                  #
c = int(input('Enter the third number: '))                                                   #
print('Maximum: ', max(a, b, c))                                                             #
##############################################################################################

print('')

##############################################################################################
print('Task 1B')                                                                             #
print('The number of matching numbers: ', end=' ')                                           #
if a == b and b == c:                                                                        #
    print(3)                                                                                 #
elif a == b or a == c or b == c:                                                             #
    print(2)                                                                                 #
else:                                                                                        #
    print(0)                                                                                 #
##############################################################################################

print('')

##############################################################################################
print('Task 1C')                                                                             #
year = int(input('Enter a natural number for year: '))                                       #
print('Leap year: ', end=' ')                                                                #
if (year % 4 == 0 and year % 100 != 0) or (year % 400 == 0):                                 #
    print('yes')                                                                             #
else:                                                                                        #
    print('no')                                                                              #
##############################################################################################

print(' ')

##############################################################################################
print('Task 1D')                                                                             #
x1 = int(input('The first column number: '))                                                 #
y1 = int(input('The first line number: '))                                                   #
x2 = int(input('The second column number: '))                                                #
y2 = int(input('The second line number: '))                                                  #
print('The chess rook moves horizontally or vertically: ', end=' ')                          #
if x1 == x2 or y1 == y2:                                                                     #
    print('yes')                                                                             #
else:                                                                                        #
    print('no')                                                                              #
##############################################################################################

print('')

##############################################################################################
print('Task 2A')
n = int(input('Enter an integer: '))
i = 1
while i <= n:
    i = i + 1
    if n % i == 0:
        print('The smallest natural divisor: ', i)
        break
##############################################################################################

print('')

##############################################################################################
print('Task 2B')
x = int(input('Enter how many kilometers the athlete ran on the first day: '))
y = int(input('Enter the number of kilometers how many should the athlete run in total: '))
i = 0
while x < y:
    x *= 1.1
    i += 1
print(i, 'day')
##############################################################################################

print('')

##############################################################################################
print('Task 2C')
x = int(input('Enter the deposit in the bank: '))
p = int(input('Enter the percentage by which the contribution increases: '))
y = int(input('Enter in how many years the contribution will be at least rubles: '))
i = 0
while x < y:
    x *= 1 + p / 100
    x = int(100 * x) / 100
    i += 1
print('Through ', i, ' years')
##############################################################################################

print(' ')

##############################################################################################
print('Task 2D')
a = int(input('Enter an integer: '))
if a == 0:
    print('Is a Fibonacci number: ', 0)
else:
    previous, sled = 0, 1
    n = 1
    while sled <= a:
        if sled == a:
            print('Is a Fibonacci number: ', n)
            break
        previous, sled = sled, previous + sled
        n += 1
    else:
        print('The number is not a Fibonacci number: ', -1)
##############################################################################################

print(' ')

##############################################################################################
print('Task 3A')
a = int(input('Enter an integer: '))
print('The last number: ', a % 10)
##############################################################################################

print(' ')

##############################################################################################
print('Task 3B')
a = float(input('Enter a positive real number: '))
print('Fractional part: ', int(round((a - int(a)), 1) * 10))
##############################################################################################

print(' ')

##############################################################################################
print('Task 3С')
a = float(input('Enter a positive real number: '))
print('The first number after the decimal point: ', int(a * 10) % 10)
##############################################################################################

print(' ')

##############################################################################################
print('Task 3D')
a = float(input('Enter a non-negative number: '))
b = math.ceil(a)
if b - a <= 0.5:
    print('Rounded number: ', math.ceil(a))
else:
    print('Rounded number: ', math.floor(a))
##############################################################################################
