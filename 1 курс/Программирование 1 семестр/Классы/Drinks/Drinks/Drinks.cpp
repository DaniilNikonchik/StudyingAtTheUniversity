#include "drinks.h"
#include <exception>
#include <iostream>
#pragma warning(disable:4996)

using namespace std;

Drinks::Drinks(const char* aname, double avolume, const char* aproducer)
{
	SetName(aname);
	SetVolume(avolume);
	SetProducer(aproducer);
}
void Drinks::SetVolume(double avolume)
{
	volume = avolume;
}
double Drinks::GetVolume() const
{
	return volume;
}
void Drinks::SetName(const char* aname)
{
	name = new char[strlen(aname) + 1]{};
	strcpy(name, aname);
}
const char* Drinks::GetName() const
{
	return name;
}
void Drinks::SetProducer(const char* aproducer)
{
	producer = new char[strlen(aproducer) + 1]{};
	strcpy(producer, aproducer);
}
const char* Drinks::GetProducer() const
{
	return producer;
}
void Drinks::Print(ostream& out) const
{
	out << "Name: " << name << ". Volume: " << volume << " litres. Producer: " << producer;
}
Drinks::~Drinks()
{
	delete[] name;
	delete[] producer;
}