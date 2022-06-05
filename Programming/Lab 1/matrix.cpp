
/*

Author: Murtadha Marzouq
1. Write a program to find the sum of elements above the diagonal of the matrix(Number of rows and columns of the matrix are equal) (20 points)
        Input: Size of the matrix
            Matrix
        Output : Sum
        Input : 3
            2 3 5
            6 7 8
            5 7 9
        Output: 16
*/
#include <iostream>
// to use cin and cout
using namespace std;

int main()
{

  // Declare Variable Size
  int size;
  // Taking input from user

  cout << "Input: Size of the matrix: ";

  cin >> size;

  // Declaring the matrix
  int arr[size][size];

  // Taking input from user
  cout << "Input: Matrix: ";

  for (int firstDimention = 0; firstDimention < size; firstDimention++)
  {

    for (int secondDimention = 0; secondDimention < size; secondDimention++)
    {

      cin >> arr[firstDimention][secondDimention];
    }
  }

  // Loop to find the sum of elements above the diagonal
  int total = 0;

  for (int i = 0; i < size; i++)
  {

    for (int j = i + 1; j < size; j++)
    {

      total += arr[i][j];
    }
  }

  cout << "OUTPUT: " << total << endl;
}