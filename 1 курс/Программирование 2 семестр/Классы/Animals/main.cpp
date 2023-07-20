#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include "Animals.h"
using namespace std;

int main() {
	setlocale(LC_ALL, "Russian");
	ifstream fin("input.txt");
	ofstream fout("output.txt");

	if (!fin.is_open()) {
		fout << "������ �������� �����!" << endl;
	}
	else if (fin.peek() == EOF) {
		fout << "���� ����!" << endl;
	}
	else {
		vector <Animals> vec;
		Animals temp_object;
		string value_on;
		string value_ak;
		string value_an;
		unsigned short value_aa;
		string trash;
		while (fin.peek() != EOF) {
			getline(fin, value_on, ',');
			getline(fin, value_ak, ',');
			getline(fin, value_an, ',');
			if (value_an == "") {
				value_an = "������ �����������";
			}
			fin >> value_aa;
			getline(fin, trash);
			temp_object.Set_Ownername(value_on);
			temp_object.Set_Animalkind(value_ak);
			temp_object.Set_Animalname(value_an);
			temp_object.Set_Animalage(value_aa);
			vec.push_back(temp_object);
		}

		short pointer_of_operation;
		cout << "������� ��������������� ����� ��� ��������, ������� �� ������ ��������� : " << endl << endl;
		cout << "1 - ��������� ���������� ��������� ����� �������� � ������� ���������" << endl << endl;
		cout << "2 - ��� ����������� ���� ��������� (�������� �������������) ������� ���� ��� ���������� � ������." << endl;
		cout << "��������� � ������ �� ������ �����������" << endl << endl;
		cout << "3 - ����������, ������� ����� �������� ����� ����������� ������ (������ �������� �������������)." << endl << endl;
		cout << "4 - ������� ���������� � �������� ������ ������� � ������ �������� ��������� ������� ����." << endl << endl;
		for (;;) {
			cin >> pointer_of_operation;
			if (pointer_of_operation < 1 || pointer_of_operation > 4) {
				cout << "�������� ����! ������� ����� �� 1 �� 4." << endl;
			}
			else {
				break;
			}
		}
		
		if (pointer_of_operation == 1) {
			vector <string> vecownernames;
			vector <string> differentanimals;
			vector <string> finalta;	
			int counter1 = 0;
			int tempcounter1 = 0;

			for (int i = 0; i < vec.size(); i++) {
				for (int j = 0; j < vecownernames.size(); j++) {
					if (vec[i].Get_Ownername() == vecownernames[j]) {
						++tempcounter1;
					}
				}
				if (tempcounter1 == 0) {
					vecownernames.push_back(vec[i].Get_Ownername());
					tempcounter1 = 0;
				}
				else {
					tempcounter1 = 0;
				}

			}

			for (int i = 0; i < vecownernames.size(); i++) {
				for (int j = 0; j < vec.size(); j++) {
					if (vecownernames[i] == vec[j].Get_Ownername()) {
						for (int x = 0; x < finalta.size(); x++) {
							if (vec[j].Get_Animalkind() == finalta[x]) {
								++counter1;
							}
						}
						if (counter1 == 0) {
							finalta.push_back(vec[j].Get_Animalkind());
							counter1 = 0;
						}
						else {
							counter1 = 0;
						}
					}
				}
					cout << "��� ���������: " << vecownernames[i] << " " << "���������� ��������� ����� :" << finalta.size() << endl;

				while (!finalta.empty()) {
					finalta.pop_back();
				}
			}
		}
		
		else if (pointer_of_operation == 2) {
			string type_animal;
			short veccounter = 0;
			vector <string> vecon;
			vector <string> vecan;
			int counter2 = 0;
			cout << "������� ��� ���������, ����� �������� ��� ���� ����������: ";
			cin.ignore();
			getline(cin, type_animal);
			for (int i = 0; i < vec.size(); i++) {
				if (vec[i].Get_Animalkind() == type_animal) {
					for (int j = 0; j < vecon.size(); j++) {
						if (vec[i].Get_Ownername() == vecon[j]) {
							++veccounter;
						}
						if (vec[i].Get_Animalname() == vecan[j]) {
							++veccounter;
						}
					}
					if (veccounter != 0) {
						veccounter = 0;
						continue;
					}
					else {
						veccounter = 0;
					}
					++counter2;
					cout << "��� ���������: " << vec[i].Get_Ownername() << endl;
					cout << "������: " << vec[i].Get_Animalname() << endl << endl;
					vecon.push_back(vec[i].Get_Ownername());
					vecan.push_back(vec[i].Get_Animalname());

				}
			}
			if (counter2 == 0) {
				cout << " ��� �������� ������ ����." << endl;
			}
		}
		
		else if (pointer_of_operation == 3) {
			int counter3 = 0;
			string animaln;
			vector <string> tempvecan;
			cout << "������� ������ ���������: " << endl;
			cin.ignore();
			getline(cin, animaln);
			for (int i = 0; i < vec.size(); i++) {
				if (vec[i].Get_Animalname() == animaln) {
					for (int j = 0; j < tempvecan.size(); j++) {
						if (tempvecan[j] == vec[i].Get_Animalkind()) {
							++counter3;
						}
					}
					if (counter3 != 0) {
						counter3 = 0;
						continue;
					}
					else
					{
						counter3 = 0;
					}
					tempvecan.push_back(vec[i].Get_Animalkind());
				}
			}

			cout << "���������� ����� �������� ������� ������ ������: " << tempvecan.size() << endl;
		}
	
		else if (pointer_of_operation == 4) {
			vector <string> vecanimalkinds;
			int counter4 = 0;
			int minage = INT_MAX;
			int maxage = 0;

			for (int i = 0; i < vec.size(); i++) {
				for (int j = 0; j < vecanimalkinds.size(); j++) {
					if (vec[i].Get_Animalkind() == vecanimalkinds[j]) {
						++counter4;
					}
				}
				if (counter4 != 0) {
					counter4 = 0;
					continue;
				}
				else {
					counter4 = 0;
					vecanimalkinds.push_back(vec[i].Get_Animalkind());

				}
			}

			for (int i = 0; i < vecanimalkinds.size(); i++) {
				for (int j = 0; j < vec.size(); j++) {
					if (vec[j].Get_Animalkind() == vecanimalkinds[i]) {
						if (vec[j].Get_Animalage() < minage) {
							minage = vec[j].Get_Animalage();
						}
						if (vec[j].Get_Animalage() > maxage) {
							maxage = vec[j].Get_Animalage();
						}
					}
				}

				cout << "��� ���������: " << vecanimalkinds[i] << endl;
				cout << "����������� �������: " << minage << " " << "������������ �������: " << maxage << endl << endl;
				minage = INT_MAX;
				maxage = 0;
			}
		}
	}
	system("pause");
}
