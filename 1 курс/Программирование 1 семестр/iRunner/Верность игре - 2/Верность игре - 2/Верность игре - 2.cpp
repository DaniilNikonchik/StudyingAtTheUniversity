﻿#include <iostream>
#include <time.h>
#include <algorithm>
#include <string>
#include <ctype.h>
#include <locale>
#include <cstdlib>

using namespace std;

int main()
{
	int god;
	cin >> god;
	if (god == 1)
		god = 366;
	else if (god == 0)
		god = 365;

	int k;	
	cin >> k;

	int day, month;
	char slesh;	
	int* arr = new int[k];
	for (int i = 0; i < k; i++)
	{
		cin >> day >> slesh >> month;
		if (god == 366)
		{
			if (month == 1)
				day;
			if (month == 2)
				day = 31 + day;
			if (month == 3)
				day = 60 + day;
			if (month == 4)
				day = 91 + day;
			if (month == 5)
				day = 121 + day;
			if (month == 6)
				day = 152 + day;
			if (month == 7)
				day = 182 + day;
			if (month == 8)
				day = 213 + day;
			if (month == 9)
				day = 244 + day;
			if (month == 10)
				day = 274 + day;
			if (month == 11)
				day = 305 + day;
			if (month == 12)
				day = 335 + day;
		}

		if (god == 365)
		{
			if (month == 1)
				day;
			if (month == 2)
				day = 31 + day;
			if (month == 3)
				day = 59 + day;
			if (month == 4)
				day = 90 + day;
			if (month == 5)
				day = 120 + day;
			if (month == 6)
				day = 151 + day;
			if (month == 7)
				day = 181 + day;
			if (month == 8)
				day = 212 + day;
			if (month == 9)
				day = 243 + day;
			if (month == 10)
				day = 273 + day;
			if (month == 11)
				day = 304 + day;
			if (month == 12)
				day = 334 + day;
		}
		arr[i] = day;
	}
	sort(arr, arr + k);
	int fishki = 1000, coins = 0, s = 2;
	for (int i = 1; i < k; i++)
	{
		if (arr[i] != arr[i - 1] + 1)
			s = 1;
		if (s == 1)
			fishki += 1000;
		else if (s == 2)
			fishki += 5000;
		else if (s == 3 || s == 4)
			fishki += 3000;
		else if (s == 5)
		{
			coins += 3;
			s = 0;
		}
		s++;
	}
	cout << fishki << " " << coins;

	delete[] arr;
	return 0;
}





/*
1
3
06/01
06/06
06/12
*/