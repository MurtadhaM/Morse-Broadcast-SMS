"""
Author: Murtadha Marzouq
Lab: 2
Define a sample class, which have a class parameter and have a same instance parameter. (10 points)
Sample story:
Create an instance without passing parameters then print the value.
Hints:
Structure of class will be important.
Expected output:
Bob
John


"""

class Person:
  name = "John"
  # default value overide by passing parameter
  def __init__(self, name=""):
    self.name = name
  def set_name(self, name):
        self.name = name  
  def print_name(self):
    print(self.name)
      # create instance



# instantiate class as Bob and John and print their name
Bob = Person("Bob") # instantiate class as Bob
Bob.print_name()

John =  Person() # instantiate class as John
John.set_name("John") # Set John's name
John.print_name() # print John's name
