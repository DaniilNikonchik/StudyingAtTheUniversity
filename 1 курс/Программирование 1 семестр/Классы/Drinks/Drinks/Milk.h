#pragma once
#include "NonAlcoholicDrinks.h"

class Milk : public NonAlcoholicDrinks
{
protected:
	virtual void isAbstract() const {};//не абстрактный
	double PercentOfFat;
public:
	Milk(const char*, double, const char*, double);
	virtual ~Milk();
	void SetPercentOfFat(double);
	double GetPercentOfFat() const;
	virtual void Print(ostream&) const;
};