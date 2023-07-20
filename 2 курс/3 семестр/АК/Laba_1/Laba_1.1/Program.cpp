#include <mpi.h>
#include <iostream>
#include <random>
#include "Process.h"
#include <time.h>


class Program
{
private:
	static std::random_device device;
	static std::uniform_int_distribution<> distrib;
	static double*generate(int L)
	{
		double* result = new double[L];
		for (int i = 0; i < L; i++)
		{
			result[i] = distrib(device) % 2 == 0 ? -1 : 0;
		}
		return result;
	}
	static void print(double*vector, int L) {
		for (int i = 0; i < L; i++)
		{
			std::cout << vector[i] << " ";
		}
		std::cout << "\n\n";
	}
	static void cut_slice(int num, int L, int *&slices, int *&pos) {
		slices = new int[num];
		pos = new int[num];
		for (int i = 0; i < num; i++) {
			slices[i] = (L / num);
			pos[i] = i * (L / num);
		}
		for (int i = 1, shift = 0; i < ((L%num) + 1); i++, shift += 1) {
			slices[i] += 1;
			pos[i] += shift;
		}
	}
	static void scatterv(double* arr, double* slice, int* slices, int* pos, int slice_size)
	{
		MPI_Scatterv(arr, slices, pos, MPI_DOUBLE, slice, slice_size, MPI_DOUBLE, MPI::MasterRank, MPI_COMM_WORLD);
	}
	static double multiply(double* vector1, double* vector2, int slice_size) 
	{
		double answer = 0;
		for (int i = 0; i < slice_size; i++) {
			answer += vector1[i] * vector2[i];
		}
		return answer;
	}
	static void reduce(double* ans, double* slice) 
	{
		MPI_Reduce(slice, ans, 1, MPI_DOUBLE, MPI_SUM, MPI::MasterRank, MPI_COMM_WORLD);
	}
public:
	static void program(int L) {
		double ans = 0, res = 0;
		double *vector1 = nullptr, *vector2 = nullptr;
		double *slice1 = nullptr, *slice2 = nullptr;
		int *slice_size1 = nullptr, *pos1 = nullptr;
		int *slice_size2 = nullptr, *pos2 = nullptr;
		auto process = MPI::Process();
		int n = process.GetProcessCount();
		MPI_Bcast(&L, 1, MPI_INT, MPI::MasterRank, MPI_COMM_WORLD);
		int sliceSizes[2];
		if (process.IsMaster()) {
			vector1 = generate(L);
			vector2 = generate(L);
			std::cout<< "The first vector: \n";
			print(vector1, L);
			std::cout<< "The second vector: \n";
			print(vector2, L);
			cut_slice(n, L, slice_size1, pos1);
			cut_slice(n, L, slice_size2, pos2);
			for (int i = 1; i < n; i++) {
				sliceSizes[0] = slice_size1[i];
				sliceSizes[1] = slice_size2[i];
				MPI_Send(sliceSizes, 2, MPI_INT, i, 0, MPI_COMM_WORLD);
			}
			sliceSizes[0] = slice_size1[0];
			sliceSizes[1] = slice_size2[0];
		}
		else {
			MPI_Recv(sliceSizes, 2, MPI_INT, MPI::MasterRank, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
		}
		slice1 = new double[sliceSizes[0]];
		slice2 = new double[sliceSizes[1]];
		scatterv(vector1, slice1, slice_size1, pos1, sliceSizes[0]);
		scatterv(vector2, slice2, slice_size2, pos2, sliceSizes[1]);
		res = multiply(slice1, slice2, sliceSizes[0]);
		reduce(&ans, &res);
		if (process.IsMaster()) {
			std::cout<< "Result: "<< ans;
		}
		delete[] slice1;
		delete[] slice2;
		if (process.IsMaster()) {
			delete[] vector1;
			delete[] vector2;
			delete[] slice_size1;
			delete[] slice_size2;
			delete[] pos1;
			delete[] pos2;
		}
	}
};

std::random_device Program::device;
std::uniform_int_distribution<> Program::distrib;

int main(int arg1, char **arg2)
{
	int L = atoi(arg2[1]);
	Program::program(L);
	return 0;
} //mpiexec -n 5 laba 4