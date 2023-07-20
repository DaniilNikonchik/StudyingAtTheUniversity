#include<iostream>
using namespace std;
int isPalindrome(int n) {
	int n0 = n, m = 0;
	while (n != 0) {
		m *= 10;
		m += n % 10;
		n = n / 10;
	}
	return (m == n0);
}

int main(void) {
	setlocale(LC_ALL, "Rus");
	cout << "Введите n: ";
	int n = 0;
	cin >> n;
	for (int i = 1; i < n; ++i) {
		if (isPalindrome(i)) {
			cout << i << " " << endl;
		}
	}
	return 0;
}