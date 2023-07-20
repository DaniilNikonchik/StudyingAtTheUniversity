#pragma once
#include <exception>
#include <iostream>
#include <ctime>
#include <string>
#include <vector>
#pragma warning(disable:4996)

using namespace std;

class Drinks
{
protected:
	double volume;
	char* name;
	char* producer;
	virtual void isAbstract() const = 0 {};//этот метод переписать во все мои классы но в классах не абстрактных сделать его без конст 0
public:
	Drinks(const char*, double, const char*);
	void SetVolume(double);
	double GetVolume() const;
	void SetName(const char*);
	const char* GetName() const;
	void SetProducer(const char*);
	const char* GetProducer() const;
	virtual void Print(ostream&) const;
	virtual ~Drinks();
};
//если в классе наследнике не требуется переопредеять метод то его мы не пишем и в базовом классе не пишем слово virtual

class drinks_exception : public exception
{
public:
	drinks_exception(const char* message) : exception(message) {};
	drinks_exception(const drinks_exception& mistake) :exception(mistake) {};
};
