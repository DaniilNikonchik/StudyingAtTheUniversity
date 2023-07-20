#pragma once
#include "NonAlcoholicDrinks.h"


class Limonad : public NonAlcoholicDrinks
{
protected:
	virtual void isAbstract() const {};//не абстрактный
	double PercentOfJuice;
public:
	Limonad(const char*, double, const char*, double);
	void SetJuice(double);
	double GetJuice() const;
	void Print(ostream&) const;
	virtual ~Limonad();
};