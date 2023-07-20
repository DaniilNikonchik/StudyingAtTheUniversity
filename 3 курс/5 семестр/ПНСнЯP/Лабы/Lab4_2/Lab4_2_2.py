import numpy as np


def nonlin(x, deriv=False):
    if (deriv == True):
        return (x * (1 - x))

    return 1 / (1 + np.exp(-x))


def normalizer(ar, i1, j):
    n = []
    for i in range(i1):
        ns = []
        for k in range(j):
            if k == 0:
                if ar[i][k] <= 0.5:
                    ns.append(0)
                elif ar[i][k] > 0.5 and ar[i][k] <= 1:
                    ns.append(0.25)
                elif ar[i][k] > 1 and ar[i][k] <= 2:
                    ns.append(0.5)
                elif ar[i][k] > 2 and ar[i][k] <= 5:
                    ns.append(0.75)
                else:
                    ns.append(1)
            elif k == 2:
                if ar[i][k] <= 20.:
                    ns.append(0)
                elif ar[i][k] > 20. and ar[i][k] <= 50.:
                    ns.append(0.25)
                elif ar[i][k] > 50 and ar[i][k] <= 100:
                    ns.append(0.5)
                elif ar[i][k] > 100 and ar[i][k] <= 200:
                    ns.append(0.75)
                else:
                    ns.append(1)
            elif k == 3:
                if ar[i][k] <= 2.:
                    ns.append(0)
                elif ar[i][k] > 2. and ar[i][k] <= 5.:
                    ns.append(0.25)
                elif ar[i][k] > 5. and ar[i][k] <= 10.:
                    ns.append(0.5)
                elif ar[i][k] > 10. and ar[i][k] <= 20.:
                    ns.append(0.75)
                else:
                    ns.append(1)
            else:
                if ar[i][k] <= 1.:
                    ns.append(0)
                elif ar[i][k] > 1. and ar[i][k] <= 2.:
                    ns.append(0.25)
                elif ar[i][k] > 2. and ar[i][k] <= 3.:
                    ns.append(0.5)
                elif ar[i][k] > 3. and ar[i][k] <= 4.:
                    ns.append(0.75)
                else:
                    ns.append(1)
        n.append(ns)
    return np.array(n)










#np.random.seed(3)


X = np.array([[0.645, 33, 4, 0.34],
              [2.880, 152, 14, 1.5],
              [1.110, 88, 5, 0.475],
              [10.400, 260, 3, 6],
              [2.880, 152, 3, 1.5],
              [9.895, 122, 30, 6.2],
              [3.695, 136,3, 3],
              [2.170, 116, 5, 0.6],
              [27.895, 278, 150, 11],
], dtype=float)

X = normalizer(X,9,4)
Y = np.array([[1, 0, 0], [0, 1, 0], [1, 0, 0], [0, 0, 1], [0, 0, 1], [0, 1, 0], [0, 0, 1], [1, 0, 0], [0, 1, 0]], dtype=float)




syn0 = 2 * np.random.random((4, 3)) - 1
syn1 = 2 * np.random.random((3, 3)) - 1


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


X = np.array([ [74, 1050, 1, 90],
      [13.6, 260, 10, 3],
      [0.3, 40, 3, 0.25],
      [0.2, 1, 4, 0.2],
      [0.02, 0.3, 1, 0.1],
      [18.4, 245, 168, 12]])


X = normalizer(X,6,4)
l0 = X
l1 = nonlin(np.dot(l0, syn0))
l2 = nonlin(np.dot(l1, syn1))
print(l2)