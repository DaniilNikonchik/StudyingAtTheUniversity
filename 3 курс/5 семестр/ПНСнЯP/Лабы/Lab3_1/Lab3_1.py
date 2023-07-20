from random import randint
from collections import Counter

print('Lab3_1')

##############################################################################################
print('Task 1A')
t = (1, [2, 3])
print('Before:', t)
t[1].append(4)
print('After:', t)
##############################################################################################

print(' ')

##############################################################################################
print('Task 1B')
t = (1, [2, 3])
print("Enter three elements in line with \' ':", end=' ')
elements = [int(_) for _ in input().split()]
print('Before:', t)
print('After:', t + (elements,))
##############################################################################################

print(' ')

##############################################################################################
print('Task 1C')
t = (1, [2, 3])
print('Enter the string:', end=' ')
string = input()
print('After:', t + (string,))
##############################################################################################

print(' ')

##############################################################################################
print('Task 1D')
t = (1, [2, 3])
print('Before:', t)
t[1].extend(t[1])
print('After:', t)
##############################################################################################

print(' ')

##############################################################################################
print('Task 2A')
t = (1, 2, 3)
p = (4, 5, 6)
print('The length of the first and second list: ', len(t) + len(p))
##############################################################################################

print(' ')

##############################################################################################
print('Task 2B')
print('Enter the list of numbers: ', end=' ')
numbers = [int(_) for _ in input().split()]
before = set()
for number in numbers:
    if number in before:
        print('YES')
    else:
        before.add(number)
        print('NO')
##############################################################################################

print(' ')

##############################################################################################
print('Task 2C')
n = int(input('Enter n: '))
m = int(input('Enter m: '))

annCubes = [randint(0, 128) for cube in range(n) if 0 <= cube < 129]
boryaCubes = [randint(0, 128) for cube in range(m) if 0 <= cube < 129]

print('Ann cubes: ', end=' ')
print(annCubes)
print('Borya cubes: ', end=' ')
print(boryaCubes)

firstSet = set(annCubes) & set(boryaCubes)
secondSet = set(annCubes) - set(boryaCubes)
thirdSet = set(boryaCubes) - set(annCubes)

print('Number of cubes that Anya and Borya have:', len(firstSet))
print(*sorted(firstSet, reverse=False))

print('Number of cubes that Anya have:', len(secondSet))
print(*sorted(secondSet, reverse=False))

print('Number of cubes that Borya have:', len(thirdSet))
print(*sorted(thirdSet, reverse=False))
##############################################################################################

print(' ')

##############################################################################################
print('Task 2D')
n = int(input('Enter n: '))
all_nums = set(range(1, n + 1))
possible_numbers = all_nums
while True:
    guess = input()
    if guess == 'stop':
        break
    guess = {int(x) for x in guess.split()}
    answer = input()
    if answer == 'YES':
        possible_numbers = possible_numbers & guess
    else:
        possible_numbers = possible_numbers & (all_nums - guess)

print(' '.join([str(num) for num in sorted(possible_numbers)]))
##############################################################################################

print(' ')

##############################################################################################
print('Task 3A')
print('Enter the string:')
string = " ".join(input().split()).split(' ')

c = Counter(string)
print(c)
##############################################################################################

print(' ')

##############################################################################################
print('Task 3B')
print('Enter count of pairs:')
dictionary = {}

for _ in range(int(input())):
    first, second = input().split()
    dictionary[first] = second
    dictionary[second] = first

print(dictionary[input()])
##############################################################################################

print(' ')

##############################################################################################
print('Task 3C')
n = int(input('Enter the number of lines:'))

lines = [" ".join(input().split()).split(' ') for line in range(n)]

words = [word for line in lines for word in line]

c = Counter(words)

maxValue = max(value for value in c.values())
most_frequent_words = [key for key, value in c.items() if value == maxValue]
if len(most_frequent_words) > 1:
    resultWord = sorted(most_frequent_words, key=str.lower)[0]
else:
    resultWord = str(most_frequent_words)
print('The most frequent word is:', resultWord)
##############################################################################################

print(' ')

##############################################################################################
print('Task 3D')

print('Enter the number of lines:')
words = []
for _ in range(int(input())):
    words.extend(input().split())

c = Counter(words)

print(c.most_common())
pairs = [(-pair[1], pair[0]) for pair in c.most_common()]
words = [pair[1] for pair in sorted(pairs)]
print('\n'.join(words))
##############################################################################################
