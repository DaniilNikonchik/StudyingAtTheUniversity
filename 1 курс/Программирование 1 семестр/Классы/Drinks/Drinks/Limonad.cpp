#include "Limonad.h"

Limonad::Limonad(const char* aname, double avolume, const char* aproducer, double apercent) :NonAlcoholicDrinks(aname, avolume, aproducer)
{
	SetJuice(apercent);
}
Limonad::~Limonad()
{

}
double Limonad::GetJuice() const
{
	return PercentOfJuice;
}
void Limonad::Print(ostream& out) const
{
	NonAlcoholicDrinks::Print(out);
	out << ". Percent of juice: " << PercentOfJuice;
}
void Limonad::SetJuice(double apercent)
{
	if (apercent > 100)
		throw exception("Error: incorrect percent of juice");
	PercentOfJuice = apercent;
}