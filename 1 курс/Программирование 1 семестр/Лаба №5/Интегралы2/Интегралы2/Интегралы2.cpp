#include <iostream>
#include <cmath>
#include <conio.h>

using namespace std;
int N;
double foo1(double x)
{
	return 1 / ((x + 1) * (sqrt(x * x) + 1));
}
double foo2(double x)
{
	return sqrt(pow(2, x) - 1);
}
double foo3(double x)
{
	return sqrt(exp(x) - 1);
}
double f_integral(double foo(double), double a, double b, double accurate)
{
	double I = accurate + 1, I1 = 0;//I-предыдущее вычисленное значение интеграла, I1-новое, с большим N.
	for (N = 2; fabs(I1 - I) > accurate; N *= 2)
	{
		double h, sum2 = 0, sum4 = 0, sum = 0;
		h = (b - a) / (2 * (double) N);//Шаг интегрирования.
		for (int i = 1; i <= 2 * N - 1; i += 2)
		{
			sum4 += foo(a + (h * (double) i));//Значения с нечётными индексами, которые нужно умножить на 4.
			sum2 += foo(a + (h * i + 1));//Значения с чётными индексами, которые нужно умножить на 2.
		}
		sum = (foo(a) + (4 * sum4) + (2 * sum2) - foo(b));//Отнимаем значение f(b) так как ранее прибавили его дважды.
		I = I1;
		I1 = (h / 3) * sum;
	}
	return I1;
}
int main()
{
	setlocale(LC_ALL, "rus");
	double accurate;
	cout << "Введите точность " << endl;
	for (;;)
	{
		cin >> accurate;
		if (accurate <= 0.1 && accurate >= 0.0000001)
			break;
		else
			cout << "Введите точность от 0.0000001 до 0.1" << endl;
	}

	double a1 = 0, b1 = 0.6, a2 = 0.2, b2 = 1, a3 = 0.1, b3 = 1;
	double(*fun1)(double x) = foo1;
	double(*fun2)(double x) = foo2;
	double(*fun3)(double x) = foo3;
	cout << "ВОТ ЗНАЧЕНИЕ ИНТЕГРАЛА 1" << f_integral(fun1, a1, b1, accurate) << endl;
	cout << "ВОТ ЗНАЧЕНИЕ ИНТЕГРАЛА 2" << f_integral(fun2, a2, b2, accurate) << endl;
	cout << "ВОТ ЗНАЧЕНИЕ ИНТЕГРАЛА 3" << f_integral(fun3, a3, b3, accurate) << endl;
	cout << "Количество разбиений: " << N << endl;
}