#include <iostream>
using namespace std;
int main()
{
	setlocale(LC_ALL, "Rus");
	int a = 0, b = 0;
	cout << "Введите промежуток: ";
	cin >> a >> b;
	if (a > b)
	{
		int tmp = b;
		b = a;
		a = tmp;
	}
	cout << "Пифагоровы тройки чисел от "
		<< a << " до " << b << " включительно:" << endl;
	for (int i = a; i <= b; i++)
	{
		for (int j = a; j <= b; j++)
		{
			for (int k = a; k <= b; k++)
			{
				if ((i * i) + (j * j) == k * k)
					cout << "( " << i << ";" 
					<< j << ";" << k << ")" << endl;
			}
		}
	}

	return 0;
}