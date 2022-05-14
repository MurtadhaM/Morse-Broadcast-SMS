/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */

import java.util.*;

public class MainPart2 {

  /**
   * @param args
   */

  public static void main(String[] args) {
    // Adds a counter to the counter.
    HashMap<String, Integer> counter = new HashMap<String, Integer>();

    for (String str : Data.users) {
      // Creates a new User object from the given string.
      User u = new User(str);
      // Updates the counter with a new one.
      // Checks if the counter has a state.
      if (!(counter.keySet().contains(u.getState()))) {
        counter.put(u.getState(), 1);
      } else {
        counter.replace(u.getState(), counter.get(u.getState()) + 1);
      }
    }

    // Sorts the counters in ascending order.
    ArrayList<StateCounter> sorting = new ArrayList<StateCounter>();

    // Iterates over all entries in the map and adds them to the counters
    for (Map.Entry<String, Integer> entry : counter.entrySet()) {
      sorting.add(new StateCounter(entry.getKey(), entry.getValue()));
    }
    // Sorts the Collections in ascending order.
    Collections.sort(sorting);

    // Prints the sorting.
    System.out.println(sorting.toString());
  }
}
