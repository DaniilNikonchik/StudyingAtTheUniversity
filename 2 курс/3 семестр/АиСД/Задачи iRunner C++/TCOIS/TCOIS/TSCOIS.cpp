#include <fstream>
#include <queue>

using namespace std;

int main()
{
	ifstream fin("input.txt");
	ofstream fout("output.txt");
	priority_queue<int, vector<int>, std::greater<int> > Q;
	int n = 0, m = 0;
	fin >> n >> m;
	int** arr = new int* [n];
	for (int i = 0; i < n; i++)
		arr[i] = new int[m];
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			fin >> arr[i][j];
	for (int j = 0; j < m; j++)			
		for (int i = 0; i < n; i++)
		{
			Q.push(arr[i][j]);			
			if (Q.size() == m + 1)			
			{
				fout << Q.top() << " ";	
				Q.pop();				
			}
		}
	while (!Q.empty())					
	{
		fout << Q.top();				
		Q.pop();						
		if (!Q.empty())					
			fout << " ";				
	}
	for (int i = 0; i < n; i++)
		delete[] arr[i];
	delete[] arr;
	fin.close();
	fout.close();
	return 0;
}