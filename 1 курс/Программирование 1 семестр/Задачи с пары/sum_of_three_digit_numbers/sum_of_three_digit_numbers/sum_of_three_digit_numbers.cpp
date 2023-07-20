#include <iostream>
using namespace std;
int main()
{
	setlocale(LC_ALL, "Rus");
	int abc, a, b, c;
	cout << "Введите трехзначное число: ";
	cin >> abc;
	if ((abc >= 100) & (abc < 1000))
		a = abc / 100;
		b = (abc/10) % 10;
		c = abc % 10;
	cout << "Сумма= " << a + b + c << "\nЧисло a=" << a << "\nЧисло b=" << b << "\nЧисло c=" << c <<endl;
	return 0;
}



	