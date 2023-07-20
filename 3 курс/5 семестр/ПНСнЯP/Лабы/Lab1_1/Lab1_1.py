import math
import operator

def sigmoid(x):
  return 1 / (1 + math.exp(-x))

def mse(x, y):
  return (x - y) ** 2

if __name__ == '__main__':
  neiroSmesh = -0.3
  vector = [[1, 0], [0, 1], [0, 0], [1, 1]]
  w1 = 0.5
  w2 = 0.5
  w3 = 0.5
  w4 = 0.5
  w5 = 0.4
  w6 = 0.2
  total = 0

  for i in vector:
    i1 = i[0]
    i2 = i[1]
    H1input = i1 * w1 + i2 * w3 + neiroSmesh
    H1output = sigmoid(H1input)

    H2input = i1 * w2 + i2 * w4 + neiroSmesh
    H2output = sigmoid(H2input)

    O1input = H1output * w5 + H2output * w6 + neiroSmesh
    O1output = sigmoid(O1input)

    O1ideal = operator.xor(i1, i2)

    n = 1
    total += mse(O1ideal, O1output)

    print(O1output)

    if O1output >= 0.5:
      O1output = 1

    if O1output <= 0.5:
      O1output = 0

    print('result = ' + str(O1output))
    print('error = ' + str(O1ideal))
    print()

total /= 4
print(total)


