#include <iostream>
#include <ctime>
#include <string>
#include <Windows.h>

using namespace std;

int main()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	setlocale(LC_ALL, "RU");
	int key;
	string message;
	cout << "=========================================================================\n";
	cout << "Введите строку, которую надо зашифровать: ";
	getline(cin, message);
	int lengthOfMessage = message.length();//функция длинна строки 
	cout << "=========================================================================";
	cout << "\nЗашифрованное сообщение: ";
	srand(12456738945);//можно вводить любые 11 цифр
	for (int i = 0; i < lengthOfMessage; i++)
	{
		key = rand() % 1000; //присваивает рандомные числа от 0 до 1000
		message[i] = message[i] ^ key;
		cout << message[i];
	}
	cout << "\n=========================================================================";
	cout << "\nРасшифрованное сообщение: ";
	srand(12456738945);
	for (int i = 0; i < lengthOfMessage; i++)
	{
		key = rand() % 1000;
		message[i] = message[i] ^ key;
		cout << message[i];
	}
	cout << "\n=========================================================================\n";
}