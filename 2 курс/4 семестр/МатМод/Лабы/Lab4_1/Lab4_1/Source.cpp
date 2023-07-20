#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int n = 100;

	double* x = new double[n];
	double* a = new double[n];
	int i, j;
	double lj;


	double sum = 0;
	for (i = 0; i < n; i++)
	{
		x[i] = rand() / 32767.0;
		j = 0;

		a[i] = sin(x[i]) / x[i];
		sum += a[i];
		cout << a[i] << endl;
	}
	cout << endl << endl;

	cout << (sum / n);

	cin >> i;
	delete[] a;
	delete[] x;

	return 1;
}