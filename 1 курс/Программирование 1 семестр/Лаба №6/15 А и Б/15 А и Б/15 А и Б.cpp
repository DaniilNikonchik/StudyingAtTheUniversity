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

bool Needed_or_Not(char* word)
{ // Функция, проверяющая, идут ли символы в строке в порядке убывания их кодов ASCII
	int current_min_code = INT32_MAX;
	for (int i = 0; word[i] != '\0'; i++)
		if ((int)word[i] < current_min_code) // Если код символа меньше, чем минимальный в слове
			current_min_code = (int)word[i]; // То запоминаем его как минимальный
		else // Если код нового символа превышает минимальный, то функция возвращает false
			return false;
	return true; // Если все хорошо, возвращаем true
}

int main()
{// ЧАСТЬ A
	{
		cout << "PART A" << endl;
		char* new_str; // Здесь будем хранить новую строку (которая получится)
		cout << "Enter the string to be worked with function padl:" << endl;
		char* source = new char[256]; // Здесь храним исходную строку
		cin.getline(source, 256); // Считываем исходную строку
		cout << "Enter the size of new string:";
		int size = NULL;
		cin >> size; // Вводим желаемый размер для новой строки
		cout << "Enter the symbol to be added to string by function padl:";
		char symb = NULL;
		cin >> symb; // Вводим символ, которым мы хотим дозаполнить строку до нужного размера (если это будет нужно)
		new_str = padl(source, size, symb);
		cout << "New string: " << new_str; // Выводим строку, обработанную функцией padl
		delete[] new_str; // Чистим память
		delete[] source; // Чистим память
	}

	{
		// ЧАСТь B
		cout << "PART B" << endl;
		char* str = new char[256]; // Память под строку, в которой будем искать нужные слова
		str[0] = '\0'; // Зануляем ее сразу
		cout << "Enter the string to find out needed word:" << endl;
		cin.getline(str, 256); // Считываем эту строку
		char* word = new char[256]; // В этом массиве будем хранить очередное слово
		char* needed_word = new char[256]; // В этом массиве будем хранить слово, которое нам подходит (если такое вообще найдется)
		word[0] = '\0'; // Зануляем слово
		needed_word[0] = '\0'; // Зануляем нужное слово
		int j = 0;
		for (int i = 0; str[i] != '\0'; i++, j++) // Движемся по исходной строке, пока не наткнемся на ее нуль-терминатор
		{
			if (str[i] == ' ')
			{ // Если нам встретился пробел, то...
				word[j] = '\0'; // Ограничиваем размер текущего слова нуль-терминатором и...
				if (Needed_or_Not(word)) // Проверяем слово на наше условие
					my_strcpy(needed_word, word); // Если выполняется, то запоминаем это слово в массив needed_word
				j = -1; // Для нового слова делаем индекс -1, чтобы потом считать от нуля для нового слова (в цикле будет инкремент)
			}
			else
				word[j] = str[i]; // Если пробел не встретился, то продолжаем пихать в слово по символу
		}
		word[j] = '\0'; // Т.к. последнее слово не обработано (был встречен '\0', а не очередной пробел), то мы должны обработать и его
		if (Needed_or_Not(word)) // Обрабатываем последнее слово
			my_strcpy(needed_word, word); // Если подходит, запоминаем
		if (needed_word[0] == '\0') // Если так получилось, что нужная строка все еще пустая, значит мы не нашли слов, подходящих под условие
			cout << "There are no such words!" << endl;
		else // Иначе...
			cout << "Needed word is the next: " << needed_word << endl; // Выводим нужное словое
		delete[] str;
		delete[] word;
		delete[] needed_word;
		// ЧАСТЬ B
	}

}

