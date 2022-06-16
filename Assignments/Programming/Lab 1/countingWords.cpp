
/*

Author: Murtadha Marzouq
A.    Counting Words - Write a C++ program to count the number of words.(20 points)
Input : Hi how are you? I am doing good
Output: 8
Input: Is it working?
Output: 3

*/

#include <iostream>
#include <string.h>

// to use cin and cout
using namespace std;

int main()
{

  // Declaring the string
  string str;
  // Declaring the number of the strings between the spaces
  int words = 0;

  // prompt the user to enter the string
  cout << "Input : ";

  // Taking input from user
  getline(cin, str);

  for (int i = 0; str[i] != '\0'; i++)
  {
    if (str[i] == ' ')
    {
      words++;
    }
  }

  // displaying the number of words and incrementing by 1 because the first word is 0 (I could have initialized it to 1 :))

  cout << "Output : " << words + 1 << endl;


  // returning 0 to the operating system for successful termination
  return 0;
}
