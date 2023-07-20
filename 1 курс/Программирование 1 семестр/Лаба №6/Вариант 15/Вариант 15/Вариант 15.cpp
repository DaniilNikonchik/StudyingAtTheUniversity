#include <iostream>
using namespace std;

char* my_strcpy(char* p, const char* v)
{
	char* st = p;
	while (*v)
		*(p++) = *(v++);
	++(*p) = '\0';
	return st;
}

int my_strlen(char* str)
{
	int result = 0;
	while (str[result] != '\0')
		result++;
	return result;
}

char* padl(char* string, int len, int c = ' ')
{ // Функция padl для части А
	char* new_str = new char[len + 1];
	int source_len = my_strlen(string);
	if (len <= source_len)
	{
		my_strcpy(new_str, string + source_len - len);
	}
	else
	{
		int difference = len - source_len;
		for (int i = difference - 1; i >= 0; --i)
			new_str[i] = c;
		my_strcpy(new_str + difference, string);
	}
	return new_str;
}

int main()
{
	cout << "PART A" << endl;
	char* new_str; // Здесь будем хранить новую строку (которая получится)
	cout << "Enter the string to be worked with function padl: ";
	char* source = new char[256]; // Здесь храним исходную строку
	cin.getline(source, 256); // Считываем исходную строку
	cout << "Enter the size of new string: ";
	int size = NULL;
	cin >> size; // Вводим желаемый размер для новой строки
	cout << "Enter the symbol to be added to string by function padl: ";
	char symb = NULL;
	cin >> symb; // Вводим символ, которым мы хотим дозаполнить строку до нужного размера (если это будет нужно)
	new_str = padl(source, size, symb);
	cout << "New string: " << new_str; // Выводим строку, обработанную функцией padl
	delete[] new_str; // Чистим память
	delete[] source; // Чистим память
}



/*#include <iostream>
using namespace std;

char* my_strcpy(char* p, const char* v)
{
	char* st = p;
	while (*v)
		*(p++) = *(v++);
	++(*p) = '\0';
	return st;
}

int my_strlen(char* str)
{
	int result = 0;
	while (str[result] != '\0')
		result++;
	return result;
}

char* padl(char* string, int len, int c = ' ')
{
	char* new_str = new char[len + 1];
	int source_len = my_strlen(string);
	if (len <= source_len)
	{
		my_strcpy(new_str, string + source_len - len);
	}
	else
	{
		int difference = len - source_len;
		for (int i = difference - 1; i >= 0; --i)
			new_str[i] = c;
		my_strcpy(new_str + difference, string);
	}
	return new_str;
}

int main()
{
	cout << "Vvedite stroky: ";
	char* new_str;
	char* source = new char[300];
	cin.getline(source, 300);
	new_str = padl(source, 10, 'c');
	cout << "New string: " << new_str << endl;
	delete[] new_str;
	delete[] source;
	return 0;
}

#include <iostream>
#include <cstring>
//#include <string.h>
#pragma warning (disable:4996)

using namespace std;

char* padl(char* string, int len, int c = ' ')
{
	char* new_str = new char[len + 1];
	int source_len = strlen(string);
	if (len <= source_len)
	{
		strcpy(new_str, string + source_len - len);
	}
	else
	{
		int difference = len - source_len;
		for (int i = difference - 1; i >= 0; --i)
			new_str[i] = c;
		strcpy(new_str + difference, string);
	}
	return new_str;
}

int main()
{
	cout << "Vvedite stroky: ";
	char* new_str;
	char* source = new char[300];
	cin.getline(source, 300);
	new_str = padl(source, 10, 'c');
	cout << "New string: " << new_str << endl;
	delete[] new_str;
	delete[] source;
	return 0;
}*/