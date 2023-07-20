#pragma once
#include <iostream>
using namespace std;

class Animals
{
private:
	string owner_name;
	string animal_kind;
	string animal_name;
	short animal_age;
public:
	void Set_Ownername(string value_on);
	void Set_Animalkind(string value_ak);
	void Set_Animalname(string value_an);
	void Set_Animalage(short value_aa);
	string Get_Ownername() const;
	string Get_Animalkind() const;
	string Get_Animalname() const;
	short Get_Animalage() const;


};

