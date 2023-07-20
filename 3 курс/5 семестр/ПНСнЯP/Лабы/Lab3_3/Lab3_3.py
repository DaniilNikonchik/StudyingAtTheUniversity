import math
import random
import module_for_task_2_d

# a) По аналогии с разобранным примером составьте список фамилий группы и запишите его в текстовый файл.
# Распечатайте созданный файл.
f = open('group_info.txt', 'w')
group_list = ["Abilova",
               "Borsukov",
               "Hiro",
               "Gorshkov",
               "Kolosovskiy",
               "Kuksa",
               "kurilovich",
               "Miroevskiy",
               "Nevar",
               "Nikonchik",
                "Rakots",
                "Filon"]
for student in group_list:
    f.write(student + '\n')
f.close()
f = open('group_info.txt', 'r')
print(f.read())
f.close()

print(' ')

# b) Распечатайте созданный файл фамилий построчно, добавив перед каждой фамилией ее порядковый номер.
f = open('group_info.txt', 'r')
num = 1
for line in f:
    print(str(num) + ") " + line, end='')
    num += 1
f.close()

print(' ')

# c) Создайте файл, добавив к каждой фамилии имя. Распечатайте его построчно.
f = open('group_new_info.txt', 'w')
group_full_list = ["Abilova Evelina",
               "Borsukov Arseniy",
               "Hiro Liza",
               "Gorshkov Daniil",
               "Kolosovskiy Roman",
               "Kuksa Andrei",
               "kurilovich Darya",
               "Miroevskiy Alexey",
               "Nevar Maxim",
               "Nikonchik Daniil",
                "Rakots Valentin",
                "Filon Anna"]
for student in group_full_list:
    f.write(student + '\n')
f.close()
f = open('group_new_info.txt', 'r')
print(f.read())
f.close()

print(' ')

# d) Распечатайте из последнего файла только фамилию и первую букву имени.
f = open('group_new_info.txt', 'r')
for line in f:
    two_words = line.split()
    result_str = two_words[0]
    result_str += ' '
    result_str += two_words[1][0]
    print(result_str)
f.close()

print(' ')

#2nd part
# a) Вычислите логарифм по основанию 2 от 15.
print("log_2(15) =", math.log(15, 2))

print(' ')

# b) Сгенерируйте четыре раза одно и то же число, равномерно распределенное на интервале (0; 1).
state = random.getstate()
num = random.random()
print("first generation:", num)
random.setstate(state)
num = random.random()
print("second generation:", num)
random.setstate(state)
num = random.random()
print("third generation:", num)
random.setstate(state)
num = random.random()
print("fourth generation:", num)

print(' ')

# c) Определите список имен, определенных в данный момент.
names_list = dir()
i = 1
for name in names_list:
    if i % 8 == 0:
        print()
    print(name, end=', ')
    i += 1
print()

print(' ')

# d) Создайте и выполните свой модуль на языке Python.
module_for_task_2_d.Foo()