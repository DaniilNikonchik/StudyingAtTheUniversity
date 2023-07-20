#pragma once
#include <exception>

class DequeException : public std::exception
{
public:
	DequeException(const char* const msg) : std::exception(msg) {}
	DequeException(const DequeException& right) : std::exception(right) {}
};