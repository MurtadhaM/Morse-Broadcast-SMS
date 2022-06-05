"""
Author: Murtadha Marzouq
Lab: 2
Question 2
Write a Python program which receives a number of items in an invoice then asks for input the items (item name and price). Item and price will be separated by a space and each item should be entered in a separate line. Print out the invoice item and price order by their price. (20 points)
Sample input:
Number of items: 2
Input item and price: apple 5
Input item and price: onion 3


Expected output:
onion 3
apple 5



"""
def B4(num_items):
    item_price_dict = {}
    for i in range(num_items):
        input_str = input("Input item and price: ")
        item_name, price = input_str.split()
        item_price_dict[item_name] = int(price)
    # sort by price
    sorted_item_price_dict = sorted(item_price_dict.items(), key=lambda x: x[1])
    # print output
    for item_name, price in sorted_item_price_dict:
        print(f"{item_name} {price}")
    return sorted_item_price_dict
  

# get input from user
num_items = int(input("Number of items: "))
# call function
input_price_items = B4(num_items)  

