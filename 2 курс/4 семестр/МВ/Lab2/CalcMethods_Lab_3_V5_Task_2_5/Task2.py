import matplotlib.pyplot as plt
import numpy as np
import time

# Размерность матрицы(NxN)
N = 3

# Номер итерационного процесса
ProcessNum = 1

# Требуемая точность (для итераций)
Epsilon = 0.00000001

# Матрица A
A = np.array([[-1., 1., -1.],
              [-1., 4., -2.],
              [2., -3., 5.]])

# Начальное приближение (0, 0, 0):
X0 = np.array([0., 0., 0.])

# В качестве вектора-ответа возьмём вектор (7, 7, 7), 
# тогда вектор b = A*(7, 7, 7) будет таким:
b = np.array([-7., 7., 28.])

# Значения w для экспериментов (w0 - не сходится, 
# w1 - сходится, w2 - единица, w3 и w4 - любые от 0 до 2)
w0 = 2.5
w1 = 1.5
w2 = 1.0
w3 = 0.5
w4 = 0.1


#  Вычисление нормы невязки || A*X = b || --> min
def ResidualRate(X):
    AX = np.dot(A, X)  # A*X
    AX_b = AX - b  # A*X - b
    return np.linalg.norm(AX_b)  # || A*X - b ||


# Решение СЛАУ методом релаксации
def RelaxationMethod(w, ResRateArr):
    print("\n--------------------------------------------------------------------------------------\n")

    global ProcessNum
    print("ПРОЦЕСС №", ProcessNum, "\n")
    ProcessNum += 1

    StartTime = time.time()

    print("Заданная точность Epsilon =", Epsilon)
    print("Начальное приближение X0 =", X0)
    print("Параметр релаксации w =", w)

    L = np.tril(A, k=-1)  # Нижнетреугольная матрица

    R = np.triu(A, k=1)  # Верхнетреугольная матрица

    D = np.diag(np.diag(A))  # Диагональная матрица

    ObrD = np.linalg.inv(D)  # Матрица D^(-1), обратная матрице D

    UnitMatrix = np.eye(N)  # Единичная матрица размера NxN

    I_wOBrDL_Obr = np.linalg.inv(UnitMatrix + w * np.dot(ObrD, L))
    I_1_w_wObrDR = (1 - w) * UnitMatrix - w * np.dot(ObrD, R)

    B = np.dot(I_wOBrDL_Obr, I_1_w_wObrDR)
    print("B = (I + wD^(-1)L)^(-1)*((1-w)I - wD^(-1)R)\nB = ", B)

    NormI_wObrDL_Obr = np.linalg.norm(I_wOBrDL_Obr)  # Норма первой части
    print("1) Norm((I + wD^(-1)L)^(-1)) =", NormI_wObrDL_Obr)

    NormI_1_w_wObrDR = np.linalg.norm(I_1_w_wObrDR)  # Норма второй части
    print("2) Norm((1-w)I - wD^(-1)R) =", NormI_1_w_wObrDR)

    BothPartsMult = NormI_wObrDL_Obr * NormI_1_w_wObrDR  # Произведение обеих частей

    if BothPartsMult < 1.:
        print("Произведение норм двух частей =", BothPartsMult, "< 1.0 => процесс сходится.")
    else:
        print("Произведение норм двух частей =", BothPartsMult, ">= 1.0, требуются дальнейшие исследования...")

        NormB = np.linalg.norm(B)  # Норма матрицы B
        print("Norm(B) = Norm((I + wD^(-1)L)^(-1)*((1-w)I - wD^(-1)R)) =", NormB)

        if NormB < 1.:
            print("Норма матрицы B =", NormB, "< 1.0 => процесс сходится.")
        else:
            print("Норма матрицы B =", NormB, ">= 1.0, требуются дальнейшие исследования...")

            EigenValuesB = np.linalg.eigvals(B)  # Вектор, хранящий в себе собственные значения матрицы B
            print("Собственные значения матрицы B: ", EigenValuesB)
            MaxEigenValueB = 0.
            for i in range(EigenValuesB.size):
                if abs(EigenValuesB[i]) > MaxEigenValueB:
                    MaxEigenValueB = abs(EigenValuesB[i])
            print("Наибольшее по модулю из собственных значений матрицы B =", MaxEigenValueB)

            if MaxEigenValueB < 1.:
                print("Наибольшее по модулю собственное значение матрицы B =", MaxEigenValueB,
                      "< 1.0 => процесс сходится.")
            else:
                print("Наибольшее по модулю собственное значение матриц =", MaxEigenValueB,
                      ">= 1.0 => процесс расходится.")

    print("Процесс начал вычислительные итерации...")

    Xk = X0  # Для нахождения вектора Xk+1 в последующих итерациях
    Xk_1 = np.zeros(N)  # Xk+1 - следующий вектор-ответ
    IterationsAmount = 0  # Количество итераций
    CurrResRate = ResidualRate(Xk)  # Текущая невязка
    while CurrResRate > Epsilon:
        IterationsAmount += 1
        for i in range(N):
            FirstSum = 0
            for j in range(i):
                FirstSum += (A[i, j] * Xk_1[j])

            SecondSum = 0
            for j in range(i + 1, N):
                SecondSum += (A[i, j] * Xk[j])

            Xk_1[i] = (1 - w) * Xk[i] + (w / A[i, i]) * (b[i] - FirstSum - SecondSum)

        Xk = Xk_1  # Вектор Xk+1 в следующей итерации будет просто Xk
        CurrResRate = ResidualRate(Xk)  # Текущая невязка
        ResRateArr.append(CurrResRate)  # Добавляем текущую невязку в список невязок для графика

    print("После", IterationsAmount, "итерации был подобран X =", Xk)

    print("Общее время работы процесса: %s seconds" % (time.time() - StartTime))

    return IterationsAmount


