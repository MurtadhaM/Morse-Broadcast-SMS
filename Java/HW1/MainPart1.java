/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */
import java.util.*;

public class MainPart1 {

  
  /** 
   * @param args
   */
  public static void main(String[] args) {
    ArrayList<User> users = new ArrayList<User>();

    for (String str : Data.users) {
      users.add(new User(str));
    }

    Collections.sort(users);

    for (int i = 0; i < 10; i++) {
      System.out.println(users.get(i).toString());
    }
  }
}
