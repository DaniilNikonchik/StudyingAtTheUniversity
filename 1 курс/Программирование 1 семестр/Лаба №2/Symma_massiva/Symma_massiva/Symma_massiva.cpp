#include <iostream>
using namespace std;

int main() {
	setlocale(LC_ALL, "Rus");
	int n;
	cout << "Введите количество чисел: ";
	cin >> n;
	int* a = new int[n];
	cout << "Введите числа массива: ";
	for (int i = 0; i < n; i++) 
		cin >> a[i];
	int p1 = -1, p2 = -1;
	for (int i = 0; i < n; ++i)
	{
		if (a[i] > 0)
		{
			if (p1 == -1) 
				p1 = i;
			else if (p2 == -1) 
				p2 = i;
		}
	}
	int sum = 0;
	if (p2 - p1 != 1)
	{
		for (int i = p1 + 1; i < p2; ++i)
		{
			sum += a[i];
		}
	}
	if (p1 == -1 || p2 == -1) 
	{
		cout << "В массиве либо всего одно, либо совсем нет положительных чисел";
		return 0;
	}
	cout << "Сумма элементов между первыми положительными числами равна: " << sum << endl;
	delete[] a;
	return 0;
}
