#include <fstream>
#include <string>
#include <stack>

using namespace std;

int main()
{
	ifstream fin("smiles.in.txt"); // Перед тем, как засылать в систему iRunner, нужно убрать расширение .txt
	ofstream fout("smiles.out.txt"); // Перед тем, как засылать в систему iRunner, нужно убрать расширение .txt
	stack<char> Parentheses; // Стек скобок
	int n = 0, j = 0, i = 0;
	fin >> n;
	fin.get(); // Избавляемся от линего '/n'
	bool smile_check = false;
	string str;
	bool str_valid = true;
	int answer = 0;
	for (i = 0; i < n; i++)
	{
		getline(fin, str); // Считываем строку
		for (j = 0; j < str.length(); j++)
		{ // Проходимся по строке...
			if (smile_check)
			{ // Проверка на смайлик (если прошлым символом был ':')
				if (str[j] == ':') // Если снова этот символ, то сохраняем флажок на true
					continue;
				else
				{
					smile_check = false;
					continue;
				}
			}
			if (str_valid)
			{ // Если ошибок в данной строке нету
				if (str[j] == '(' || str[j] == ')' || str[j] == '[' || str[j] == ']' || str[j] == '{' || str[j] == '}' || str[j] == ':')
				{ // Если символ нас интересует
					if (str[j] == ':')
					{
						smile_check = true;
						continue;
					}
					else if (str[j] == '(' || str[j] == '[' || str[j] == '{')
					{
						Parentheses.push(str[j]);
					}
					else if (str[j] == ')' || str[j] == ']' || str[j] == '}')
					{
						if (Parentheses.empty())
						{ // Если стек пуст, то выдаем ошибку 1
							answer = 1;
							str_valid = false;
						}
						else if (str[j] == ')')
						{
							if (Parentheses.top() == '(')
							{
								Parentheses.pop();
							}
							else
							{ // Если не та скобка, то выдаем ошибку 2
								answer = 2;
								str_valid = false;
							}
						}
						else if (str[j] == ']')
						{
							if (Parentheses.top() == '[')
							{
								Parentheses.pop();
							}
							else
							{ // Если не та скобка, то выдаем ошибку 2
								answer = 2;
								str_valid = false;
							}
						}
						else if (str[j] == '}')
						{
							if (Parentheses.top() == '{')
							{
								Parentheses.pop();
							}
							else
							{ // Если не та скобка, то выдаем ошибку 2
								answer = 2;
								str_valid = false;
							}
						}
					}
				}
			}
			else
				break;
		}
		if (!Parentheses.empty() && answer != 2)
			answer = 3; // Если стек не пустой, значит какие-то скобки остались открытыми, выводим ошибку 3 (если конечно ошибка 2 не встретилась раньше)
		fout << answer;
		if (i != n - 1)
			fout << endl;
		answer = 0;
		while (Parentheses.size() != 0)
			Parentheses.pop(); // Чистим стек
		str_valid = true;
	}
}