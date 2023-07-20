#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	setlocale(LC_ALL, "Rus");
	int n, m;
	cout << "Введите количество строк массива (не менее 1): ";
	cin >> n;

	while (n <= 0 || n > 20) 
	{
		cout << "Введено недопустимое значение. Массив должен содержать не менее 1 строки."  << "\nВведите количество строк массива: ";
		cin >> n;
	}

	cout << "Введите количество столбцов массива (не менее 1): ";
	cin >> m;

	while (m <= 0 || m > 20)
	{
		cout << "Введено недопустимое значение. Массив должен содержать не менее 1 столбца." << endl << "Введите количество столбцов многомерного массива: ";
		cin >> m;
	}
	//на всякий случай для рандомной матрицы 
	/*for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
			cout << (arr[i][j] = rand() % 10);
		cout << endl;
	}*/

	// инициализация многомерного массива
	int** arr;
	arr = new int* [n];
	for (int i = 0; i < n; i++) 
	{
		arr[i] = new int[m];
	}
	for (int i = 0; i < n; i++) 
	{
		for (int j = 0; j < m; j++) 
		{
			cout << "Введите элемент массива [" << i << "][" << j << "]: ";
			cin >> arr[i][j];
		}
	}
	cout << endl;

	//Вывод таблицы
	cout << "_____________________________" << endl;
	cout << "Элементы Вашей матрицы: " << endl;
	for (int i = 0; i < n; i++) 
	{
		for (int j = 0; j < m; j++) 
		{
			cout << setw(9) << arr[i][j];
		}
		cout << endl;
	}
	cout << endl;

	//сумма в строках без 0
	cout << "_____________________________" << endl;
	int sum = 0;
	for (int i = 0; i < n; i++) 
	{
		int s1 = 0, flag = 1;
		for (int j = 0; j < m; j++)
		{
			s1 += arr[i][j];
			if (arr[i][j] == 0) 
				flag = 0;
		}
		if (flag)
			cout << "Сумма в [" << i+1 << "] строке: " << s1 << endl;
		else
		{
			cout << "Строка [" << i+1 << "] содержит нуль" << endl;
		}
	}

	//Прризведение в диагоналях и вывод максимального из них 
	int temp=0;
	int abc = 1;
	int comp;
	for (int j = 1; j < m; j++)
	{
		temp = j;
		comp = 1;
		for (int i = 0; i < n-1; i++)
		{
			comp *= arr[i][j];
			j++;
		}
		if (comp > abc)
			abc = comp;
		j = temp;
	}
	cout << "_____________________________" << endl;
	int compX;
	int bcd=1;
	int tem;
	for (int j = 0; j < m-1; j++)
	{
		tem = j;
		compX = 1;
		for (int i = 1; i < n; i++)
		{
			compX *= arr[i][j];
			j++;
		}
		if (compX > bcd)
			bcd = compX;
	}
	if (abc > bcd)
		cout << "Максимальное произведение: " << abc << endl;
	else 
		cout << "Максимальное произведение: " << bcd << endl;

	//Перестановка матрицы по столбцам по возрастанию суммы элементов столбцов
	for (int k = 0; k < n; k++)
	{
		for (int j = 0; j < m; j++)
		{
			int sumN = 0;
			for (int i = 0; i < n; i++)
			{
				sumN += arr[i][j - 1];
			}
			int sumC = 0;
			for (int i = 0; i < n; i++)
			{
				sumC += arr[i][j];
			}
			if (sumN > sumC)
			{
				for (int i = 0; i < n; i++)
				{
					int temp = arr[i][j];
					arr[i][j] = arr[i][j - 1];
					arr[i][j - 1] = temp;
				}
			}
		}
	}

	//вывод перестроенной матрицы
	cout << "_____________________________" << endl;
	cout << "Элементы Вашей матрицы: " << endl;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout << setw(9) << arr[i][j];
		}
		cout << endl;
	}
	cout << endl;

	//вывод суммы элементов в столбцах
	cout << "_____________________________" << endl;
	int sumZ = 0;
	for (int j = 0; j < m; j++)
	{
		int s1 = 0; 
		for (int i = 0; i < n; i++)
		{
			s1 += arr[i][j];		
			if (arr[i][j] == 0);	
		}
		cout << "Сумма в [" << j + 1 << "] столбце: " << s1 << endl;
	}

	//Строки с нулями
	cout << "_____________________________" << endl;
	int nol = 0;
	for (int i = 0; i < n; i++)
	{
		int flag = 0;
		for (int j = 0; j < m; j++)
		{
			if (arr[i][j] == 0)
				flag = 1;
		}
		if (flag)
		{
			cout << "Строка [" << i + 1 << "] содержит нуль" << endl;
			break;
		}		
	}

	//Удаление матрицы
	for (int i = 0; i < n; i++)
	{
		delete[] arr[i];
	}
	delete[] arr;
	
	return 0;
}