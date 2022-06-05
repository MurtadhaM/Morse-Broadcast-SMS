"""
Author: Murtadha Marzouq
Lab: 2
Write a Python program which will find all numbers between two given numbers which are divisible by 7 but are not a multiple of 5. (15 points)


Hints:
Use range() method.
Sample input:
Please enter first number: 1000
Please enter second number: 1100
Expected output:
1001,1008,1022,1029,1036,1043,1057,1064,1071,1078,1092,1099

"""
def B2(num1, num2):
    output_values = ""  
    for i in range(num1, num2):
        if i % 7 == 0 and i % 5 != 0:
            output_values +=(f"{i} ")
    return output_values

# get input from user
input_value_1 = input("Please enter first number: ")
input_value_2 = input("Please enter second number: ")

# convert input to int and call function

output = B2(int(input_value_1), int(input_value_2))
# print output

print(str(output).replace(" ", ","))