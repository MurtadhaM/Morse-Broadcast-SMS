"""
Author: Murtadha Marzouq
Lab: 2
Write a Python class named Circle constructed by a radius and two methods which will compute the area and the perimeter of a circle. (15 points)
Sample input:
Enter the radius: 3
Expected output:
Area of circle: 28.26
Perimeter of circle: 18.84


"""

class Circle:
    def __init__(self, radius):
        self.radius = radius
    def get_area(self):
        return self.radius ** 2 * 3.14
    def get_perimeter(self):
        return 2 * self.radius * 3.14

# get input from user
radius = int(input("Enter the radius: "))
# instantiate class
myCircle = Circle(radius)

# fetch area and perimeter
area = myCircle.get_area()
parameter = myCircle.get_perimeter()

# print output
print("Area of circle: " + str(area))
print("Perimeter of circle: " + str(parameter))  
