#pragma once
#include "drinks.h"
#include <iostream>

using namespace std;

class AlcoholicDrinks : public Drinks
{
protected:
	double PercentOfAlcohol;
	virtual void isAbstract() const = 0 {};
public:
	AlcoholicDrinks(const char*, double, const char*, double);
	void SetPercent(double);
	double GetPercent() const;
	virtual void Print(ostream&) const;
	virtual ~AlcoholicDrinks();
};

