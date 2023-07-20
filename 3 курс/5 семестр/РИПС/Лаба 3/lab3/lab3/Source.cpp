#include <cstring>
#include <cstdio>
#include <string>
#include <iostream>
#include <windows.h>
#include <vector>
#include <fstream>
using namespace std;
#pragma warning(disable : 4996)
#define n 5
#define N 5000




struct parameters
{
    int start;
    int finish;
    int szag;
};


vector<string> paths;
int* results;
string word = "here";
string path = "C:\\Users\\dmin\\Desktop\\3 курс\\РИПС\\Лаба 3\\lab3\\filles\\";
string zapoln[3] = { "here", "I", "am" };






void createFiles() {
    for (int i = 0; i < N; i++) {
        string p = path + to_string(i) + ".txt";
        ofstream f(p);
        for (int k = 0; k < 10; k++)
            f << " " << zapoln[rand() % 3];
        paths.push_back(p);
        f.close();
    }
}



DWORD WINAPI ThreadFunction1(LPVOID pvParam)
{
    parameters* par = (parameters*)pvParam;
    int kolvo = 0;

    for (int i = par->start; i < par->finish; i += par->szag) {
        kolvo = 0;
        string line;
        fstream file(paths[i]);

        
        while (file >> line) {
            if (line == word) {
                kolvo++;
            }
        }

        results[i] = kolvo;
    }

    return 0;
}



int main(int argc, char** argv)
{
    HANDLE hThreads[n];
    parameters parameter[n];
    createFiles();
    int kolvo = N;
    int s = kolvo / n;
    results = new int[kolvo];
    
    
    LARGE_INTEGER liFrequency, liStartTime, liFinishTime;
    QueryPerformanceFrequency(&liFrequency);
    QueryPerformanceCounter(&liStartTime);


    for (int k = 0; k < n; k++)
    {
        parameter[k].start = k * s;
        if (k != n - 1)
            parameter[k].finish = s * (k + 1);
        else
            parameter[k].finish = kolvo;
        parameter[k].szag = 1;
        hThreads[k] = CreateThread(NULL, 0, ThreadFunction1, (LPVOID) & (parameter[k]), 0, NULL);
        if (hThreads[k] == NULL) // обработка ошибки
        {
            printf("Create Thread %d Error=%d\n", k, GetLastError());
            return -1;
        }
    }



    WaitForMultipleObjects(n, hThreads, TRUE, INFINITE);

    QueryPerformanceCounter(&liFinishTime);
    double total = 1000. * (liFinishTime.QuadPart - liStartTime.QuadPart) / liFrequency.QuadPart;

    for (int k = 0; k < n; ++k)
        CloseHandle(hThreads[k]);
        
    for (int i = 0; i < kolvo; i++) 
        cout << paths[i] << ": " << results[i] << ";\n";

   
    cout << "\nTotal: " << total << "\n";


    return 0;
}
