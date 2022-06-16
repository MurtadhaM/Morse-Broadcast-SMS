"""
Author: Murtadha Marzouq
Lab: 2
Write a Python program which receives two dictionaries and combine them by adding values for common keys. (15 points)
Sample input:
Input first dictionary: {'a': 100, 'b': 200, 'c': 300}
Input second dictionary: {'a': 300, 'b': 200, 'd': 400}


Expected output:
{'a': 400, 'b': 400, 'd': 400, 'c': 300}


"""
def B3(dict1, dict2):
    output_dict = {}
    # combine common keys
    for key in dict1:
        if key in dict2:
            output_dict[key] = dict1[key] + dict2[key]
        else:
            output_dict[key] = dict1[key]
    # combine uncommon keys
    for key in dict2:
        if key not in dict1:
            output_dict[key] = dict2[key]
    return output_dict            



# for testing
# first_dict = {'a': 100, 'b': 200, 'c': 300}
# second_dict = {'a': 300, 'b': 200, 'd': 400}

# get input from user
first_dict = input("Input first dictionary: ")
second_dict = input("Input second dictionary: ")

# store input in dictionary
output_dict = B3(first_dict, second_dict)

# print output
print(output_dict)
