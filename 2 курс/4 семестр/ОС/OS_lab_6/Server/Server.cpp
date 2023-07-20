#undef UNICODE
#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <fstream>
#include <windows.h>
using namespace std;
#define MAXFILENAMELEN 20

struct employee
{
	int num;
	char name[10];
	double hours;
};

struct command {
	int num;
	bool result;
	char type;
};

fstream file;
char* filename;
CRITICAL_SECTION cs;
HANDLE* hWriteAccess;
HANDLE* hReadAccess;
int*	countOfReaders;

void init() {
	cout << "Enter filename: ";
	cin.getline(filename, MAXFILENAMELEN - 1);
	file.open(filename, ios::binary | ios::out | ios::in | ios::trunc);
	cout << "Enter record count: ";
	int N;
	cin >> N;
	hWriteAccess = new HANDLE[N];
	hReadAccess = new HANDLE[N];
	countOfReaders = new int[N];
	file.write((char*)&N, sizeof(int));
	for (int i = 0; i < N; ++i) {
		countOfReaders[i] = 0;
		employee st;
		hWriteAccess[i] = CreateEvent(0, TRUE, TRUE, NULL);
		hReadAccess[i] = CreateEvent(0, TRUE, TRUE, NULL);
		cout << "\t\n___Record number " << i + 1 << " ____\n";
		cout << "Enter employee's number: ";
		cin >> st.num;
		cout << "Enter name: ";
		cin.get();
		cin.getline(st.name, 9);
		cout << "Enter hours: ";
		cin >> st.hours;
		file.write((char*)&st, sizeof(st));
	}
}

struct PipeInfo {
	HANDLE hReadHandle;		// дескриптор для чтения из канала
	HANDLE hWriteHandle;	// дескриптор для записи в канал
	int		myNum;
};

bool lookUp(int num, employee &st, DWORD &pos) {
	EnterCriticalSection(&cs);
	file.seekg(0, ios::beg);
	int N;
	file.read((char*)&N, sizeof(int));
	for (pos = 0; pos < N; ++pos) {
		file.read((char*)&st, sizeof(st));
		if (st.num == num)
			break;
	}
	LeaveCriticalSection(&cs);
	if (pos == N)
		return false;
	return true;
}

void write(employee st, DWORD pos) {
	EnterCriticalSection(&cs);
	file.seekp(sizeof(int) + pos*sizeof(st), ios::beg);
	file.write((char*)&st, sizeof(st));
	LeaveCriticalSection(&cs);
}

void read(employee &st, DWORD pos) {
	EnterCriticalSection(&cs);
	file.seekp(sizeof(int) + pos*sizeof(st), ios::beg);
	file.read((char*)&st, sizeof(st));
	LeaveCriticalSection(&cs);
}

DWORD WINAPI serverThread(LPVOID pr_)
{
	PipeInfo pr = *(PipeInfo*)pr_;
 	ConnectNamedPipe(pr.hReadHandle, (LPOVERLAPPED)NULL);
	ConnectNamedPipe(pr.hWriteHandle, (LPOVERLAPPED)NULL);
	command c;
	DWORD bytes;
	DWORD pos;
	do {
		ReadFile(pr.hReadHandle, (char*)&c, sizeof(c), &bytes, 0);
		if (c.type == 0) {
			employee st;
			c.result = lookUp(c.num, st, pos);
			WriteFile(pr.hWriteHandle, &c, sizeof(c), &bytes, 0);
			if (c.result) {
				countOfReaders[pos]++;
				WaitForSingleObject(hWriteAccess[pos], INFINITE);		//Ждем пока закончится запись
				ResetEvent(hReadAccess[pos]);
				read(st, pos);
				WriteFile(pr.hWriteHandle, &st, sizeof(st), &bytes, 0);
				countOfReaders[pos]--;
				if (!countOfReaders[pos])
					SetEvent(hReadAccess[pos]);
			}
		}
		else if (c.type == 1) {
			employee st;
			c.result = lookUp(c.num, st, pos);
			WriteFile(pr.hWriteHandle, &c, sizeof(c), &bytes, 0);
			if (c.result) {
				WaitForSingleObject(hReadAccess[pos], INFINITE);		//Ждем пока закончится чтение
				WaitForSingleObject(hWriteAccess[pos], INFINITE);		//Ждем пока закончится запись
				ResetEvent(hWriteAccess[pos]);
				read(st, pos);
				WriteFile(pr.hWriteHandle, &st, sizeof(st), &bytes, 0);
				//Закончили писать
				ReadFile(pr.hReadHandle, (char*)&st, sizeof(st), &bytes, 0);
				write(st, pos);
				SetEvent(hWriteAccess[pos]);
			}

		}
	} while (c.type != 3);
	DisconnectNamedPipe(pr.hReadHandle);
	DisconnectNamedPipe(pr.hWriteHandle);
	return 0;
}

void print() {
	file.seekg(0, ios::beg);
	int N;
	file.read((char*)&N, sizeof(int));
	employee st;
	for (int i = 0; i < N; ++i) {
		file.read((char*)&st, sizeof(st));
		cout << "\t\n___Record number " << i + 1 << " ____\n";
		cout << "Enter employee's number: " << st.num;
		cout << "\nName: " << st.name;
		cout << "\Hours: " << st.hours << endl;
	}
}

int main() {
	filename = new char[MAXFILENAMELEN];
	init();
	print();
	int C;
	cout << "Enter count of client processes: ";
	cin >> C;
	InitializeCriticalSection(&cs);

	HANDLE* hThread = new HANDLE[C];
	DWORD* ThreadID = new DWORD[C];
	PipeInfo* allPipes = new PipeInfo[C];
	for (int i = 0; i < C; ++i) {
		char PipeName[40] ;
		sprintf(PipeName, "\\\\.\\pipe\\Pipe_%d_%d", 1, i);
		cout << PipeName << endl;
		allPipes[i].hReadHandle = CreateNamedPipe(PipeName, PIPE_ACCESS_INBOUND, PIPE_TYPE_MESSAGE | PIPE_WAIT, 2, 0, 0, INFINITE, (LPSECURITY_ATTRIBUTES)NULL);
		sprintf(PipeName, "\\\\.\\pipe\\Pipe_%d_%d", 2, i);
		cout << PipeName << endl;
		allPipes[i].hWriteHandle = CreateNamedPipe(PipeName, PIPE_ACCESS_OUTBOUND, PIPE_TYPE_MESSAGE | PIPE_WAIT, 2, 0, 0, INFINITE, (LPSECURITY_ATTRIBUTES)NULL);
		hThread[i] = CreateThread(NULL, 0, serverThread, (void*)&allPipes[i], 0, ThreadID + i);
		char senderFullName[500];

		sprintf(senderFullName, "Client.exe %d", i);
		

		STARTUPINFO cif;
		ZeroMemory(&cif, sizeof(STARTUPINFO));
		cif.cb = (sizeof(STARTUPINFO));
		PROCESS_INFORMATION pi;

		if (!CreateProcessA(NULL,
			senderFullName,
			NULL,
			NULL,
			TRUE,
			CREATE_NEW_CONSOLE,
			NULL,
			NULL,
			&cif,
			&pi))
		{
			printf("Could not create process\n");
		}

		cout << "\nClient ID:" << i;
	}
	WaitForMultipleObjects(C, hThread, TRUE, INFINITE);
	delete[] filename;
	delete[] hThread;
	delete[] ThreadID;
	delete[] hWriteAccess;
	cout << "\nFinal result:\n\n";
	print();
	file.close();
	system("pause");
	return 0;
}