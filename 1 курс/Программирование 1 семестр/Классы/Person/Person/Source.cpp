#include <iostream>
#include "Person.h"
#include "PersonException.h"
#include <vector>
#include <string>

using namespace std;

int main()
{
	cout << "Welcome!" << endl;
	setlocale(LC_ALL, "RUS");

	const Person* Adam, * Eve, * Kain, * Maria, * Error, * Error1, * Error2;
	try
	{
		Adam = new Person("Adam", Person::Gender::man);                       // конструктор  для Адама и Евы (без матери)
		Eve = new  Person("Eve", Person::Gender::woman);
		cout << *Adam << endl;
		cout << *Eve << endl;
		Maria = Eve->GiveBirth("Maria", Person::Gender::woman);                 // метод Givebirth bез указания отца
		cout << *Maria << endl;
		// const Person * Error = new Person ("Error", "men");    //  попытка создать персонажа без матери
	}
	catch (const exception & error)
	{
		cout << error.what() << endl;
		return 1;
	}

	try
	{
		//cout << Adam->GetFather() << endl;                          // попытка обратиться к отцу АДАМА
		Kain = Eve->GiveBirth("Kain", Person::Gender::man, Adam);                // метод Givebirth с указанием отца
		cout << *Kain << endl;
		// Error1 = Adam->GiveBirth("Error", "woman", Adam);            //  попытка создания персонажа с неподходящим гендером матери

		// Error2 = new Person("Error", "men", Eve, Eve);                // попытка создания персонажа с неподходяим гендером отца

		// const Person* Error3 = new Person("Error3", "mn");           // попытка создания персонажа с неподходящим гендером
	}
	catch (const exception & error)
	{
		cout << error.what() << endl;
		return 1;
	}

	vector <const Person*> People;
	People.push_back(Adam);
	People.push_back(Eve);
	People.push_back(Maria);
	People.push_back(Kain);
	try
	{
		for (int i = 0; ; )
		{
			if (i == People.size())
				i = 0;
			cout << "Do you want to create person?(1 - yes, 0 - no)" << endl;
			int yesno;
			cin >> yesno;
			if (yesno == 1)
			{
				char name[50];
				char o[90];
				if (i % 2 == 0)
					cout << "It is a girl!" << endl;
				else
					cout << "It is a boy!" << endl;
				cout << "Enter Name: " << endl;
				cin.getline(o, 90);
				cin.getline(name, 50);

				cout << "Who is going to be parents?" << endl;

				cout << "Choose mother:" << endl;
				for (int i = 0; i < People.size(); i++)
				{
					if (People[i]->GetGender() == Person::Gender::woman)
						cout << People[i]->GetName() << " -- " << i << endl;
				}
				int mother;
				cin >> mother;

				cout << "Choose father:" << endl;
				for (int i = 0; i < People.size(); i++)
				{
					if (People[i]->GetGender() == Person::Gender::man)
						cout << People[i]->GetName() << " -- " << i << endl;
				}
				int father;
				cin >> father;

				Person::Gender gender;
				const Person* s;

				if (i % 2 == 0)
					gender = Person::Gender::woman;
				else
					gender = Person::Gender::man;
				s = People[mother]->GiveBirth(name, gender, People[father]);
				People.push_back(s);
				i++;
			}
			else
				break;
		}
	}
	catch (const exception & error)
	{
		cout << error.what() << endl;
		return 1;
	}

	for (int i = 4; i < People.size(); i++)
	{
		cout << *People[i] << endl;
	}

	for (int i = 0; i < People.size(); i++)
	{
		delete People[i];
	}

	return 0;
}