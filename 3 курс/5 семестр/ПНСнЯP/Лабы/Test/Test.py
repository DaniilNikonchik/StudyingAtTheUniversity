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