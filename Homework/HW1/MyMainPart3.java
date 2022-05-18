/*
  Author: Murtadha Marzouq

  @description:This is a simple programming question that focuses on
  finding the longest increasing subarray. Given the array A = {1,2,3,2,5,2,4,6,7}
  the longest increasing subarray is {2,4,6,7}, note that the values have to be contiguous.
  You are asked to perform the following tasks:
  Note: Your implementation for this question should be included in MainPart3.java file.
  Implement the printLongestSequence method. You are provided with example inputs and outputs 
  in the provided Java project.

*/
public class MyMainPart3 {
  private static int[] A = { 1, 2, 3, 2, 5, 2, 4, 6, 7 };

  /**
   * @return int[]
   */
  // Get the longest increasing sequence of numbers
  public static int[] printLongestSequence() {
    int[] longestIncreasingSequence = new int[0];
    int[] currentIncreasingSequence = new int[0];
    for (int i = 0; i < A.length; i++) {
      if (i == 0) {
        currentIncreasingSequence = new int[] { A[i] };
      } else {
        if (A[i] > A[i - 1]) {
          currentIncreasingSequence = addToArray(currentIncreasingSequence, A[i]);
        } else {
          if (currentIncreasingSequence.length > longestIncreasingSequence.length) {
            longestIncreasingSequence = currentIncreasingSequence;
          }
          currentIncreasingSequence = new int[] { A[i] };
        }
      }
    }
    if (currentIncreasingSequence.length > longestIncreasingSequence.length) {
      longestIncreasingSequence = currentIncreasingSequence;
    }
    return longestIncreasingSequence;
  }

  /**
   * @param currentIncreasingSequence
   * @param i
   * @return int[]
   */
  private static int[] addToArray(int[] currentIncreasingSequence, int i) {
    int[] newArray = new int[currentIncreasingSequence.length + 1];
    for (int j = 0; j < currentIncreasingSequence.length; j++) {
      newArray[j] = currentIncreasingSequence[j];
    }
    newArray[newArray.length - 1] = i;
    return newArray;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] longestIncreasingSequence = printLongestSequence();

    // Print the longest increasing sequence
    for (int i = 0; i < longestIncreasingSequence.length; i++) {
      System.out.print(longestIncreasingSequence[i] + " ");
    }
  }
}
