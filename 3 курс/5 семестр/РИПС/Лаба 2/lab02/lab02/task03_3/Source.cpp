#include <iostream>
#include <windows.h>
#include <process.h>
#include <stdio.h>
#pragma optimize("",  off );

using namespace std;

const int _i = 500;
const int _j = 500;
const int  LOOP_AMOUNT =5;
const int THREAD_AMOUNT=2;

int** matrix;
int* arr;
int* ans;


BOOL WINAPI QueryPerformanceFrequency(
	_Out_ LARGE_INTEGER* lpFrequency
);

unsigned WINAPI ThreadFunction(LPVOID pvParam)
{
	int nParam = (int)pvParam;

	for (int i = nParam; i < _i; i += THREAD_AMOUNT) {
		int sum = 0;
		for (int j = 0; j < _j; j++) {
			sum += matrix[i][j] * arr[j];
		}

		ans[i] = sum;

	}

	return 0;
}


void multiply_matrix(int** matrix, int* array) {
	HANDLE* hThreads = new HANDLE[THREAD_AMOUNT];

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
	delete[] hThreads;
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

	cout << "task03\n";
	LARGE_INTEGER liFrequency, liStartTime, liFinishTime;
	// получаем частоту
	QueryPerformanceFrequency(&liFrequency);
	// получаем стартовое время
	QueryPerformanceCounter(&liStartTime);



	matrix = new int* [_i];
	arr = new int[_j];
	ans = new int[_i];

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
	//delete[]ans;

	for (int i = 0; i < _i; i++) {
		delete[]  matrix[i];
	}
	delete matrix;

}
