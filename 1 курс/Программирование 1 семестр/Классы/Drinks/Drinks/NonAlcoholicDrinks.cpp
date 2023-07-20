#include "NonAlcoholicDrinks.h"
#include <iostream>

using namespace std;

NonAlcoholicDrinks::~NonAlcoholicDrinks()
{

}
void NonAlcoholicDrinks::Print(ostream& out) const
{
	Drinks::Print(out);
}
NonAlcoholicDrinks::NonAlcoholicDrinks(const char* aname, double avolume, const char* aproducer) :Drinks::Drinks(aname, avolume, aproducer)
{
}