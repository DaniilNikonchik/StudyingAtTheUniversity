#include <windows.h>
#include <process.h>
#include <stdio.h>
#include <iostream>
#define p 2 // ���������� �������� �������
int n = 1000000;
// ��� ���������, ������������� ������� ������

BOOL WINAPI QueryPerformanceFrequency(
	_Out_ LARGE_INTEGER* lpFrequency
);


struct SThreadParam
{
	int k;
	double sum;
};

unsigned WINAPI ThreadFunction(LPVOID pvParam)
{

	SThreadParam* param = (SThreadParam*)pvParam;
	int i, start;
	double h, sum, x;
	h = 1. / n;
	sum = 0.;
	start = param->k;
	for (i = start; i < n; i += p)
	{
		x = h * i;
		sum += 4. / (1. + x * x);
	}
	// � ���������� ���������� �� ������� ����� ����������
	param->sum = h * sum;
	return 0;
}

int main()
{



	HANDLE hThreads[p]; // ������ ������������ �������
	// ������ ���������� ��������� �������
	SThreadParam params[p];
	int k;
	double sum;
	// �������� �������� �������
		// �������� �������� �������
	LARGE_INTEGER liFrequency, liStartTime, liFinishTime;
	// �������� �������
	QueryPerformanceFrequency(&liFrequency);
	// �������� ��������� �����
	QueryPerformanceCounter(&liStartTime);
	for (k = 0; k < p; ++k)
	{
		params[k].k = k;
		hThreads[k] = (HANDLE)_beginthreadex(NULL, 0,
			ThreadFunction, (LPVOID) & (params[k]), 0, NULL);
		if (hThreads[k] == NULL) // ��������� ������
		{
			printf("Create Thread %d Error=%d\n", k, GetLastError());
			return -1;
		}
	}
	// �������� ���������� �������� �������
	WaitForMultipleObjects(p, hThreads, TRUE, INFINITE);
	QueryPerformanceCounter(&liFinishTime);
	// ��������� ����� � �������������
	double dElapsedTime = 1000. * (liFinishTime.QuadPart - liStartTime.QuadPart) / liFrequency.QuadPart;
	std::cout << dElapsedTime << "\n";
	for (k = 0; k < p; ++k)
		CloseHandle(hThreads[k]);
	sum = 0.;
	for (k = 0; k < p; ++k)
		sum += params[k].sum;
	printf("PI = %.16f\n", sum);


	return 0;
}
