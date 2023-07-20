# Павел Бандюк, 12 группа, КТС

import math
import functools


# task 1, 3.3
def task_one():
    def distance(x1: int, y1: int, x2: int, y2: int) -> float:
        return math.sqrt((x2 - x1) ** 2 + (y2 - y1) ** 2)

    print('Enter x1, y1, x2, y2:')
    try:
        print(f"Result distance: {distance(*[int(i) for i in input().split(' ')])}")

    except (ValueError, IndentationError) as e:
        print(f'Error: {e}')

    def power(a: float, n: int):
        if n == 0:
            return 1
        if n == -1:
            return 1. / a
        p = power(a, n // 2)
        p *= p
        if n % 2:
            p *= a
        return p

    print('Enter x, y:')
    line = input().split()
    x, y = float(line[0]), int(line[1])

    print(f'Result: {power(x, y)}\nCheck with math.pow(): {math.pow(x, y)}')

    # я намеренно усложнил задачу: для практики, создав декоратор и "подействовал" на строку с помощью функции map.
    def capitalize(function):
        @functools.wraps(function)
        def wrapper(*args):
            word = function(*args)
            first_small_letter = word[0]
            first_big_letter = chr(ord(first_small_letter) + ord('A') - ord('a'))

            return first_big_letter + word[1:]

        return wrapper

    # decorated function that returns a string
    @capitalize
    def ourWord(word: str) -> str:
        return word

    w = input('Enter your string: ')
    print(f"Capitalized string: {' '.join(list(map(ourWord, w.split())))}")

    def myMax(*args):
        maxElement = args[0]
        for i in range(1, len(args)):
            if args[i] > maxElement:
                maxElement = args[i]

        return maxElement

    print('Enter some numbers to calculate the maximum of them: ', end='')
    # cast to float
    numbers = [float(number) for number in input().split()]

    print(f"Max num in {numbers} is {myMax(*numbers)}")
    print(f'Check with function max: {max(numbers)}')


if __name__ == '__main__':
    task_one()