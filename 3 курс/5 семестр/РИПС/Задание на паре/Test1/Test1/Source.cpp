// Автоматически распараллелить алгоритм std::uninitialized_copy
// выполнить вычислительные эксперименты

#include <iostream>
#include <vector>
#include <random>
#include <algorithm>
#include <execution>

using namespace std;

int main() {

	vector<int> d(50000000);
	mt19937 gen;
	uniform_int_distribution<int> dis(0, 500000);
	auto rand_num([=]() mutable { return dis(gen); });
	printf("Starting random\n");

	generate(execution::par, begin(d), end(d), rand_num);

	vector<int> e = d;
	vector<int> buffer1(50000000);
	vector<int> buffer2(50000000);

	printf("Starting normal algo\n");

	unsigned int start_time = clock();
	uninitialized_copy(execution::seq, begin(d), end(d), begin(buffer1));
	unsigned int end_time = clock();
	unsigned int search_time = end_time - start_time;

	printf("Total time in milliseconds: %d\n", search_time);

	printf("Starting parallel algo\n");

	start_time = clock();
	uninitialized_copy(execution::par, begin(e), end(e), begin(buffer2));
	end_time = clock();
	search_time = end_time - start_time;
	printf("Total time in milliseconds: %d\n", search_time);

	return 0;
}