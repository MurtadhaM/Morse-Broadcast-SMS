/*
Author: Murtadha Marzouq
Question: 4
Now write code generate 10 random numbers and assign it to an array. Now find the factorial of those 10 random numbers generated assign it to another array. Now print the output using Iterator based for loop and Index based for loop.
*/
import java.util.*;
public class four {
  // recursive factoria function
  public static int factorial(int num) {
    if (num <= 1) return num;
    return (num * factorial(num - 1));
  }
  public static void main(String[] args) {
    // setting arrays to store random numbers and factorials
    int[] initaialArray = new int[10];
    int[] factArray = new int[10];
    // loop to generate 10 random numbers
    for (int i = 0; i < 10; i++) {
      initaialArray[i] = (int) (Math.random() * 10);
    }
    // loop through the array and find the factorial of each element
    for (int i = 0; i < initaialArray.length; i++) {
      factArray[i] = factorial(initaialArray[i]);
    }
    // printing the array using index based for loop
    System.out.println("*** Using index ***\n");
    for (int i = 0; i < factArray.length; i++) {
      System.out.println(factArray[i]);
    }
    // printing the array using iterator based for loop
    System.out.println("\n *** Using Iterator ***");
    for (int i : factArray) {
      System.out.println(i);
    }
  }
}
