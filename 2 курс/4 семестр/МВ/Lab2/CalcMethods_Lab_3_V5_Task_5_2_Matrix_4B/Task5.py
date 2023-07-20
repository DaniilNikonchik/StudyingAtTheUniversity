import matplotlib.pyplot as plt
import numpy as np
import time

# Требуемая точность (для итераций)
Epsilon = 0.00000001

# Параметры для разреженных матриц
MatrixParameter_a = 10  # При параметре a = 1 из условия сходимость не наблюдалась
MatrixParameter_b = -2

# Функция генерирующая нашу матрицу по заданной размерности
def GenerateSpecificMatrix(N, a, b):
    NeededMatrix = np.zeros((N, N))
    for i in range(N):
        NeededMatrix[i][i] = a
        NeededMatrix[N - i - 1][i] = b
    return NeededMatrix

# НормА невязки || A*X = b || --> min
def ResidualRate(A, X):
    AX = np.dot(A, X)
    AX_b = AX - b
    return np.linalg.norm(AX_b)

# Решение СЛАУ методом Гаусса-Зейделя
def GaussSeidel(A, b, ResRateArr):
    StartTime = time.time()
    N = len(A)  # Запоминаем размер текущей матрицы A
    Xk = np.zeros(N)  # Текущий вектор-ответ
    CurrResidualRate = 1  # Текущая невязка
    IterationsAmount = 0  # Количество итераций
    while CurrResidualRate > Epsilon:  # До тех пор, пока невязка не станет меньше точности, выполняем итерации
        IterationsAmount += 1  # На каждой итерации приплюсовываем единицу к счетчику итераций
        Xk_1 = np.zeros(N)  # Вектор-ответ, который будет получен на следующей итерации
        for i in range(N):
            FirstSum = 0
            for j in range(i):
                FirstSum += (A[i][j] * Xk_1[j])

            SecondSum = 0
            for j in range(i + 1, N):
                SecondSum += (A[i][j] * Xk[j])

            Xk_1[i] = (-FirstSum - SecondSum + b[i]) / A[i][i]
        Xk = np.copy(Xk_1)  # Говорим, что теперь текущий вектор-ответ - это насчитанный нами в новой итерации вектор
        CurrResidualRate = ResidualRate(A, Xk)
        ResRateArr.append(CurrResidualRate)  # Добавляем текущую невязку в список невязок для графика

    print("После", IterationsAmount, "итерации был подобран Xk =", Xk)

    print("Общее время работы процесса: %s seconds" % (time.time() - StartTime))

    return IterationsAmount  # По завершении процесса возвращаем количество итераций, которое нам понадобилось

# Проверим работу программы на матрицах размерностей: 6, 8, 10, 12, 14, 100
ResRateArr = []  # Список списков ординат (норм невязки на разных итерациях для графика матрицы размерности i)
IterAmount = []  # Список количеств итераций, который понадобились каждому процессу
for i in range(6, 17, 2):
    if i == 16:
        i = 100  # Для размерности 100
    print("\n------------------------------------------------------------------------------------------------\n")
    print("Размерность текущей матрицы N =", i)
    CurrRateArr = []  # Список ординат (норм невязки на разных итерациях) для графика матрицы размерности i
    A = GenerateSpecificMatrix(i, MatrixParameter_a, MatrixParameter_b)
    print("A =\n", A)
    X = np.ones(i)  # Пуская вектором-ответом всегда будет вектор, состоящий из N единичек (так удобнее)
    b = np.dot(A, X)  # Тогда вектор b = A*X
    print("При X =", X, "\n b =", b)
    IterAmount.append(GaussSeidel(A, b, CurrRateArr))  # Запоминаем потребовавшееся количество итераций
    ResRateArr.append(CurrRateArr)  # Также запоминаем список невязок для текущего процесса

for i in range(6):
    LabelNum = 6 + i*2
    if LabelNum == 16:
        LabelNum = 100
    plt.semilogy(np.arange(1, IterAmount[i] + 1), ResRateArr[i], label="N = "+str(LabelNum))
plt.xlabel("Номер итерации")
plt.ylabel("Норма невязки на этой итерации")
plt.legend()
plt.show()