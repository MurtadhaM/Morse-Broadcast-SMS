/*
Author: Murtadha Marzouq
b)     Substring Search – Check whether a sequence of characters is present in the string (20 points)
            Input : Enter a string
                        Enter a string to be searched in the first string
Output : The modified string
Sample Input & Output:-
Input : howareyou
            are
Output : Yes
Input : coolbuddy
    buy
Output: No
Input : advantages
    van
Output: Yes

*/

#include <iostream>
#include <string.h>

// to use cin and cout
using namespace std;

int main()
{

  // Declaring the strings and the substring
  string stringValue;
  string substringValue;

  // prompt the user to enter the string
  cout << "String Input: ";
  // Taking input from user
  cin >> stringValue;
  cout << "Substring Input: ";
  cin >> substringValue;

  int sizeofString = stringValue.length();
  int sizeofSubString = substringValue.length();
  int memValue = 0;

  for (int i = 0; i <= sizeofString - sizeofSubString; i++)
  {
    int j;
    for (j = 0; j < sizeofSubString; j++)
    {
      if (stringValue[i + j] != substringValue[j])
      {
        break;
      }
    }

    if (j == sizeofSubString)
    {
      memValue = 1;
      break;
    }
  }

  if (memValue == 1)
  {
    cout << "Output: Yes" << endl;
  }
  else
  {
    cout << "Output: No" << endl;
  }
}