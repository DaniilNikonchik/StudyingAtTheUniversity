#include <iostream>
#include "Beer.h"
#include "Jack.h"
#include "Limonad.h"
#include "MineralWater.h"
#include "Milk.h"
#include "Vine.h"
#include <exception>
#include <vector>

using namespace std;

int main()
{
	setlocale(LC_ALL, "rus");
	vector<Drinks*> v;
	v.push_back(new Beer("�������-9", 0.5, "���������� ������������ �������� ��������", 4.5, "wheat"));
	v.push_back(new Vine("������� �������� Screaming Eagle", 1, "Napa Valley", 5, "purple"));
	v.push_back(new Jack("Jack Daniel's", 0.7, "Jack Daniel", 6, "USA"));
	v.push_back(new Milk("�������������", 1.4, "�������������", 5));
	v.push_back(new Limonad("��������", 1.5, "�����", 7));
	v.push_back(new MineralWater("�������-4", 2, "����", "high"));
	int s = v.size();
	for (int i = 0; i < s; i++)
	{
		v[i]->Print(cout);
		cout << endl;
	}
	for (int i = 0; i < s; i++)
		delete v[i];
}