#include "money.h"
#include <iostream>
#include <cmath>
using namespace std;


money::money() 
{
	setPennyValue(0);
	pound = 0;
	shilling = 0;
	penny = 0;
	minus = false;
}

money::money(double pennyValue) 
{
	setPennyValue(pennyValue);
	pound = 0;
	shilling = 0;
	penny = 0;
	minus = false;
}

money::money(long long pound, long long shilling, double penny) 
{
	double tmp = penny * 2;
	if (pound > 1000000000 || shilling >= 20 || penny >= 12 || pound < 0 || shilling < 0 || penny < 0 || tmp != (int(tmp))) 
	{
		throw exception("Введено некорректное значение денежных средств!");
	}
	setPennyValue(ConverToPenny(pound, shilling, penny));
}

void money::setPennyValue(double aPennyValue)
{
	pennyValue = aPennyValue;
	if (abs(pennyValue) > 240000000000.0) 
	{
		throw exception("Переполнение количества пенни!");
	}
}

double money::getPennyValue() const 
{
	return pennyValue;
}

void money::Print() {
	PennyConvert(pennyValue);
	if (pound == 0 && shilling != 0) 
	{
		if (minus) 
		{
			cout << "-";
		}
		cout << shilling << "sh." << penny << "p.";
	}
	else if (pound == 0 && shilling == 0) 
	{
		if (minus)
		{
			cout << "-";
		}
		cout << penny << "p.";
	}
	else 
	{
		if (minus) 
		{
			cout << "-";
		}
		cout << pound << "pd." << shilling << "sh." << penny << "p.";
	}
}

double money::ConverToPenny(long long pound, long long shilling, double penny) 
{
	return this->pennyValue = pound * 240 + shilling * 12 + penny;
}

void money::PennyConvert(double& pennyValue) 
{
	if (pennyValue < 0) 
	{
		this->minus = true;
	}
	else if (pennyValue >= 0) 
	{
		this->minus = false;
	}
	this->pound = static_cast<long long>(floor(abs(pennyValue / 240)));
	this->shilling = static_cast <long long> (floor(abs(fmodf(pennyValue, 240) / 12)));
	penny = (abs(pennyValue) - (pound * 240 + shilling * 12));
	this->penny = 0.5 * floor(2.0 * abs(penny)) + 0.5 * floor(4 * fmod(abs(penny), 0.5));
}

money  money::operator - () const 
{ // унарный минус
	return money((-1) * pennyValue);
}

money  money::operator + (const money& p) const 
{

	return money(pennyValue + p.getPennyValue());
}

money  money::operator - (const money& p) const 
{
	return money(pennyValue - p.getPennyValue());
}

money& money::operator+= (const money& p) {
	setPennyValue(pennyValue += p.getPennyValue());
	return *this;
}
money& money::operator-= (const money& p) 
{
	setPennyValue(pennyValue -= p.getPennyValue());
	return *this;
}

bool operator== (const money& p, const money& p1) 
{
	return (p.getPennyValue() == p1.getPennyValue());
}

bool operator!= (const money& p, const money& p1) 
{
	return !(p.getPennyValue() == p1.getPennyValue());
}

bool operator> (const money& p, const money& p1) 
{
	return (p.getPennyValue() > p1.getPennyValue());
}

bool operator< (const money& p, const money& p1) 
{
	return (p.getPennyValue() < p1.getPennyValue());
}

bool operator>= (const money& p, const money& p1) 
{
	return (p.getPennyValue() >= p1.getPennyValue());
}

bool operator<= (const money& p, const money& p1) 
{
	return (p.getPennyValue() <= p1.getPennyValue());
}