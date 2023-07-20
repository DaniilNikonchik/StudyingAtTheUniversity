#include "money.h"
#include <iostream>
#include <string>
#include <cmath>
#include "money_exception.h"

using namespace std;

int main() 
{
	setlocale(LC_ALL, "Russian");
	try 
	{
		int pd, sh;
		double p;

		cout << "Введите количество фунтов: " << endl;
		cin >> pd;
		cout << "Введите количество шиллингов: " << endl;
		cin >> sh;
		cout << "Введите количество пенни:" << endl;
		cin >> p;
		money a(pd, sh, p);

		cout << "\n*********************************\n";
		cout << "Операции сравнения: " << endl;
		
		money b(0, 0, 1);
		cout << "Ваш введенный баланс: ";
		a.Print();
		cout << "\nБаланс по умолчанию: ";
		b.Print();

		if (a == b) 
		{
			cout << "\nОператор == : true" << endl;
		}
		else
		{
			cout << "\nОператор == : false" << endl;
		}
		
		if (a != b) 
		{
			cout << "Оператор != : true" << endl;
		}
		else 
		{
			cout << "Оператор != : false" << endl;
		}

		if (a > b) 
		{
			cout << "Оператор > : ваш баланс больше" << endl;
		}
		
		if (a < b) 
		{
			cout << "Оператор < : ваш баланс меньше" << endl;
		}

		if (a >= b) 
		{
			cout << "Оператор >= : ваш баланс больше или равен балансу по умолчанию" << endl;
		}
		
		if (a <= b) 
		{
			cout << "Оператор <= : ваш баланс меньше или равен балансу по умолчанию" << endl;
		}
		
		cout << "\n*********************************";
		cout << "\nОперации +, -, +=, -= и унарный - : \n";
		cout << "Оператор + : ";
		(a + b).Print();

		cout << "\nОператор - : ";
		(a - b).Print();

		cout << "\nОператор += : ";
		(a += b).Print();

		cout << "\nОператор -= : ";
		(a -= b).Print();

		cout << "\nОператор унарный минус : ";
		(-a).Print();
	}

	catch (const exception & error) 
	{
		cout << "Error: " << error.what() << endl;
	}

	return 0;
}