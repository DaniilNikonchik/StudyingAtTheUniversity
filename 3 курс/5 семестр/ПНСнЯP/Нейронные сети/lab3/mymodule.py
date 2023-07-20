import math
import random


def task2a():
    print("log =", math.log(15, 2))


def task2b():
    for _ in range(4):
        random.seed(10)
        print(random.random())


def task2c():
    print(dir())