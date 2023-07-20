#include "Jack.h"

Jack::Jack(const char* aname, double avolume, const char* aproducer, double apercent, const char* acountry) :AlcoholicDrinks::AlcoholicDrinks(aname, avolume, aproducer, apercent)
{
	SetProducerCountry(acountry);
}
Jack::~Jack()
{
	delete[] ProducerCountry;
}
void Jack::SetProducerCountry(const char* acountry)
{
	ProducerCountry = new char[strlen(acountry) + 1]{};
	strcpy(ProducerCountry, acountry);
}
const char* Jack::GetProducerCountry() const
{
	return ProducerCountry;
}
void Jack::Print(ostream& out) const
{
	AlcoholicDrinks::Print(out);
	out << ". Producer country: " << ProducerCountry;
}