print("\nМатрица A = ", A)
print("Вектор b = ", b)
ResRateArr1 = []  # Список ординат для графика 1-ого процесса
IterAmount1 = RelaxationMethod(w0, ResRateArr1)
IterArr1 = np.arange(1, IterAmount1 + 1)  # Массив абсцисс для графика 1-ого процесса
ResRateArr2 = []  # Список ординат для графика 2-ого процесса
IterAmount2 = RelaxationMethod(w1, ResRateArr2)
IterArr2 = np.arange(1, IterAmount2 + 1)  # Массив абсцисс для графика 2-ого процесса
ResRateArr3 = []  # Список ординат для графика 3-его процесса
IterAmount3 = RelaxationMethod(w2, ResRateArr3)
IterArr3 = np.arange(1, IterAmount3 + 1)  # Массив абсцисс для графика 3-его процесса
ResRateArr4 = []  # Список ординат для графика 3-его процесса
IterAmount4 = RelaxationMethod(w3, ResRateArr4)
IterArr4 = np.arange(1, IterAmount4 + 1)  # Массив абсцисс для графика 4-ого процесса
ResRateArr5 = []  # Список ординат для графика 5-ого процесса
IterAmount5 = RelaxationMethod(w4, ResRateArr5)
IterArr5 = np.arange(1, IterAmount5 + 1)  # Массив абсцисс для графика 5-ого процесса
plt.semilogy(IterArr1, ResRateArr1, label='w0')
plt.semilogy(IterArr2, ResRateArr2, label='w1')
plt.semilogy(IterArr3, ResRateArr3, label='w2')
plt.semilogy(IterArr4, ResRateArr4, label='w3')
plt.semilogy(IterArr5, ResRateArr5, label='w4')
plt.xlabel("Номер итерации")
plt.ylabel("Норма невязки на этой итерации")
plt.legend()
plt.show()
