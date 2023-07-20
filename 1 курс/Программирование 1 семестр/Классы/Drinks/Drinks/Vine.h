#pragma once
#include "AlcoholicDrinks.h"

enum class Color { white, red, pink };

class Vine : public AlcoholicDrinks
{
protected:
	Color ColorOfVine;
	virtual void isAbstract() const {};  //не абстрактный
public:
	Vine(const char*, double, const char*, double, const char*);  //объем,процент спирта,имя,цвет вина
	void SetColor(const char*);
	const char* GetColor() const;
	virtual void Print(ostream&) const;
	virtual ~Vine();
};
