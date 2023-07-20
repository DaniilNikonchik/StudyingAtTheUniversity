#include <iostream>
using namespace std;
long double fact(int a)
{
	if (a < 0)
		return 0;
	if (a == 0)
		return 1;
	else
		return a * fact(a - 1);
}
int main()
{
	int a;
	setlocale(LC_ALL, "Rus");
	cout<< "Введите число: ";
	cin >> a;
	cout << "Факториал(" << a << ")= " 
		<< fact(a) << endl << endl;
	return 0;
}