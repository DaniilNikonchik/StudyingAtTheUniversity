#pragma once
#include "AlcoholicDrinks.h"
class Jack : public AlcoholicDrinks//коньяк
{
protected:
	char* ProducerCountry;
	virtual void isAbstract() const {};//не абстрактный
public:
	Jack(const char*, double, const char*, double, const char*);
	void SetProducerCountry(const char*);
	const char* GetProducerCountry() const;
	virtual void Print(ostream&) const;
	virtual ~Jack();
};
