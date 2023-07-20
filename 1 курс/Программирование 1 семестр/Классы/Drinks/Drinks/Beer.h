#pragma once
#include "AlcoholicDrinks.h"

enum class StockOfBeer { wheat, barley, ginger };

class Beer : public AlcoholicDrinks
{
protected:
	StockOfBeer stock;//из какого сырья сделан
	virtual void isAbstract() const {};//не абстрактный
public:
	Beer(const char*, double, const char*, double, const char*);//обьем, процент спирта,имя, сырье
	void SetStock(const char*);
	const char* GetStock() const;
	void Print(ostream&) const;
	virtual ~Beer();
};
//если в классе наследнике не требуется переопредеять метод то его мы не пишем и в базовом классе не пишем слово virtual

