import random
import timeit
import scipy.special as sc
import math
import scipy.stats as st  # для pvalue


class RunsTest:
    def Test(L):
        numRuns, listOfRuns = RunsTest.getRuns(L)  # Полосы захвата в данных

        # Определяем параметры
        R = numRuns  # количество прогонов
        n1 = sum(L)  # количество единиц
        n2 = len(L) - n1  # количество нулей
        n = n1 + n2  # должен равняться len (L)

        # Запускаем тест
        ww_z = RunsTest.WW_runs_test(R, n1, n2, n)

        # проверить значение pvalue
        p_values_one = st.norm.sf(abs(ww_z))  # односторонний
        p_values_two = st.norm.sf(abs(ww_z)) * 2  # двусторонний

        # Распечатать результаты
        print('Wald-Wolfowitz Runs Test')
        print('Number of runs: %s' % (R))
        print('P value: %s;' % p_values_one)
        print('////////////////////////////////////////////////////////////////////////////')
        print()

    # Находит прогоны в данных: подсчитывает и создает их список
    def getRuns(l):
        runsList = []
        tmpList = []
        for i in l:
            if len(tmpList) == 0:
                tmpList.append(i)
            elif i == tmpList[len(tmpList) - 1]:
                tmpList.append(i)
            elif i != tmpList[len(tmpList) - 1]:
                runsList.append(tmpList)
                tmpList = [i]
        runsList.append(tmpList)

        return len(runsList), runsList

    # определяем тест запуска WW, описанный выше
    def WW_runs_test(R, n1, n2, n):
        # вычислить стандартную ошибку R, если null (случайное значение) истинно
        seR = math.sqrt(((2 * n1 * n2) * (2 * n1 * n2 - n)) / ((n ** 2) * (n - 1)))

        # вычислить ожидаемое значение R, если ноль истинно
        muR = ((2 * n1 * n2) / n) + 1

        # статистика теста: R vs muR
        z = (R - muR) / seR

        return z
