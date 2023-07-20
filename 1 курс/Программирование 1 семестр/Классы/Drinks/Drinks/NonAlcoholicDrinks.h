#pragma once
#include "drinks.h"
#include <iostream>

using namespace std;

class NonAlcoholicDrinks : public Drinks
{
protected:
	virtual void isAbstract() const = 0 {};
public:
	NonAlcoholicDrinks(const char*, double, const char*);
	virtual ~NonAlcoholicDrinks();
	virtual void Print(ostream&) const;
};
