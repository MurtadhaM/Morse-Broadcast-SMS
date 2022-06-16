"""
Author: Murtadha Marzouq
Lab: 2
Write a Python program which receives a string and returns a new string with the first 2 and the last 2 chars from a given string. If the string length is less than 2, print out an appropriate message to the user. (10 points)
Sample input:
Please enter a string: python
Expected output:
pyon
Sample input:
Please enter a string: py
Expected output:
pypy
Sample input:
Please enter a string: p
Expected output:
Your string is too short!



"""

#Write a Python program which receives a string and returns a new string with the first 2 and the last 2 chars from a given string. If the string length is less than 2, print out an appropriate message to the user. (10 points)
from asyncore import read


def B1(string):
    if len(string) < 2:
        print("Your string is too short!")
    else:
        print(string[0:2] + string[-2:])
    return  string[0:2] + string[-2:]


input_str = input("Please enter a string: ")
B1(input_str)