#pragma once
#include "NonAlcoholicDrinks.h"

enum class Gas { high, middle, low };

class MineralWater : public NonAlcoholicDrinks
{
protected:
	Gas GasOfWater;
	virtual void isAbstract() const {};//не абстрактный
public:
	MineralWater(const char*, double, const char*, const char*);
	void SetGas(const char*);
	const char* GetGas() const;
	void Print(ostream&) const;
	virtual ~MineralWater();
};