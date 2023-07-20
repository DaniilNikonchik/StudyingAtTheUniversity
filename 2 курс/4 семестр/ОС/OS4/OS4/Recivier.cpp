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

	/* ������������� */
	mess check;
	FILE* fin;
	char bfile[30], writes[10], sender[10];
	char Command[140] = "..\\Debug\\Sender.exe";
	setlocale(LC_ALL, ".1251");
	printf("������� ��� ��������� �����:\n");
	scanf("%s", bfile);
	printf("������� ���-�� ������� � �����:\n");
	scanf("%s", writes);

	int n = atoi(writes);

	fopen_s(&fin, bfile, "ab+");
	fclose(fin);
	
	/* �������� ������� � ������ �������� ��� ������������� */
	
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

	/* ����������� ��������� ������ */

	strcat(Command, " ");
	strcat(Command, bfile);
	strcat(Command, " ");
	strcat(Command, writes);

	/* ������ ��������� */

	STARTUPINFO si1;
	PROCESS_INFORMATION piApp1;
	ZeroMemory(&si1,				//��������� �� ���� ������, ������� ������� ��������� ������
		sizeof(STARTUPINFO));		// ������ ����� ������
	si1.cb = sizeof(STARTUPINFO);

	if (!CreateProcess(
		NULL,
		Command,
		NULL,							//����� ������������ �������� ������ ��� ������ ����������. ���� ������� NULL �� ������� ������� ��� �� ���������.
		NULL,							//����� ������������ �������� ������ ��� ������� ������ ���������� �����������. NULL ����� �������� � ��������� �� ���������.
		FALSE,							//���� ������������ �� �������� ������������� ������. ����� ����������� �����������.
		CREATE_NEW_CONSOLE,				//����� ������� �������� ����� ������� ������ ����
		NULL,							//��������� �� ���� �����. ���� NULL, �� ����� ����������� ���� ����� ������������� ��������. ���� ����� ��� ������ ���������� ���=�������� � ���� ����� � ������� ����������.
		NULL,							//��������� ������� ���� � �������. ���� NULL �� ����� ����������� ���� � ������� �������� ��������
		&si1,							//������������ ��� ��������� ������� ��������, �������� ������������ ���� � ���������
		&piApp1							//��������� PROCESS_INFORMATION � ����������� � ��������. ����� ��������� Windows.
	))
	{
		printf("The new process is not created.\n");
		printf("Check a name of the process.\n");
		printf("Press any key to finish.\n");
		_getch();
		return 0;
	}

	/* ������ ��������� */

	WaitForSingleObject(StartEvent, INFINITE);
	printf("\"Sender\" ����� � ������\n");

	int cont;
	mess buffer;
	do 
	{
		printf("������� 1, ���� ������ ��������� ���������, ���� ������� 0:\n");
		scanf("%d", &cont);
		if (cont) 
		{
			WaitForSingleObject(full.Semapthore, INFINITE);
			/* ���� � ������. ������ */

			WaitForSingleObject(hMutex, INFINITE);
			fopen_s(&fin, bfile, "r+");


			fseek(fin, sizeof(mess) * full.current, SEEK_SET);
			fread(&buffer, sizeof(mess), 1, fin);


			fclose(fin);
			ReleaseMutex(hMutex);
			/* ����� �� ����. ������ */
			empt.current = (empt.current + 1) % n;
			full.current = (full.current + 1) % n;
			ReleaseSemaphore(empt.Semapthore, 1, NULL);
			ReleaseSemaphore(full.Semapthore, -1, NULL);
			printf("���� ������: %s\n", buffer.text);
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