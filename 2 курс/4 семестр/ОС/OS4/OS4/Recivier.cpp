#pragma warning (disable: 4996)
#include <iostream>
#include <windows.h>
#include <conio.h>
using namespace std;

struct Sem
{
	HANDLE Semapthore;
	int current;
};

struct mess 
{
	char text[20];
};

int main()
{

	/* Инициализация */
	mess check;
	FILE* fin;
	char bfile[30], writes[10], sender[10];
	char Command[140] = "..\\Debug\\Sender.exe";
	setlocale(LC_ALL, ".1251");
	printf("Введите имя бинарного файла:\n");
	scanf("%s", bfile);
	printf("Введите кол-во записей в файле:\n");
	scanf("%s", writes);

	int n = atoi(writes);

	fopen_s(&fin, bfile, "ab+");
	fclose(fin);
	
	/* Создание событий и других объектов для синхронизации */
	
	char lpEventName[] = "StartEvent";
	HANDLE StartEvent = CreateEvent(NULL, TRUE, FALSE, lpEventName);
	if (StartEvent == NULL)
		return GetLastError();
	HANDLE	hMutex;
	hMutex = CreateMutex(NULL, FALSE, "DemoMutex");
	if (hMutex == NULL)
	{
		cout << "Create mutex failed." << endl;
		cout << "Press any key to exit." << endl;
		cin.get();

		return GetLastError();
	}
	Sem full;
	Sem empt;
	full.Semapthore = CreateSemaphore(NULL, 0, atoi(writes), "Full");
	full.current = 0;
	empt.Semapthore = CreateSemaphore(NULL, atoi(writes), atoi(writes), "Empty");
	empt.current = atoi(writes);

	/* Организация коммадной строки */

	strcat(Command, " ");
	strcat(Command, bfile);
	strcat(Command, " ");
	strcat(Command, writes);

	/* Запуск процессов */

	STARTUPINFO si1;
	PROCESS_INFORMATION piApp1;
	ZeroMemory(&si1,				//указатель на блок памяти, который функция заполняет нулями
		sizeof(STARTUPINFO));		// размер блока памяти
	si1.cb = sizeof(STARTUPINFO);

	if (!CreateProcess(
		NULL,
		Command,
		NULL,							//Здесь определяются атрибуты защиты для нового приложения. Если указать NULL то система сделает это по умолчанию.
		NULL,							//Здесь определяются атрибуты защиты для первого потока созданного приложением. NULL опять приводит к установке по умолчанию.
		FALSE,							//Флаг наследования от процесса производящего запуск. Здесь наследуются дескрипторы.
		CREATE_NEW_CONSOLE,				//Новый процесс получает новую консоль вместо того
		NULL,							//Указывает на блок среды. Если NULL, то будет использован блок среды родительского процесса. Блок среды это список переменных имя=значение в виде строк с нулевым окончанием.
		NULL,							//Указывает текущий диск и каталог. Если NULL то будет использован диск и каталог процесса родителя
		&si1,							//Используется для настройки свойств процесса, например расположения окон и заголовок
		&piApp1							//Структура PROCESS_INFORMATION с информацией о процессе. Будет заполнена Windows.
	))
	{
		printf("The new process is not created.\n");
		printf("Check a name of the process.\n");
		printf("Press any key to finish.\n");
		_getch();
		return 0;
	}

	/* Начало алгоритма */

	WaitForSingleObject(StartEvent, INFINITE);
	printf("\"Sender\" готов к работе\n");

	int cont;
	mess buffer;
	do 
	{
		printf("Введите 1, если хотите прочитать сообщение, либо введите 0:\n");
		scanf("%d", &cont);
		if (cont) 
		{
			WaitForSingleObject(full.Semapthore, INFINITE);
			/* Вход в критич. секцию */

			WaitForSingleObject(hMutex, INFINITE);
			fopen_s(&fin, bfile, "r+");


			fseek(fin, sizeof(mess) * full.current, SEEK_SET);
			fread(&buffer, sizeof(mess), 1, fin);


			fclose(fin);
			ReleaseMutex(hMutex);
			/* выход из крит. секции */
			empt.current = (empt.current + 1) % n;
			full.current = (full.current + 1) % n;
			ReleaseSemaphore(empt.Semapthore, 1, NULL);
			ReleaseSemaphore(full.Semapthore, -1, NULL);
			printf("Ваша строка: %s\n", buffer.text);
		}
	} while (cont);

	WaitForSingleObject(piApp1.hProcess, INFINITE);
	CloseHandle(piApp1.hThread);
	CloseHandle(piApp1.hProcess);


	CloseHandle(StartEvent);
	CloseHandle(hMutex);
	CloseHandle(empt.Semapthore);
	CloseHandle(full.Semapthore);
	return 0;
}