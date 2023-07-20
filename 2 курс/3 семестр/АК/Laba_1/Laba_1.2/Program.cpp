#include <mpi.h>
#include <iostream>
#include <random>
#include "Process.h"


class Program
{
private:
	static std::random_device device;
	static std::uniform_int_distribution<> distrib;
	static double*generate(int L, int M)
	{
		double* result = new double[L * M];
		for (int i = 0; i < L*M; i++)
			result[i] = distrib(device) % 100;
		return result;
	}
	static void print(double* matrix, int L, int M) {
		for (int i = 0; i < L; i++)
		{
			for (int j = 0; j < M; j++)
				std::cout << matrix[i*M + j] << " ";
			std::cout << "\n";
		}
		std::cout << "\n";
	}
	static void count(int num, int L, int M, int *&slices, int *&pos) {
		slices = new int[num];
		pos = new int[num];
		for (int i = 0; i < num; i++)
		{
			slices[i] = (L / num)*M;
			pos[i] = i * (L / num)*M;
		}
		for (int i = 1, shift = 0; i < ((L%num) + 1); i++, shift += M) {
			slices[i] += M;
			pos[i] += shift;
		}
	}
	static void scatterv(double* matrix, double* slice, int* slices, int* pos, int slice_size)
	{
		MPI_Scatterv(matrix, slices, pos, MPI_DOUBLE, slice, slice_size, MPI_DOUBLE, MPI::MasterRank, MPI_COMM_WORLD);
	}
	static double* subtraction(double* matrix1, double* matrix2, int slice_size) {
		double* answer = new double[slice_size];
		for (int i = 0; i < slice_size; i++)
			answer[i] = matrix1[i] - matrix2[i];
		return answer;
	}
	static void gatherv(double* res, double* slice, int* slices, int* pos, int slice_size) {
		MPI_Gatherv(slice, slice_size, MPI_DOUBLE, res, slices, pos, MPI_DOUBLE, MPI::MasterRank, MPI_COMM_WORLD);
	}
public:
	static void Main() {
		const int L = 3;
		const int M = 4;
		auto process = MPI::Process();
		int num = process.GetProcessCount();
		double *matrix1 = nullptr, *matrix2 = nullptr;
		double *firstSlice = nullptr, *secondSlice = nullptr;
		double *ans = nullptr, *res = nullptr;
		int *slices1 = nullptr, *pos1 = nullptr;
		int *slices2 = nullptr, *pos2 = nullptr;
		int slice_sizes[2];
		if (process.IsMaster()) {
			matrix1 = generate(L, M);
			matrix2 = generate(L, M);
			std::cout << "The first matrix: \n";
			print(matrix1, L, M);
			std::cout << "The second matrix: \n";
			print(matrix2, L, M);
			count(num, L, M, slices1, pos1);
			count(num, L, M, slices2, pos2);
			for (int i = 1; i < num; i++) 
			{
				slice_sizes[0] = slices1[i];
				slice_sizes[1] = slices2[i];
				MPI_Send(slice_sizes, 2, MPI_INT, i, 0, MPI_COMM_WORLD);
			}
			slice_sizes[0] = slices1[0];
			slice_sizes[1] = slices2[0];
		}
		else
			MPI_Recv(slice_sizes, 2, MPI_INT, MPI::MasterRank, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
		firstSlice = new double[slice_sizes[0]];
		secondSlice = new double[slice_sizes[1]];
		scatterv(matrix1, firstSlice, slices1, pos1, slice_sizes[0]);
		scatterv(matrix2, secondSlice, slices2, pos2, slice_sizes[1]);
		res = subtraction(firstSlice, secondSlice, slice_sizes[0]);
		if (process.IsMaster())
			ans = new double[L*M];
		gatherv(ans, res, slices1, pos1,slice_sizes[0]);
		if (process.IsMaster()) 
		{
			std::cout << "Result: \n";
			print(ans, L, M);
		}
		delete[] firstSlice;
		delete[] secondSlice;
		delete[] res;
		if (process.IsMaster()) 
		{
			delete[] matrix1;
			delete[] matrix2;
			delete[] slices1;
			delete[] slices2;
			delete[] pos1;
			delete[] pos2;
			delete[] ans;
		}
	}
};

std::random_device Program::device;
std::uniform_int_distribution<> Program::distrib;

int main()
{
	Program::Main();
	return 0;
}