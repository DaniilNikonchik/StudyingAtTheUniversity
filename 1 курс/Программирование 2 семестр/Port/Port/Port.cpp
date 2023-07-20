#include <iostream>
#include <fstream>
#include <deque>
#include <vector>
#include <string>
using namespace std;

int main()
{
	setlocale(LC_ALL, "rus");
	ifstream fin("SHIPS.IN");
	ofstream fout("SHIPS.OUT");
	if (!fin.is_open())
	{
		fout << "File can't be opened" << endl;
		return 0;
	}
	if (fin.peek() == EOF)
	{
		fout << "File is empty" << endl;
		return 0;
	}
	int N;
	fin >> N;
	vector < pair <bool, string>> port(N + 1);
	deque <string> rade;
	int command;
	string name;
	int all = 0;
	while (fin >> command)
	{
		switch (command)
		{
		case 1:
			getline(fin, name);
			for (int i = 1; i <= N; i++)
			{
				if (all == N)
				{
					rade.push_back(name);
					fout << "Все причалы заняты. Корабль" << name << " отправляется в рейд." << endl;

					break;
				}
				if (!port[i].first)
				{
					port[i].second = name;
					fout << "Корабль" << name << " прибыл в порт" << endl;
					port[i].first = true;
					all++;
					break;
				}
			}
			break;
		case 2:
			int prichal;
			fin >> prichal;
			port[prichal].first = false;
			all--;
			fout << "Причал №" << prichal << " освободился" << endl;
			if (rade.size() != 0)
			{
				port[prichal].second = rade.front();
				rade.pop_front();
				fout << "Корабль" << port[prichal].second << " прибыл в порт" << endl;
				port[prichal].first = true;
				all++;
			}
			break;
		case 3:
			fout << "Кол-во кораблей в очереди: " << rade.size() << endl;
			if (rade.size() > 0)
			{
				fout << "Корабли в очереди:" << endl;
				for (int i = 0; i < rade.size(); i++)
				{
					fout << '-' << rade[i] << endl;
				}
			}

			break;
		case 4:
			fout << "Текущее состояие порта:" << endl;
			if (all == N)
				fout << "Все причалы заняты!" << endl;
			for (int i = 1; i <= N; i++)
			{
				if (port[i].first)
					fout << "На причале №" << i << " находится корабль" << port[i].second << endl;
				else
					fout << "Причал №" << i << " свободен" << endl;
			}
			break;
		}
	}
}