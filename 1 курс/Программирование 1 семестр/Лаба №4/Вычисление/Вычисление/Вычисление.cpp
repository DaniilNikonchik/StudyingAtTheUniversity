#include <iostream>
#include <cmath>
#include <iomanip>
#include <random>
using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");
	double n;
	cout << "Введите точность вычисления: ";
	cin >> n;

	while (n < 0.000001 || n > 1) 
	{
		cout << "Веденное не соответствует условию" << "\nВведите точность вычислений: " << endl;
		cin >> n;
	}

	//Рандомные числа с промежутком
	random_device generator;
	uniform_real_distribution<double> distribution(-1, 1); //потому что функция "sinh" не считает > 700
	double x = distribution(generator);
	cout << "На множестве R выбран x, равный: " << x << "\n";

	//Подсчёт формулы
	double sum = 0.0;
	double a = x;
	double t = 1;
	while (abs(a) >= n)
	{
		sum += a;
		a *= (x * x / ((t + 1) * (t + 2)));
		t += 2;
	}

	//Функция, сравнение, погрешность
	double func = sinh(x);
	double diff = abs(sum - func);
	cout << setprecision(ceil(log10(1 / n))) << "Результат функции: " << func <<"\nРезультат вычисления гиперболического синуса: " << sum << endl;
	cout << "Погрешность составляет: " << diff << endl;	
	return 0;
}
