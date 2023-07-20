#include <iostream>
#include <fstream>

int main() 
{
	std::ifstream fin("in.txt");
	int n, i, max = 0, min = 0;
	fin >> n;
	int* a = new int[n];
	for (i = 0; i < n; ++i)
		fin >> a[i];
	for (i = 0; i < n; ++i)
	{
		int start = i;
		for (; i < n - 1 && a[i] >= a[i + 1]; ++i);
		if (i - start >= max - min) 
		{
			max = i;
			min = start;
		}
	}
	std::ofstream fout("out.txt");
	for (i = 0; i < n; ++i)
		fout << a[i] << ' ';
	fout << '\n' << min << ' ' << max;
	fin.close();
	fout.close();
	return 0;
}
