#include <iostream>
using namespace std;

int main() 
{
	setlocale(LC_ALL, "Rus");
	int n;
	cout << "Введите количество чисел: " ;
	cin >> n;
	int* a = new int[n]; 
	cout << "Введите числа массива: " ;
	for (int i = 0; i < n; i++) cin >> a[i];
	int max = abs(a[0]);
	for (int i = 0; i < n; i++)
	{
		if (abs(a[i]) > abs(max)) 
		{
			max = a[i];
		}
	}
	cout << "Наибольшее по модулю из " << n << " чисел массива: " << " |" << max << "| " << endl;
	delete[] a;
	return 0;
}