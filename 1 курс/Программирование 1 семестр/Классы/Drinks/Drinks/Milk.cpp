#include "Milk.h"

Milk::Milk(const char* aname, double avolume, const char* aproducer, double apercent) :NonAlcoholicDrinks::NonAlcoholicDrinks(aname, avolume, aproducer)
{
	SetPercentOfFat(apercent);
}
Milk::~Milk()
{

}
double Milk::GetPercentOfFat() const
{
	return PercentOfFat;
}
void Milk::Print(ostream& out) const
{
	NonAlcoholicDrinks::Print(out);
	out << ". Percent of fat: " << PercentOfFat;
}
void Milk::SetPercentOfFat(double apercent)
{
	if (apercent >= 100)
		throw exception("Error: incorrect percent of milk fat.");
	PercentOfFat = apercent;
}