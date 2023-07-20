#pragma once
#include <cstring>
#include <string>

using namespace std;

class Person
{
public:
	enum class Gender
	{
		man,  // man находится внутри
		woman
	};
	Person(const char*, Gender, const Person*, const Person*);
	Person(const char*, Gender); // конструктор, в который передается пол 
	Person(const Person&); // конструктор копирования

	const Person& operator = (const Person&); // реализация операции присваивания
	
	Gender GetGender() const;  // get-метод для пола
	const char* GetName() const;  // get-метод для имени
	const char* GetMother() const;  // get-метод для матери
	const char* GetFather() const;  // get-метод для отца
	int GetID() const;  // get-метод для ID

	~Person();  // деструктор
	const Person* GiveBirth(const char*, Gender) const; // метод GiveBrith
	const Person* GiveBirth(const char*, Gender, const Person*) const; // метод GiveBrith с возможными исключениями 

	friend ostream& operator << (ostream&, const Person&);  

private:
	char* name; // единственное поле – имя человека
	static int next_ID;
	const int ID;
	Gender gender;
	void Erase(); // метод, освобождающий все занятые объектом ресурсы(Erase)
	void Clone(const Person&); // метод, клонирующий ресурсы другого объекта(Clone)
	void Test(const char*, Gender); // для пола // для проверки
	const Person* mother;
	const Person* father;
};
