#include <iostream>
#include <windows.h>
#include <process.h>
#include <stdio.h>
#pragma optimize("",  on );
using namespace std;

#define _i 500
#define _j 500
#define LOOP_AMOUNT 5
const int THREAD_AMOUNT = 2;

int* range;
int** matrix;
int* arr;
int* ans;

BOOL WINAPI QueryPerformanceFrequency(
	_Out_ LARGE_INTEGER* lpFrequency
);

unsigned WINAPI ThreadFunction(LPVOID pvParam)
{
	int nParam = (int)pvParam;
	int  increm = _i / THREAD_AMOUNT;
	int  increm_mod = _i % THREAD_AMOUNT;
	if (increm_mod != 0) {
		if (increm_mod > nParam)
			increm++;
	}

	int sum = 0;
	for (int i = nParam; i < nParam + increm; i++) {
		for (int j = 0; j < _j; j++) {
			auto m = matrix[nParam][j];
			auto a = arr[j];
			sum += (m * a);
		}
		ans[nParam] = sum;
	}


	return 0;
}


void multiply_matrix(int** matrix, int* array) {
	HANDLE hThreads[THREAD_AMOUNT];

	for (int k = 0; k < THREAD_AMOUNT; ++k)
	{

		hThreads[k] = (HANDLE)_beginthreadex(NULL, 0,
			ThreadFunction, (LPVOID)k, 0, NULL);

		if (hThreads[k] == NULL) // обработка ошибки
		{
			printf("Create Thread %d Error=%d\n", k, GetLastError());
			exit;
		}
	}
	// ожидание завершения дочерних потоков
	WaitForMultipleObjects(THREAD_AMOUNT, hThreads, TRUE, INFINITE);

}

void print_matrix(int** matrix, int ai, int aj) {
	cout << "Matrix\n";
	for (int i = 0; i < ai; i++) {
		for (int j = 0; j < aj; j++) {
			cout << matrix[i][j] << " ";
		}
		cout << "\n";
	}
}

void print_array(int* ans, int ai) {
	cout << "Vector: \n";
	for (int i = 0; i < ai; i++) {
		cout << ans[i] << " ";
	}
	cout << "\n";
}

void generate_array(int** array, int ai) {
	for (int i = 0; i < ai; i++) {
		(*array)[i] = rand() % 2;
	}
}

void generate_matrix(int*** matrix, int ai, int aj) {
	for (int i = 0; i < ai; i++) {
		for (int j = 0; j < aj; j++) {
			(*matrix)[i][j] = rand() % 3;
		}
	}
}

void main()
{
	cout << "lab02\n";
	LARGE_INTEGER liFrequency, liStartTime, liFinishTime;
	// получаем частоту
	QueryPerformanceFrequency(&liFrequency);
	// получаем стартовое время
	QueryPerformanceCounter(&liStartTime);



	matrix = new int* [_i];
	arr = new int[_j];
	ans = new int[_i];
	range = new int[THREAD_AMOUNT];

	for (int i = 0; i < _i; i++) {
		matrix[i] = new int[_j];
	}


	for (int i = 0; i < LOOP_AMOUNT; i++) {
		//cout << "*****************************************************************\n";
		generate_matrix(&matrix, _i, _j);
		generate_array(&arr, _j);

		multiply_matrix(matrix, arr);
		//print_matrix(matrix, _i, _j);
		//print_array(arr, _j);
		//print_array(ans, _i);
		//cout << "*****************************************************************\n";
	}



	QueryPerformanceCounter(&liFinishTime);
	// вычисляет время в миллисекундах
	double dElapsedTime = 1000. * (liFinishTime.QuadPart - liStartTime.QuadPart) / liFrequency.QuadPart;

	std::cout << dElapsedTime / LOOP_AMOUNT << "\n";

	delete[]arr;
	delete[]ans;

	for (int i = 0; i < _i; i++) {
		delete[]  matrix[i];
	}
	delete matrix;
}
