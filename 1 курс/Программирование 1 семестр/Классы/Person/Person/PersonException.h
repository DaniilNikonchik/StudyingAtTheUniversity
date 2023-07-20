#pragma once
#include <exception>

class PersonException : public std::exception
{
public:
	PersonException(const char* const msg) : std::exception(msg) {}
	PersonException(const PersonException& right) : std::exception(right) {}
};