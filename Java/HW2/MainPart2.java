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
    HashMap<String, Integer> counter = new HashMap<String, Integer>();

    for (String str : Data.users) {
      User u = new User(str);

      if (!(counter.keySet().contains(u.getState()))) {
        counter.put(u.getState(), 1);
      } else {
        counter.replace(u.getState(), counter.get(u.getState()) + 1);
      }
    }

    ArrayList<StateCounter> sorting = new ArrayList<StateCounter>();

    for (Map.Entry<String, Integer> entry : counter.entrySet()) {
      sorting.add(new StateCounter(entry.getKey(), entry.getValue()));
    }
    Collections.sort(sorting);

    System.out.println(sorting.toString());
  }
}
