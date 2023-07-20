#include <iostream>
#include <windows.h>
#include <process.h>
#include <stdio.h>

//#pragma GCC optimize ("O2")

using namespace std;

#define _i 10000
#define _j 10000
#define LOOP_AMOUNT 5

BOOL WINAPI QueryPerformanceFrequency(
	_Out_ LARGE_INTEGER* lpFrequency
);

int* multiply_matrix(int** matrix, int* array) {
	int* ans = new int[_i];
	for (int i = 0; i < _i; i++) {
		int sum = 0;
		for (int j = 0; j < _j; j++) {
			sum += matrix[i][j] * array[j];
		}
		ans[i] = sum;
	}
	return ans;
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
	
	LARGE_INTEGER liFrequency, liStartTime, liFinishTime;
	// получаем частоту
	QueryPerformanceFrequency(&liFrequency);
	// получаем стартовое время
	QueryPerformanceCounter(&liStartTime);

	int** matrix;
	int* array;

	matrix = new int* [_i];
	array = new int [_j];
	
	for (int i = 0; i < _i; i++) {
		matrix[i] = new int[_j];
	}


	for (int i = 0; i < LOOP_AMOUNT; i++) {
		//cout << "*****************************************************************\n";
		generate_matrix(&matrix, _i, _j);
		generate_array(&array, _j);

		auto ans = multiply_matrix(matrix, array);
		//print_matrix(matrix, _i, _j);
		//print_array(array, _j);
		//print_array(ans, _i);
		//cout << "*****************************************************************\n";
	}
	


	QueryPerformanceCounter(&liFinishTime);
	// вычисляет время в миллисекундах
	double dElapsedTime = 1000. * (liFinishTime.QuadPart - liStartTime.QuadPart) / liFrequency.QuadPart;

	std::cout << dElapsedTime /LOOP_AMOUNT << "\n";

	delete[]array;

	for (int i = 0; i < _i; i++) {
		delete[]  matrix[i];
	}
	delete matrix;
}

