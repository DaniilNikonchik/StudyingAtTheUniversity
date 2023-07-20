#pragma once
#include <exception>

class money_exception : public std::exception
{
public:
	money_exception(const char* const msg) : std::exception(msg) {}
	money_exception(const money_exception& right) : std::exception(right) {}
};

