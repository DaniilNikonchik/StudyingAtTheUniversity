#include <iostream>
#include <fstream>
#include <algorithm> // тут находится sort

//using namespace std; // а почему бы и не да?

int main()
{
	// Зачем эти деклараторы, да ещё внутри main? Выкинуть.
	//	void qsort(void* first, size_t number, size_t size, int (*comparator) (const void*, const void*));
	//	int funccmp(const void* val1, const void* val2);
	int n; // объявляй переменные рядом с тем местом, где будешь их использовать
	std::ifstream fin("bridge.in");
	std::ofstream fout("bridge.out"); // Я исправил на bridge.out
	fin >> n;
	int* a = new int[n];
	for (int i = 0; i < n; i++) 
	{
		fin >> a[i]; // ну fin же, а не cin всё, этот цикл больше ничего не должен елать
	}

	std::sort(a, a + n); // сортируем

	for (int i = 2; i < n; i++) 
	{
		a[i] = std::min(a[i] + a[i - 1] + a[0], a[i] + a[i - 2] + a[0] + 2 * a[1]);// Волшебная строчка Кашкевича
	}

	fout << a[n - 1];// В последнем будет лежать правильное зн.
	return 0;
}