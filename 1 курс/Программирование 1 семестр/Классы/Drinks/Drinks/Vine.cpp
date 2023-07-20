#include "Vine.h"

string color[] = { "white", "red", "purple" };

Vine::Vine(const char* aname, double avolume, const char* aproducer, double apercent, const char* acolor) :AlcoholicDrinks::AlcoholicDrinks(aname, avolume, aproducer, apercent)
{
	SetColor(acolor);
}
Vine::~Vine()
{

}
void Vine::Print(ostream& out) const
{
	AlcoholicDrinks::Print(out);
	out << ". Color of vine: " << color[(int)ColorOfVine];
}
const char* Vine::GetColor() const
{
	return color[(int)ColorOfVine].c_str();
}
void Vine::SetColor(const char* acolor)
{
	int i = 0;
	for (; i < 3; i++)
		if (strcmp(acolor, color[i].c_str()) == 0)
		{
			ColorOfVine = (Color)i;
			break;
		}
	if (i == 3)
		throw exception("Error: uncorrect color of vine.");
}