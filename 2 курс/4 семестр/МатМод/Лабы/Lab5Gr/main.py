# from mpl_toolkits.mplot3d import Axes3D
import matplotlib.pyplot as plt
import numpy as np

X = np.loadtxt(r'C:\Users\dmin\Desktop\2 курс\4 семестр\МатМод\Лабы\matmod_lab5\matmod_lab5\Cnt.txt')
Y = np.loadtxt(r'C:\Users\dmin\Desktop\2 курс\4 семестр\МатМод\Лабы\matmod_lab5\matmod_lab5\Len.txt')
Z = np.loadtxt(r'C:\Users\dmin\Desktop\2 курс\4 семестр\МатМод\Лабы\matmod_lab5\matmod_lab5\D.txt')

fig = plt.figure()
ax = fig.gca(projection='3d')

ax.plot_trisurf(X, Y, Z, linewidth=0, antialiased=True)

plt.show()
print(fig)
