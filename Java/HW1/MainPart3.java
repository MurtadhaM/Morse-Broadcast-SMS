/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */

public class MainPart3 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // Sets the number of digits in the given array.
    int[] numbers = { 1, 2, 3, 2, 5, 2, 4, 6, 7 };
    printLongestSequence(numbers);
  }

  /**
   * @param input
   * @return int[]
   */
  public static int[] printLongestSequence(int[] input) {
    // Sets the start and end positions to 0.
    int maxLength = 0;
    int start = 0;
    int end = 0;

    // Computes the length of each element in the input array.
    for (int i = 0; i < input.length; i++) {
      int length = 1;
      int j = i;
      while (j < input.length - 1 && input[j] < input[j + 1]) {
        length++;
        j++;
      }
      // Returns the start and end positions of the input arrays.
      if (length > maxLength) {
        maxLength = length;
        start = i;
        end = j;
      } else if (length == maxLength) {
        if (input[i] < input[j]) {
          start = i;
          end = j;
        } else {
          start = j;
          end = i;
        }
      }
    }

    // print the longest sequence
    System.out.print("Longest sequence is: ");
    for (int i = start; i <= end; i++) {
      System.out.print(input[i] + " ");
    }
    return input;
  }
}
