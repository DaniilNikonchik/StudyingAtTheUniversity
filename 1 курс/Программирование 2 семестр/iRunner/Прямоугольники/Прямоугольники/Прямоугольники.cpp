#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ifstream fin("rect.in");
	ofstream fout("rect.out");
	int Xmax = 0;
	fin >> Xmax;
	int Ymax = 0;
	fin >> Ymax;
	short int N = 0;
	fin >> N;
	N *= 2;   
	vector<pair<int, char>> Shadow(N);
	for (int i = 0; i < N; i++)
	{
		int b_l_X = 0;
		fin >> b_l_X;
		int b_l_Y = 0;
		fin >> b_l_Y;
		int t_r_X = 0;
		fin >> t_r_X;
		int t_r_Y = 0;
		fin >> t_r_Y;
		int t_l_X = b_l_X;
		int t_l_Y = t_r_Y;
		int b_r_X = t_r_X;
		int b_r_Y = b_l_Y;
		int Coord = 0;
		double Position = 0.0;
		if (t_l_Y != 0)
		{
			Position = (double)t_l_X * Ymax / t_l_Y;
			Coord = ceil(Position);
		}
		else
			Coord = INT_MAX;
		Shadow[i] = make_pair(Coord, '(');
		i++;
		if (b_r_Y != 0)
		{
			Position = (double)b_r_X * Ymax / b_r_Y;
			Coord = floor(Position);
		}
		else
			Coord = INT_MAX;
		Shadow[i] = make_pair(Coord, ')');
	}
	sort(Shadow.begin(), Shadow.end());
	short int curr_count = 0;
	short int max_count = 0;
	int result_Coord = 0;
	for (pair<int, char> sh : Shadow)
	{
		if (sh.second == '(')
			curr_count++;
		else if (sh.second == ')')
			curr_count--;
		if (curr_count > max_count)
		{
			max_count = curr_count;
			result_Coord = sh.first;
		}
	}
	int result_X = 0;    
	int result_Y = 0;    
	if (result_Coord > Xmax)
	{
		result_X = Xmax;
		result_Y = Xmax + Ymax - result_Coord;
	}
	else
	{
		result_X = result_Coord;
		result_Y = Ymax;
	}
	fout << max_count << " " << result_X << " " << result_Y;
	fin.close();
	fout.close();
	return 0;
}
