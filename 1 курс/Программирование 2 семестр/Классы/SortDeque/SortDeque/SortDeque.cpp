#include "pch.h"
#include <iostream>
#include <deque>
#include <conio.h>
#include <math.h>
#include <algorithm>
#include <fstream>
#include <string>
#include <exception>
#include <cmath>

using namespace std;

class comp
{
public:
	bool operator()(int a, int b)
	{
		return (abs(a) < abs(b));
	}

};

int main()
{
	setlocale(LC_ALL, "rus");
	deque <double> MyDeque;
	ifstream fin("INSD.txt");
	if (!fin.is_open())
		cout << "Error" << endl;
	else
	{
		if (fin.peek() == EOF)
			cout << "Empty\n";
		else
		{
			try
			{
				double x;
				while (fin >> x)
					MyDeque.push_back(x);
				sort(MyDeque.begin(), MyDeque.end(), comp());
				cout << "Первые пять элементов минимальных по модулю:\n";
				for (int i = 0; i < 5; i++)
				{
					cout << MyDeque[i] << " ";
				}
			}
			catch (exception e)
			{
				cout << "Недопустимый формат входных данных";
			}
			fin.close();
		}
	}
}