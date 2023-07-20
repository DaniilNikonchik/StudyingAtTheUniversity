from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import numpy as np

X = np.loadtxt('Cnt.txt')
Y = np.loadtxt('Len.txt')
Z = np.loadtxt('D.txt')


fig = plt.figure()
ax = fig.gca(projection='3d')

ax.plot_trisurf(X, Y, Z, linewidth=0, antialiased=True)

plt.show()
print(fig)