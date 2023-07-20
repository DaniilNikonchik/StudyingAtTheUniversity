#include "Animals.h"

void Animals::Set_Ownername(string value_on)
{
	owner_name = value_on;
}

void Animals::Set_Animalkind(string value_ak)
{
	animal_kind = value_ak;
}

void Animals::Set_Animalname(string value_an)
{
	animal_name = value_an;
}

void Animals::Set_Animalage(short value_aa)
{
	animal_age = value_aa;
}

string Animals::Get_Ownername() const
{
	return owner_name;
}

string Animals::Get_Animalkind() const
{
	return animal_kind;
}

string Animals::Get_Animalname() const
{
	return animal_name;
}

short Animals::Get_Animalage() const
{
	return animal_age;
}

