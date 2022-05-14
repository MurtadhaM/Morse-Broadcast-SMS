import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */

public class MainPart4Bonus  {
  public static void main(String[] args) {

    // Creates a new user with the given information.
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<User> otherUsers = new ArrayList<User>();
    // populate the users arraylist
    for (int i = 0; i < Data.users.length; i++) {
      // Creates a new User object from the given string.
      User u1 = new User(new String(Data.users[i]));
      User u2 = new User(new String(Data.otherUsers[i]));
      users.add(u1);
      otherUsers.add(u2);
    }
    ArrayList<User> commonUsers = new ArrayList<User>();
    // For each user , compare the user's name with the other users' attributes.
    users.forEach((user) -> {
          otherUsers.forEach((otherUser) -> {
            if (user.isEquals(otherUser)) {
              commonUsers.add(user);
            }
          });
    });

    // Creating a comparator to sort the users by state.
    Comparator<User> byState = (User u1, User u2) -> u1.getState().compareTo(u2.getState());
        // Sort the users by state.
    Collections.sort(commonUsers, byState);
    // Print the users
    for (User user : commonUsers) {
      System.out.println(user.toString());
    }



  }
}
