##############################################################################################
print('Task 4A')
print('Enter words: ', end=' ')
print(input().count(' ') + 1)
##############################################################################################

print(' ')

##############################################################################################
print('Task 4B')
print('Enter words: ', end=' ')
s = input().split()
print('The string is reversed: ', s[1], s[0])
##############################################################################################

print(' ')

##############################################################################################
print('Task 4C')
print('Enter words: ', end=' ')
print(input().replace('1', 'one'))
##############################################################################################

print(' ')

##############################################################################################
print('Task 5A')
print('Enter words: ', end=' ')
s = input().split()
for i in range(0, len(s), 2):
    print('Elements with even indices: ', s[i])
##############################################################################################

print(' ')

##############################################################################################
print('Task 5C')
print('Enter numbers: ', end=' ')
a = [int(i) for i in input().split()]
c = 0
for i in range(1, len(a) - 1):
    if (a[i - 1] < a[i] and a[i] > a[i + 1]):
        c += 1
print('List: ', c)
##############################################################################################

print(' ')

##############################################################################################
print('Task 5D')
print('Enter numbers: ', end=' ')
a = [int(s) for s in input().split()]
min_i = 0
max_i = 0
for i in range(1, len(a)):
    if a[i] > a[max_i]:
        max_i = i
    if a[i] < a[min_i]:
        min_i = i
a[min_i], a[max_i] = a[max_i], a[min_i]
print('Numbers: ', a)
##############################################################################################

print(' ')

##############################################################################################
print('Task 6A')
print('Enter numbers: ', end=' ')
word = input()
vowels = 0
consonants = 0
for i in word:
    letter = i.lower()
    if letter == 'a' or letter == 'e' or\
       letter == 'i' or letter == 'o' or\
       letter == 'u' or letter == 'y':
        vowels += 1
    else:
        consonants += 1
print('Vowels: %i\nConsonants: %i' % (vowels, consonants))
##############################################################################################

print()

##############################################################################################
print('Task 6B')
print('Enter offer: ', end=' ')
s = input()
c = s.count(' ')
w = s.title().split()
print('Words: ', end=' ')
for i in range(0, c+1):
    print(w[i], end='. ')
##############################################################################################

print('\n ')

##############################################################################################
print('Task 6C')
print('Enter offer: ', end=' ')
str0 = input()
chars = "abcdefghijklmnopqrstuvwxyz"
for char in chars:
    count = str0.count(char)
    if count > 0:
        print('Frequency: ', char, count)
##############################################################################################

print(' ')

##############################################################################################
print('Task 6D')
print('Enter offer: ', end=' ')
s = input()
index = 0
c = s.count(' ')
w = s.split()
for i in range(0, c+1):
    z = w[i]
    if z[0] == z[-1]:
        index += 1
print('Frequency: ', index)
##############################################################################################

print(' ')

##############################################################################################
print('Task 6F')
print('Enter list: ', end=' ')
new_list = [int(s) for s in input().split()]
list2 = []
zeros = 0
for i in range(0, len(new_list)):
    if (new_list[i] != 0):
        list2.append(new_list[i])
    else:
        zeros += 1
list2 += ([0] * zeros)
print('List: ', list2)
##############################################################################################

print(' ')

##############################################################################################
print('Task 6G')
print('Enter list: ', end=' ')
list3 = input().split()
list4 = []
for i in range(0, len(list3), 2):
    if int(list3[i]) > 0:
        list4.append(list3[i])
print(list4)
##############################################################################################
