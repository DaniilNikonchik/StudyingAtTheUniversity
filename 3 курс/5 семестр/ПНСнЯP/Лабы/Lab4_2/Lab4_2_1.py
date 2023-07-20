import numpy as np


def nonlin(x, deriv=False):
    if (deriv == True):
        return (x * (1 - x))

    return 1 / (1 + np.exp(-x))


def normalize(X):
    return (X - X.mean()) / X.std()


X = np.array([[1.9585, 1.9585, 1.9585, 1.9666],
              [1.9585, 1.9585, 1.9666, 1.9707],
              [1.9585, 1.9666, 1.9707, 1.9653],
              [1.9666, 1.9707, 1.9653, 1.9538],
              [1.9707, 1.9653, 1.9538, 1.9538],
              [1.9653, 1.9538, 1.9538, 1.9538],
              [1.9538, 1.9538, 1.9538, 1.9597],
              [1.9538, 1.9538, 1.9597, 1.9640],
              [1.9538, 1.9597, 1.9640, 1.9697]])
Y = np.array([[1.9707],
              [1.9653],
              [1.9538],
              [1.9538],
              [1.9538],
              [1.9597],
              [1.9640],
              [1.9697],
              [1.9542]])

np.random.seed(1)
X /= 10
Y /= 10

syn0 = 2 * np.random.random((4, 9)) - 1
syn1 = 2 * np.random.random((9, 1)) - 1

for j in range(60000):

    l0 = X
    l1 = nonlin(np.dot(l0, syn0))
    l2 = nonlin(np.dot(l1, syn1))

    l2_error = Y - l2
    if (j % 10000) == 0:
        print('Error: ' + str(np.mean(np.abs(l2_error))))

    l2_delta = l2_error * nonlin(l2, deriv=True)

    l1_error = l2_delta.dot(syn1.T)

    l1_delta = l1_error * nonlin(l1, deriv=True)

    syn1 += l1.T.dot(l2_delta)
    syn0 += l0.T.dot(l1_delta)

# прогноз

X = np.array([[2.0505, 2.0500, 2.0505, 2.0519]])
Y = np.array([[2.0501]])

X /= 10
Y /= 10

l0 = X
l1 = nonlin(np.dot(l0, syn0))
l2 = nonlin(np.dot(l1, syn1))

l2_error = Y - l2

print('Prediction: ', l2[0] * 10)
print('Prediction Error ', l2_error)
