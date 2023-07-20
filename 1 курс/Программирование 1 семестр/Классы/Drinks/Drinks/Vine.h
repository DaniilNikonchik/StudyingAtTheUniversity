#pragma once
#include "AlcoholicDrinks.h"

enum class Color { white, red, pink };

class Vine : public AlcoholicDrinks
{
protected:
	Color ColorOfVine;
	virtual void isAbstract() const {};  //�� �����������
public:
	Vine(const char*, double, const char*, double, const char*);  //�����,������� ������,���,���� ����
	void SetColor(const char*);
	const char* GetColor() const;
	virtual void Print(ostream&) const;
	virtual ~Vine();
};
