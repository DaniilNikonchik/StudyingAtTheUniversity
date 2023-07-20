#pragma once
#include "AlcoholicDrinks.h"

enum class StockOfBeer { wheat, barley, ginger };

class Beer : public AlcoholicDrinks
{
protected:
	StockOfBeer stock;//�� ������ ����� ������
	virtual void isAbstract() const {};//�� �����������
public:
	Beer(const char*, double, const char*, double, const char*);//�����, ������� ������,���, �����
	void SetStock(const char*);
	const char* GetStock() const;
	void Print(ostream&) const;
	virtual ~Beer();
};
//���� � ������ ���������� �� ��������� ������������� ����� �� ��� �� �� ����� � � ������� ������ �� ����� ����� virtual

