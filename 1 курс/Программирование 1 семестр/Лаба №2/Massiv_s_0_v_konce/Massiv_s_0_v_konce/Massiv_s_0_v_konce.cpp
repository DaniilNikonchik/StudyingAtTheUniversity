#include <iostream>
using namespace std;
int main()
{
	setlocale(LC_ALL, "Rus");
	int n, i;
	cout << "Введите количество элементов массива: " ;
	cin >> n;
	double* a = new double[n + 1], t;
	cout << "Введите элементы массива: " ;
	for (i = 1; i <= n; i++)
		cin >> a[i];
	int k = 1;
	for (i = 1; i <= n; i++)
		if (a[i] != 0)
		{
			t = a[i];     //если число не ноль, то меняем a[i] и a[k] местами, уменьшаем k.
			a[i] = a[k];
			a[k] = t;
			k++;
		}
	cout << "Измененный массив: ";
	for (i = 1; i <= n; i++)
		cout << a[i] << " ";
	delete[] a;
	return 0;
}