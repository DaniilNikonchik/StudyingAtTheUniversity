#include <iostream>
#include <cstring>
#pragma warning(disable: 4996)

using namespace std;
int main() 
{
	setlocale(LC_ALL, "Russian");
	char* s = new char[300];
	char* ans = new char[300];
	ans[0] = '\0';
	cout << "Enter the string : ";
	cin.getline(s, 300);
	long n = strlen(s), beg = 0; //начало строки 
	bool b = true;
	for (int i = 0; i < n; i++)
	{
		if (s[i] == ' ' || i == n - 1) 
		{
			if (b && i - beg != 0) 
			{
				strncpy(ans, s + beg, i - beg + 1);
				ans[i - beg + 1] = 0;
			}
			b = true;
			beg = i + 1;
		}
		if (i == n - 1)
			break;

		if (s[i] != ' ' && s[i] < s[i + 1])
			b = false;
	}
	if (strlen(ans) > 0)
		cout << "Word with characters descending: " << ans;
	else
		cout << "String not found";
	delete[] s;
	delete[] ans;
	return 0;
}