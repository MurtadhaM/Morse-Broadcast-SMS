"""
A) Python identifiers must begin with a capital or lower case letter (A to Z and a to zor
underscore ( _ ). The initial character may be followed by zero or more letters, underscores, or
digits, in any combination. Write a regular expression for such identifiers (10 points)
B) Write a regular expression (RE) for Social Security Number (SSN). Your rule will match a
hyphen-separated SSN in the format NNN-NN-NNNN, but the first digit cannot be a zero.
Example: 111-22-9912 (valid) 010-56-0987 (invalid) (10 points)

"""

import re

Input1 = "121_123ABC_"
Input2 = "612-56-1987"
Input3 = "0123"
result1 = re.match(r'[a-zA-Z_][0-9a-zA-Z_]*', Input1)
print(result1)
result2 = re.match(r'^\d{3}-\d{2}-\d{4}$', Input2)
print(result2.groups())


