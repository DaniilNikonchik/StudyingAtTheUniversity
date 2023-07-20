#include "Beer.h"
#include <iostream>

using namespace std;

string Stock[3] = { "wheat","barley","ginger" };

Beer::Beer(const char* aname, double avolume, const char* aproducer, double apercent, const char* astock) :AlcoholicDrinks::AlcoholicDrinks(aname, avolume, aproducer, apercent)
{
	SetStock(astock);
}
const char* Beer::GetStock() const
{
	return Stock[(int)stock].c_str();
}
void Beer::SetStock(const char* astock)
{
	int i = 0;
	for (; i < 3; i++)
		if (strcmp(astock, Stock[i].c_str()) == 0)
		{
			stock = (StockOfBeer)i;
			break;
		}
	if (i == 3)
		throw exception("Error: incorrect stock of beer.");
}
void Beer::Print(ostream& out) const
{
	AlcoholicDrinks::Print(out);
	out << ". Stock of beer: " << Stock[(int)stock];
}
Beer::~Beer()
{

}