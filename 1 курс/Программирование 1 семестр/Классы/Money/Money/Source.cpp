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

		cout << "������� ���������� ������: " << endl;
		cin >> pd;
		cout << "������� ���������� ���������: " << endl;
		cin >> sh;
		cout << "������� ���������� �����:" << endl;
		cin >> p;
		money a(pd, sh, p);

		cout << "\n*********************************\n";
		cout << "�������� ���������: " << endl;
		
		money b(0, 0, 1);
		cout << "��� ��������� ������: ";
		a.Print();
		cout << "\n������ �� ���������: ";
		b.Print();

		if (a == b) 
		{
			cout << "\n�������� == : true" << endl;
		}
		else
		{
			cout << "\n�������� == : false" << endl;
		}
		
		if (a != b) 
		{
			cout << "�������� != : true" << endl;
		}
		else 
		{
			cout << "�������� != : false" << endl;
		}

		if (a > b) 
		{
			cout << "�������� > : ��� ������ ������" << endl;
		}
		
		if (a < b) 
		{
			cout << "�������� < : ��� ������ ������" << endl;
		}

		if (a >= b) 
		{
			cout << "�������� >= : ��� ������ ������ ��� ����� ������� �� ���������" << endl;
		}
		
		if (a <= b) 
		{
			cout << "�������� <= : ��� ������ ������ ��� ����� ������� �� ���������" << endl;
		}
		
		cout << "\n*********************************";
		cout << "\n�������� +, -, +=, -= � ������� - : \n";
		cout << "�������� + : ";
		(a + b).Print();

		cout << "\n�������� - : ";
		(a - b).Print();

		cout << "\n�������� += : ";
		(a += b).Print();

		cout << "\n�������� -= : ";
		(a -= b).Print();

		cout << "\n�������� ������� ����� : ";
		(-a).Print();
	}

	catch (const exception & error) 
	{
		cout << "Error: " << error.what() << endl;
	}

	return 0;
}