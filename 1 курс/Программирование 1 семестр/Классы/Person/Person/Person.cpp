#include <iostream>
#include "Person.h"
#include "PersonException.h"
#include <string>
#include <vector>
#pragma warning(disable : 4996)

using namespace std;

int Person::next_ID = 0; 

Person::Person(const char* aname, Gender agender, const Person* amother, const Person* afather) : ID(++next_ID)  //���������� ������������ 
{
	Test(aname, agender);

	if (amother == NULL)
		throw exception("Invalid parameter (NULL)"); // ����������
	if (amother->gender != Gender::woman)
		throw exception("Only woman can be mother!"); // ����������
	

	mother = amother;

	if (afather != NULL && afather->gender != Gender::man)
		throw exception("Only men can be father!"); // ����������

	father = afather;
}

Person::Person(const char* aname, Gender agender) : ID(++next_ID)
{
	Test(aname, agender);
	if (this->ID != 1 && this->ID != 2)
		throw exception("Who is mother?"); // ����������
}

void Person::Test(const char* aname, Gender agender) // ���������� ������ Test
{
	if (aname == NULL)
		throw exception("Invalid parameter (NULL)"); // ����������
	if (aname[0] == '\0')
		throw exception("Invalid name length"); // ����������

	name = new char[strlen(aname) + 1];
	strcpy(name, aname);

	gender = agender;

}

Person::Person(const Person& d) : ID(++next_ID) // ���������� � ������������� ������ Clone
{
	Clone(d);
}

void Person::Clone(const Person& p) // ���������� ������������ �����������  // �����, ����������� ������� ������� �������(Clone)
{
	name = new char[strlen(p.name) + 1];
	strcpy(name, p.name);
	gender = p.gender;
	mother = p.mother;
	father = p.father;
}

void Person::Erase() // �����, ������������� ��� ������� �������� �������(Erase);
{
	delete[] name;
}

Person::~Person() // ���������� ����������� // ���������� � ������������� ������ Erase
{
	Erase();
}

int Person::GetID() const // ���������� get-������ ��� ID
{
	return this->ID;
}

const char* Person::GetName() const // ���������� get-������ ��� �����
{
	return this->name;
}

Person::Gender Person::GetGender() const // ���������� get-������ ��� ����
{
	return this->gender;
}

const char* Person::GetMother() const // ���������� get-������ ��� ������
{
	if (this->ID == 0 || this->ID == 1)
		throw exception("This person's mother is secret"); // ����������
	return mother->GetName();
}

const char* Person::GetFather() const // ���������� get-������ ��� ����
{
	if (this->ID == 0 || this->ID == 1)
		throw exception("This person's father is secret"); // ����������
	if (this->father == 0)
		throw exception("This person's father is unknown"); // ����������
	return father->GetName();
}

const Person& Person :: operator = (const Person& p) // ���������� �������� ������������
{
	if (this != &p)
	{
		Erase();
		Clone(p);
	}
	return *this;
}

ostream& operator << (ostream& s, const Person& p)
{
	s << "Name: " << p.name << endl	<< "Gender: " << (p.gender == Person::Gender::man ? "man" : "woman") << endl;
	if (p.ID != 1 && p.ID != 2)
	{
		s << "Mother: " << p.GetMother() << endl;
		if (p.father)
			s << "Father: " << p.GetFather() << endl;
		else 
		{
			cout << "Father is unknown:(" << endl;
		}
	}
	else
	{ 
		cout << " "; 
	}
	return s;
}

const Person* Person::GiveBirth(const char* aname, Gender agender, const Person* afather) const // ���������� ������ GiveBrith, � ���������� ������������ //  � �����
{
	if (aname == NULL)
		throw exception("Invalid parameter (NULL)"); // ����������
	if (aname[0] == '\0')
		throw exception("Invalid name length"); // ����������

	const char* name = aname;
	Gender gender = agender;

	if (this->gender != Gender::woman)
		throw exception("Only woman can be mother!"); // ����������

	const Person* mother = this;
	if (afather != NULL && afather->gender != Gender::man)
		throw exception("Only men can be father!"); // ����������

	const Person* father = afather;

	const Person* child = new Person(name, gender, mother, father);
	return child;
}

const Person* Person::GiveBirth(const char* aname, Gender agender) const  // ���������� ������ GiveBrith // ��� ����
{
	return GiveBirth(aname, agender, NULL);
}