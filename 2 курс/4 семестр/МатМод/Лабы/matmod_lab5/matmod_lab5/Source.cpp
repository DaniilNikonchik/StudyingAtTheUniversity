#include <iostream>
#include <fstream>
#include <time.h>



using namespace std;

double X_Answer[] = { 1.83801, 2.33645, -0.903427 };

double sqr(double x){
	return x*x;
}

int getMarkovRand(double** P, int curState, int sz) {
	double rd = (double)rand() / RAND_MAX;
	for (int i = 0; i < sz; ++i) {
		rd -= P[curState][i];
		if (rd <= 0)
			return i;
	}
	return sz - 1;
}

double calculate_coord(double** a, int coord, int n, double* f, double** P, int MARKOV_LEN, int MARKOV_CNT) {
	int M_Prev, M;
	double Q_Prev, Q;
	double X = 0;
	for (int i = 0; i < MARKOV_CNT; ++i) {
		M_Prev = coord;
		Q_Prev = 1;
		for (int j = 1; j < MARKOV_LEN; ++j)
		{
			M = getMarkovRand(P, M_Prev, n);
			if (P[M_Prev][M]>0)
				Q = Q_Prev * a[M_Prev][M] / P[M_Prev][M];
			else
				Q = 0;
			X += Q * f[M];
			Q_Prev = Q;
			M_Prev = M;
		}
	}
	return (f[coord] + X / MARKOV_CNT);
}

void cmpAnswers(double* X, double* RealX, int n) {
	cout << "Calculated:   (" << X[0];
	for (int i = 1; i < n; ++i)
		cout << ", " << X[i];
	cout << ")\nReal answer: (" << RealX[0];
	for (int i = 1; i < n; ++i)
		cout << ", " << RealX[i];
	double diff = 0;
	for (int i = 0; i < n; ++i)
		diff += sqr(X[i] - RealX[i]);
	diff = sqrt(diff);
	cout << ")\nDiff: " << diff << endl;
}



void main() {
	srand(time(0));
	ifstream fin("matrix.txt");
	int n;
	fin >> n;
	double** a = new double*[n];
	double** h = new double*[n];
	double* f = new double[n];

	double* X = new double[n];

	double** P = new double*[n];

	for (int i = 0; i < n; ++i) {       //заполняю матрицу переходов цепи
		a[i] = new double[n];
		h[i] = new double[n];
		P[i] = new double[n];
		for (int j = 0; j < n; ++j) {
			fin >> a[i][j];
			h[i][j] = 0;
			P[i][j] = 1. / n;             
		}
		fin >> f[i];
		for (int j = 0; j < n; ++j)
			if (i == j) {
				a[i][j] = 1 - a[i][i];
				h[i][j] = 1;
			}
			else
				a[i][j] *= -1;
	}

	for (int i = 0; i < n; ++i)
		X[i] = calculate_coord(a, i, n, f, P, 50, 10000);
	cmpAnswers(X, X_Answer, n);

	system("pause");

	//Graphics begin
	ofstream fD("D.txt");
	ofstream fLen("Len.txt");
	ofstream fCnt("Cnt.txt");
	int max_cnt = 1000;
	for (int cnt = 10; cnt < max_cnt; cnt += 200) {
		system("cls");
		cout << "Generating graphics: " << (int)(sqr((double)cnt  / max_cnt)*100) << "%.";
		for (int len = 2; len < 30; len += 1) {
			double diff = 0;
			for (int rnd = 0; rnd < 10; ++rnd) {
				double cur_diff = 0;
				for (int i = 0; i < n; ++i)
					cur_diff += sqr(calculate_coord(a, i, n, f, P, len, cnt) - X_Answer[i]);
				diff += sqrt(cur_diff);
			}
			fLen << len << endl;
			fCnt << cnt << endl;
			fD << diff/10 << endl;
		}
	}
	fD.close();
	fLen.close();
	fCnt.close();
	system("python print.py");
	//Graphics end;

}
