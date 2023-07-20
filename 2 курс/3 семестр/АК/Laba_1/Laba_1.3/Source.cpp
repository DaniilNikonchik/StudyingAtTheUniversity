#include <mpi.h>
#include <iostream>
#include <random>
#include "Process.h"


class Program
{
private:
	static std::random_device device;
	static std::uniform_int_distribution<> distrib;
	static double*generate(int N, int M)
	{
		double* res = new double[N * M];
		for (int i = 0; i < N*M; i++)
			res[i] = distrib(device) % 2 == 0 ? -1 : 0;
		return res;
	}
	static void count(int num, int N, int M, int *&slices, int *&pos) {
		slices = new int[num];
		pos = new int[num];
		for (int i = 0; i < num; i++)
		{
			slices[i] = (N / num)*M;
			pos[i] = i * (N / num)*M;
		}
		for (int i = 1, shift = 0; i < ((N%num) + 1); i++, shift += M) {
			slices[i] = M;
			pos[i] += shift;
		}
	}
	static void print(double* matrix, int N, int M) {
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
				std::cout << matrix[i*M + j] << " ";
			std::cout << "\n";
		}
		std::cout << "\n";
	}
	static void print_transp(double* matrix, int N, int M) {
		for (int j = 0; j < M; j++)
		{
			for (int i = 0; i < N; i++)
				std::cout << matrix[i*M + j] << " ";
			std::cout << "\n";
		}
		std::cout << "\n";
	}
	static void scatterv(double* matrix, double* slice, int* slices, int* pos, int slice_size)
	{
		MPI_Scatterv(matrix, slices, pos, MPI_DOUBLE, slice, slice_size, MPI_DOUBLE, MPI::MasterRank, MPI_COMM_WORLD);
	}
	static double* multiply(double* matrix1, double* matrix2, int K, int S, int M) {
		double* ans = new double[K*M];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < M; j++) {
				ans[i*M + j] = 0;
				for (int k = 0; k < S; k++)
					ans[i*M + j] += matrix1[k*K + i] * matrix2[k*M + j];
			}
		}
		return ans;
	}
	static void reduce(double* ans, double* slice, int slice_size) {
		MPI_Reduce(slice, ans, slice_size, MPI_DOUBLE, MPI_SUM, MPI::MasterRank, MPI_COMM_WORLD);
	}
public:
	static void Main() {
		auto process = MPI::Process();
		int num = process.GetProcessCount();
		int K, L, M;
		if (process.IsMaster()) {
			std::cout << "Input the parameters K,L,M:\n";
			std::cin >> K >> L >> M;
			std::cout << "\n";
		}
		MPI_Bcast(&K, 1, MPI_INT, MPI::MasterRank, MPI_COMM_WORLD);
		MPI_Bcast(&M, 1, MPI_INT, MPI::MasterRank, MPI_COMM_WORLD);
		double *matrix1 = nullptr, *matrix2 = nullptr;
		double *slice1 = nullptr, *slice2 = nullptr;
		double *ans = nullptr, *res = nullptr;
		int *slices1 = nullptr, *pos1 = nullptr;
		int *slices2 = nullptr, *pos2 = nullptr;
		int sliceSizes[2];
		if (process.IsMaster()) {
			matrix1 = generate(L, K);
			matrix2 = generate(L, M);
			std::cout << "The first matrix: \n";
			print_transp(matrix1, L, K);
			std::cout << "The second matrix: \n";
			print(matrix2, L, M);
			count(num, L, K, slices1, pos1);
			count(num, L, M, slices2, pos2);
			for (int i = 1; i < num; i++) {
				sliceSizes[0] = slices1[i];
				sliceSizes[1] = slices2[i];
				MPI_Send(sliceSizes, 2, MPI_INT, i, 0, MPI_COMM_WORLD);
			}
			sliceSizes[0] = slices1[0];
			sliceSizes[1] = slices2[0];
		}
		else
			MPI_Recv(sliceSizes, 2, MPI_INT, MPI::MasterRank, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);
		slice1 = new double[sliceSizes[0]];
		slice2 = new double[sliceSizes[1]];
		scatterv(matrix1, slice1, slices1, pos1, sliceSizes[0]);
		scatterv(matrix2, slice2, slices2, pos2, sliceSizes[1]);
		res = multiply(slice1, slice2, K, sliceSizes[0] / K, M);
		if (process.IsMaster()) 
			ans = new double[K*M];
		reduce(ans, res, K*M);
		if (process.IsMaster()) {
			std::cout << "Result: \n";
			print(ans, K, M);
		}
		delete[] slice1;
		delete[] slice2;
		delete[] res;
		if (process.IsMaster()) {
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