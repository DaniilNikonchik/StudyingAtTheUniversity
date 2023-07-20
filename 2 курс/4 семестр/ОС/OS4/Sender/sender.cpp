#pragma warning (disable: 4996)
#include <windows.h>
#include <iostream>
#include <conio.h>
using namespace std;

struct Sem
{
	HANDLE Semapthore;
	int current;
};

FILE* fin;
HANDLE hInEvent;
Sem full;
Sem empt;
HANDLE	hMutex;
int n;
char lpEventName[] = "StartEvent";
char* bfile;

struct mess
{
	char text[20];
};


DWORD WINAPI Sender(void* pv)
{
	SetEvent(hInEvent);
	mess message;
	int cont;
	do 
	{
		printf("Введите 1 если хотите записать сообщение, либо введите 0\n");
		scanf("%d", &cont);
		if (cont) 
		{
			printf("Введите сообщение для процесса \"Recivier\":\n");
			scanf("%s", message.text);
			WaitForSingleObject(empt.Semapthore, INFINITE);
			
			/* Вход в критич. секцию */
			WaitForSingleObject(hMutex, INFINITE);

			fin = fopen(bfile, "r+");
			/* Извлечь начало очереди */

			
			/* Запись в файл */
			fseek(fin, sizeof(mess) * full.current, SEEK_SET);
			fwrite(&message, sizeof(mess), 1, fin);
			/* Конец записи */

			

			fclose(fin);
			ReleaseMutex(hMutex);

			/* Выход из секции */


			full.current = (full .current + 1) % n;


			ReleaseSemaphore(full.Semapthore, 1, NULL);
			ReleaseSemaphore(empt.Semapthore, -1, NULL);
		}
	} while (cont);

	return 0;
}


int main(int argc, char* argv[])
{
	setlocale(LC_ALL, ".1251");
	bfile = argv[1];
	n = atoi(argv[2]);
	/* Объекты синхронизации */

	hInEvent = OpenEvent(EVENT_MODIFY_STATE, FALSE, lpEventName);
	if (hInEvent == NULL)
	{
		cout << "Open event failed." << endl;
		cout << "Press any key to exit." << endl;
		cin.get();

		return GetLastError();
	}
	hMutex = OpenMutex(SYNCHRONIZE, FALSE, "DemoMutex");
	if (hMutex == NULL)
	{
		cout << "Open mutex failed." << endl;
		cout << "Press any key to exit." << endl;
		cin.get();

		return GetLastError();
	}
	DWORD IDThreads;
	
	full.Semapthore = OpenSemaphore(SEMAPHORE_ALL_ACCESS, FALSE, "Full");
	full.current = 0;
	if (full.Semapthore == NULL)
	{
		cout << "Open first Semaphore failed." << endl;
		cout << "Press any key to exit." << endl;
		cin.get();

		return GetLastError();
	}
	empt.Semapthore = OpenSemaphore(SEMAPHORE_ALL_ACCESS, FALSE, "Empty");
	empt.current = n;
	if (empt.Semapthore == NULL)
	{
		cout << "Open second Semaphore failed." << endl;
		cout << "Press any key to exit." << endl;
		cin.get();

		return GetLastError();
	}
	/* Начало sender */

	HANDLE send = CreateThread(NULL, 0, Sender, 0, 0, &IDThreads);

	WaitForSingleObject(send, INFINITE);

	CloseHandle(hInEvent);
	CloseHandle(hMutex);
	CloseHandle(empt.Semapthore);
	CloseHandle(full.Semapthore);
	printf("Нажмите любую кнопку для завершения\n");
	_getch();
	return 0;
}