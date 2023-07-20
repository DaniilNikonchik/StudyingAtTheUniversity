#include <iostream>

bool BinarySearch(int requiredElement, int* array, int arrayLength)
{
	int leftBound = 0, rightBound = arrayLength;
	while (leftBound < rightBound)
	{
		int mid = (leftBound + rightBound) / 2;
		if (requiredElement == array[mid])
			return 1;
		else
			if (requiredElement < array[mid])
				rightBound = mid;
			else
				leftBound = mid + 1;
	}
	return 0;
}

int LowerBound(int requiredElement, int* array, int arrayLength)
{
	int leftBound = 0, rightBound = arrayLength;
	while (leftBound < rightBound)
	{
		int mid = (leftBound + rightBound) / 2;

		if (requiredElement <= array[mid])
			rightBound = mid;
		else
			leftBound = mid + 1;
	}
	return leftBound;
}

int UpperBound(int requiredElement, int* array, int arrayLength)
{
	int leftBound = 0, rightBound = arrayLength;
	while (leftBound < rightBound)
	{
		int mid = (leftBound + rightBound) / 2;

		if (requiredElement < array[mid])
			rightBound = mid;
		else
			leftBound = mid + 1;
	}
	return leftBound;
}

int main()
{
	std::ios_base::sync_with_stdio(false);

	int n, k;
	std::cin >> n;
	int* arrayOfElements = new int[n];
	for (int i = 0; i < n; i++)
		std::cin >> arrayOfElements[i];
	std::cin >> k;
	int* arrayOfRequests = new int[k];
	for (int i = 0; i < k; i++)
	{
		std::cin >> arrayOfRequests[i];
		std::cout << BinarySearch(arrayOfRequests[i], arrayOfElements, n) << ' ' <<
			LowerBound(arrayOfRequests[i], arrayOfElements, n) << ' ' <<
			UpperBound(arrayOfRequests[i], arrayOfElements, n) << '\n';
	}
	delete[] arrayOfElements;
	delete[] arrayOfRequests;
	return 0;
}