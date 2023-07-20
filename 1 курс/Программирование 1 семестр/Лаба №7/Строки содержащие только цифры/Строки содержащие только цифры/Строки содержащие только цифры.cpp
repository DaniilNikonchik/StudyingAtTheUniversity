#include <iostream>
#include <fstream>
#include <string>
#include <ctype.h>
#include <locale>
#include <cctype>   // для функции isdigit
#include <cstdlib>

using namespace std;

int main()
{
	ifstream fin("stroki.in.txt");
	ofstream fout("stroki.out.txt");
	if (!fin.is_open())
	{
		fout << "The file can not be opened" << endl;
	}
	else
	{
		string str;
		bool notagroup = true;
		bool group = false;
		while (getline(fin, str))
		{
			for (int i = 0; i < str.length(); i++)
			{				
				if (isdigit(str[0]))    			       			       
				{
					group = true;
					if ((notagroup) && (group))
					{
						fout << "This is a group of numbers" << endl;
						group = false;
						notagroup = false;
					}
					fout << str << endl;
					break;
				}
				else
				{
					notagroup = true;
					group = false;
					break;
				}
			}
		}
		fin.close();
		fout.close();
	}
	return 0;
}