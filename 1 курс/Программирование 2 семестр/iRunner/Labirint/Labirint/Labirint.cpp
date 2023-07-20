#include <iostream>
#include<fstream>
#include<vector>
#include<queue>
using namespace std;

void main()
{
	ofstream fout("maze.out");
	ifstream fin("maze.in");
	int m, n;
	int beginX, beginY;
	int endX, endY;
	fin >> m >> n;
	fin >> beginX >> beginY;
	fin >> endX >> endY;
	pair<int, pair<int, int>>** canVisit = new pair<int, pair<int, int>> * [m];
	for (int i = 0; i < m; i++)
		canVisit[i] = new  pair<int, pair<int, int>>[n];
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			fin >> canVisit[i][j].first;
			canVisit[i][j].second.first = i;
			canVisit[i][j].second.second = j;
		}
	}
	pair<int, int>** matr = new pair<int, int> * [m];
	for (int i = 0; i < m; i++)
		matr[i] = new pair<int, int>[n];
	for (int i = 0; i < m; i++)
	{
		for (int j = 0; j < n; j++)
		{
			matr[i][j].first = 0;
			matr[i][j].second = 0;
		}
	}
	int newX, newY;
	queue <pair<int, pair<int, int>>> Way;
	Way.push(canVisit[beginX - 1][beginY - 1]);
	while (!Way.empty())
	{
		newX = Way.front().second.first;
		newY = Way.front().second.second;
		canVisit[newX][newY].first = 2;
		if (newX > 0 && (canVisit[newX - 1][newY].first == 1))
		{
			matr[newX - 1][newY].first = newX;
			matr[newX - 1][newY].second = newY;
			canVisit[newX - 1][newY].first = 2;
			Way.push(canVisit[newX - 1][newY]);
		}
		if (newX < m - 1 && (canVisit[newX + 1][newY].first == 1))
		{
			matr[newX + 1][newY].first = newX;
			matr[newX + 1][newY].second = newY;
			canVisit[newX + 1][newY].first = 2;
			Way.push(canVisit[newX + 1][newY]);
		}
		if (newY < n - 1 && (canVisit[newX][newY + 1].first == 1))
		{
			matr[newX][newY + 1].first = newX;
			matr[newX][newY + 1].second = newY;
			canVisit[newX][newY + 1].first = 2;
			Way.push(canVisit[newX][newY + 1]);
		}
		if (newY > 0 && (canVisit[newX][newY - 1].first == 1))
		{
			matr[newX][newY - 1].first = newX;
			matr[newX][newY - 1].second = newY;
			canVisit[newX][newY - 1].first = 2;
			Way.push(canVisit[newX][newY - 1]);
		}
		if (newX == endX - 1 && newY == endY - 1)
			goto link;
		Way.pop();
	}
	fout << -1;
	if (0 == 1)
	{
	link:
		pair<int, int> end = matr[endX - 1][endY - 1];
		vector<pair<int, int>>parents;
		while (true)
		{
			int prevX = end.first;
			int prevY = end.second;
			if (prevX == 0 && prevY == 0)
				break;
			parents.push_back(end);
			end = matr[prevX][prevY];
		}
		fout << parents.size() << endl;
		for (int i = parents.size() - 1; i >= 0; i--)
			fout << ++parents[i].first << " " << ++parents[i].second << endl;
		fout << endX << " " << endY << endl;
	}
	for (int i = 0; i < m; i++)
		delete[]canVisit[i];
	delete[]canVisit;
	for (int i = 0; i < m; i++)
		delete[]matr[i];
	delete[]matr;
}