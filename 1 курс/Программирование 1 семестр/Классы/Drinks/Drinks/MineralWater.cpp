#include "MineralWater.h"

string gas[] = { "high","middle","low" };

MineralWater::MineralWater(const char* aname, double avolume, const char* aproducer, const char* agas) :NonAlcoholicDrinks::NonAlcoholicDrinks(aname, avolume, aproducer)
{
	SetGas(agas);
}
const char* MineralWater::GetGas() const
{
	return gas[(int)GasOfWater].c_str();
}
MineralWater::~MineralWater()
{

}
void MineralWater::Print(ostream& out) const
{
	NonAlcoholicDrinks::Print(out);
	out << ". Gas degree: " << gas[(int)GasOfWater].c_str();
}
void MineralWater::SetGas(const char* agas)
{
	int i = 0;
	for (; i < 3; i++)
		if (strcmp(agas, gas[i].c_str()) == 0)
		{
			GasOfWater = (Gas)i;
			break;
		}
	if (i == 3)
		throw exception("Error: incorrect gas degree of mineral water.");
}