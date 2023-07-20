#include "AlcoholicDrinks.h"
#include <iostream>

using namespace std;

AlcoholicDrinks::AlcoholicDrinks(const char* aname, double avolume, const char* aproducer, double apercent) :Drinks::Drinks(aname, avolume, aproducer)
{
	SetPercent(apercent);
}
void AlcoholicDrinks::SetPercent(double a)
{
	if (a > 100)
		throw exception("Error:percent of alcohol can't be more than 100.");
	PercentOfAlcohol = a;
}
double AlcoholicDrinks::GetPercent() const
{
	return PercentOfAlcohol;
}
AlcoholicDrinks::~AlcoholicDrinks()
{

}
void AlcoholicDrinks::Print(ostream& out) const
{
	Drinks::Print(out);
	out << ". Percent of alcohol: " << PercentOfAlcohol;
}