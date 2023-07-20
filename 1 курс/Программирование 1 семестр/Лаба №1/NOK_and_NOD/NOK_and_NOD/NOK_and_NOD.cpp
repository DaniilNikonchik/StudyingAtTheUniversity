#include <iostream>
using namespace std;
int NOD(int A, int B)
{
	while (A != B)
		if (A > B) A -= B;
		else B -= A;
	return A;
}
int main()
{
	setlocale(LC_ALL, "Rus");
	int A, B;
	cout << "Введите два числа: "; 
	cin >> A >> B;
	cout << "НОД(" << A << ", " << B << ")=" << NOD(A, B);
	cout << "\nНОК(" << A << ", " << B << ")=" << A * B / NOD(A, B) << endl;
	system("pause");
}