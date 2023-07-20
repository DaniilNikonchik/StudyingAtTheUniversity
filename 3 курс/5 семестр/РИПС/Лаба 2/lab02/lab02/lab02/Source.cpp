#include <windows.h>
#include <process.h>
#include <stdio.h>
#include <iostream>

#define p 1 // ���������� �������� �������

double pi[p];
int n = 1000000;


BOOL WINAPI QueryPerformanceFrequency(
	_Out_ LARGE_INTEGER* lpFrequency
);

unsigned WINAPI ThreadFunction(LPVOID pvParam)
{
	int nParam = (int)pvParam;
	int i, start;
	double h, sum, x;
	h = 1. / n;
	sum = 0.;
	start = nParam;
	for (i = start; i < n; i += p)
	{
		x = h * i;
		sum += 4. / (1. + x * x);
	}
	pi[nParam] = h * sum;
	return 0;
}

int main()
{
	// �������� �������� �������
	LARGE_INTEGER liFrequency, liStartTime, liFinishTime;
	// �������� �������
	QueryPerformanceFrequency(&liFrequency);
	// �������� ��������� �����
	QueryPerformanceCounter(&liStartTime);

	HANDLE hThreads[p];
	int k;
	double sum;

	// ���������� ����������




	for (k = 0; k < p; ++k)
	{
		hThreads[k] = (HANDLE)_beginthreadex(NULL, 0,ThreadFunction, (LPVOID)k, 0, NULL);
		if (hThreads[k] == NULL) // ��������� ������
		{
			printf("Create Thread %d Error=%d\n", k, GetLastError());
			return -1;
		}
	}
	// �������� ���������� �������� �������
	WaitForMultipleObjects(p, hThreads, TRUE, INFINITE);
	for (k = 0; k < p; ++k)
		CloseHandle(hThreads[k]);

	// �������� �������� �����
	sum = 0.;

	for (k = 0; k < p; ++k)
		sum += pi[k];
	printf("PI = %.16f\n", sum);
	QueryPerformanceCounter(&liFinishTime);
	// ��������� ����� � �������������
	double dElapsedTime = 1000. * (liFinishTime.QuadPart - liStartTime.QuadPart) / liFrequency.QuadPart;
	std::cout << dElapsedTime << "\n";
	return 0;
}
