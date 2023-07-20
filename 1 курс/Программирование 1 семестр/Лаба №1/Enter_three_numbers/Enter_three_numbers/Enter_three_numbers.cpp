#include <iostream>
using namespace std;
int main() {
	setlocale(LC_ALL, "Russian");
	int a, b, c, min;
	cout << "Введите три числа: " << endl;
	cin >> a >> b >> c;
	if ((a <= b) && (a <= c)) min=a;
	if ((b <= a) && (b <= c)) min=b;
	if ((c <= a) && (c <= b)) min=c;
	cout << "Наименьшее из трёх= "<<min;
	system("pause");
		return 0;

}
	








