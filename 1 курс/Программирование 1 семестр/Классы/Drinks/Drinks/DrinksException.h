#pragma once
#include <exception>

class DrinksException : public std::exception
{
public:
	DrinksException(const char* const msg) : std::exception(msg) {}
	DrinksException(const DrinksException& right) : std::exception(right) {}
};