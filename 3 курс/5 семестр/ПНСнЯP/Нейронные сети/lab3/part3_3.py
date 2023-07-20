import mymodule


def task1a():
    f = open('test.txt', 'r')
    surnames = f.read()
    print(surnames)
    f.close()


def task1b():
    f = open('test.txt', 'r')
    surnames = f.read()
    arr = surnames.split('\n')

    n = 1
    for s in arr:
        print(n, s)
        n += 1


def task1c():
    fl = open('test2.txt', 'r')
    surnames2 = fl.read()
    print(surnames2)
    fl.close()

def task1d():
    fl = open('test2.txt', 'r')
    surnames2 = fl.read()
    surnames2 = surnames2.split('\n')
    for s in surnames2:
        name = s.split()
        print(name[0], name[1][0:1])

print("Task1a\n")
task1a()
print("Task1b\n")
task1b()
print("Task1c\n")
task1c()
print("Task1d\n")
task1d()
print("Task2a\n")
mymodule.task2a()
print("Task2b\n")
mymodule.task2b()
print("Task2c\n")
print(dir())
mymodule.task2c()
