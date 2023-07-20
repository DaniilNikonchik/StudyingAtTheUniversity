#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <windows.h>
using namespace std;

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

int main(int argc, char** argv) {
	cout << "Enter server ID:";
	int id;
	id = atoi(argv[1]);
	char WritePipe[100];
	char ReadPipe[100];
	char lb = false;
	sprintf(WritePipe, "\\\\.\\pipe\\Pipe_%d_%d", 1, id);
	cout << WritePipe << endl;
	if (!WaitNamedPipe(WritePipe, NMPWAIT_USE_DEFAULT_WAIT))
		lb = 1;
	sprintf(ReadPipe, "\\\\.\\pipe\\Pipe_%d_%d", 2, id);
	cout << ReadPipe << endl;
	if (!WaitNamedPipe(ReadPipe, NMPWAIT_USE_DEFAULT_WAIT))
		lb = 1;
	if (lb) {
		cout << "connection failed";
		return 1;
	}

	HANDLE hWriteHandle = CreateFile(WritePipe, // имя канала
		GENERIC_WRITE, // читаем и записываем в канал
		FILE_SHARE_READ,
		(LPSECURITY_ATTRIBUTES)NULL, // защита по умолчанию
		OPEN_EXISTING, // открываем существующий канал
		0, // атрибуты по умолчанию
		(HANDLE)NULL);

	HANDLE hReadHandle = CreateFile(ReadPipe,
		GENERIC_READ, // читаем и записываем в канал
		FILE_SHARE_WRITE,
		(LPSECURITY_ATTRIBUTES)NULL, // защита по умолчанию
		OPEN_EXISTING, // открываем существующий канал
		0, // атрибуты по умолчанию
		(HANDLE)NULL);


	char comm;
	DWORD bytes;
	employee st;
	command cm;
	cout << "\tm - modify\n\tr - read\n\tq - quit\n";
	cout << "\nEnter command:";
	while (cin >> comm) {
		if (comm == 'q') {
			cm.type = 3;
			WriteFile(hWriteHandle, &cm, sizeof(cm), &bytes, 0);
			break;
		}
		else
			if (comm == 'r')
			{
				cm.type = 0;
				cout << "Enter employee's number:";
				cin >> cm.num;
				WriteFile(hWriteHandle, &cm, sizeof(cm), &bytes, 0);
				ReadFile(hReadHandle, &cm, sizeof(cm), &bytes, 0);
				if (cm.result == true) {
					system("pause");
					ReadFile(hReadHandle, (char*)&st, sizeof(st), &bytes, 0);
					cout << "\nEmployee's number number: " << st.num;
					cout << "\nName: " << st.name;
					cout << "\nHours: " << st.hours << endl;
				}
				else
					cout << "No such record: " << cm.num;

			}
			else if (comm == 'm') {
				cm.type = 1;
				cout << "Enter employee's number number:";
				cin >> cm.num;
				employee st;
				WriteFile(hWriteHandle, &cm, sizeof(cm), &bytes, 0);
				ReadFile(hReadHandle, &cm, sizeof(cm), &bytes, 0);
				if (cm.result == true) {
					ReadFile(hReadHandle, (char*)&st, sizeof(st), &bytes, 0);
					cout << "Employee's number number: " << st.num;
					cout << "\nName: " << st.name;
					cout << "\nHours: " << st.hours << endl << endl;
					cin.get();
					cout << "Enter new name: ";
					cin.getline(st.name, 9);
					cout << "Enter new hours: ";
					cin >> st.hours;
					system("pause");
					WriteFile(hWriteHandle, &st, sizeof(st), &bytes, 0);
				}
				else
					cout << "No such record:: " << cm.num;
			}
			else
				cout << "No such command!";
			cout << "\nEnter command:";
	}
}
