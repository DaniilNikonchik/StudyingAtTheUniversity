#include <iostream>
#include <math.h>
#include <string>
#include <vector>

using namespace std;

class Summator
{
public:
    long long* inputArr;
    long long* sumArr;
    long long size;
    Summator(long long count, long long* arr)
    {
        inputArr = new long long[count];
        size = sqrt(count);
        long long len = (count % size == 0) ? (count / size) : (count / size + 1);
        sumArr = new long long[len];
        for (long long i = 0; i < count; i++)
            inputArr[i] = arr[i];
        for (long long i = 0; i < len; i++)
            sumArr[i] = 0;
        for (long long i = 0, k = 0; i < count; i++)
        {
            long long j = i;
            for (long long step = 0; step < size && j < count; j++, step++)
                sumArr[k] += inputArr[j];
            k++;
            i = j - 1;
        }
    }
    void Add(long long index, long long value)
    {
        inputArr[index] += value;
        sumArr[index / size] += value;
    }
    long long FindSum(long long begin, long long end)
    {
        long long beginBlock = begin / size;
        long long endBlock = end / size;
        long long sum = 0;
        if (beginBlock == endBlock)
        {
            for (long long i = begin; i < end; i++)
                sum += inputArr[i];
            return sum;
        }
        for (long long i = begin; i < (beginBlock + 1) * size; i++)
            sum += inputArr[i];
        for (long long i = beginBlock + 1; i < endBlock; i++)
            sum += sumArr[i];
        for (long long i = endBlock * size; i < end; i++)
            sum += inputArr[i];
        return sum;
    }
};

int main()
{
    long long n;
    cin >> n;
    long long* arr = new long long[n];
    for (long long i = 0; i < n; i++)
        cin >> arr[i];
    Summator summator(n, arr);
    long long cntCommands;
    cin >> cntCommands;
    string command;
    long long a, b;
    vector<long long> sums;
    for (long long i = 0; i < cntCommands; i++)
    {
        cin >> command >> a >> b;
        if (command == "FindSum")
            sums.push_back(summator.FindSum(a, b));
        else
            summator.Add(a, b);
    }
    long long len = sums.size();
    for (long long i = 0; i < len; i++)
    {
        cout << sums[i] << endl;
    }
}