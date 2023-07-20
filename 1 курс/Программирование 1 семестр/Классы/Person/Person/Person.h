#pragma once
#include <cstring>
#include <string>

using namespace std;

class Person
{
public:
	enum class Gender
	{
		man,  // man ��������� ������
		woman
	};
	Person(const char*, Gender, const Person*, const Person*);
	Person(const char*, Gender); // �����������, � ������� ���������� ��� 
	Person(const Person&); // ����������� �����������

	const Person& operator = (const Person&); // ���������� �������� ������������
	
	Gender GetGender() const;  // get-����� ��� ����
	const char* GetName() const;  // get-����� ��� �����
	const char* GetMother() const;  // get-����� ��� ������
	const char* GetFather() const;  // get-����� ��� ����
	int GetID() const;  // get-����� ��� ID

	~Person();  // ����������
	const Person* GiveBirth(const char*, Gender) const; // ����� GiveBrith
	const Person* GiveBirth(const char*, Gender, const Person*) const; // ����� GiveBrith � ���������� ������������ 

	friend ostream& operator << (ostream&, const Person&);  

private:
	char* name; // ������������ ���� � ��� ��������
	static int next_ID;
	const int ID;
	Gender gender;
	void Erase(); // �����, ������������� ��� ������� �������� �������(Erase)
	void Clone(const Person&); // �����, ����������� ������� ������� �������(Clone)
	void Test(const char*, Gender); // ��� ���� // ��� ��������
	const Person* mother;
	const Person* father;
};
