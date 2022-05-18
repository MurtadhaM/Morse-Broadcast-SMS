/*
  Author: Murtadha Marzouq

  @description:In this question you will use the Data.users and Data.otherUsers arrays that include a list of users.
You are asked to perform the following tasks:
1. YourimplementationforthisquestionshouldbeincludedinMainPart4Bonus.java.
2. The goal is to print out the users that are exist in both the Data.users and
Data.otherUsers. Two users are equal if all their attributes are equal.
3. Print out the list of users which exist in both Data.users and Data.otherUsers. The
printed list of users should be sorted by state in descending order.

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MyMainPart4Bonus {
  private static User[] usersArray = new User[Data.users.length];
  private static User[] otherUsersArray = new User[Data.otherUsers.length];
  // Declare Collections of Users
  //ArrayList of Users
  private static ArrayList<User> usersArrayList = new ArrayList<User>(); // An Array but expandable
  private static HashSet<User> usersHashSet = new HashSet<User>(); // A set of unique elements
  private static HashMap<Integer, User> usersHashMap = new HashMap<Integer, User>(); // a map of element with key and value
  private static ArrayList<User> otherUsersArrayList = new ArrayList<User>(); // An Array but expandable

  /**
   * @return User[]
   */
  private static User[] getUsersArray() {
    for (int i = 0; i < Data.users.length; i++) {
      String[] user = Data.users[i].split(",");
      usersArray[i] =
        new User(
          user[0],
          user[1],
          user[3],
          user[4],
          user[5],
          user[6],
          Integer.parseInt(user[2])
        );
    }
    return usersArray;
  }

  
  /** 
   * @return User[]
   */
  
   public static User[] getOtherUsersArray() {
    for (int i = 0; i < Data.otherUsers.length; i++) {
      String[] user = Data.otherUsers[i].split(",");
      otherUsersArray[i] =
        new User(
          user[0],
          user[1],
          user[3],
          user[4],
          user[5],
          user[6],
          Integer.parseInt(user[2])
        );
    }
    return otherUsersArray;
  }

  public static void getUsersArrayList() {
    usersArrayList.addAll(Arrays.asList(usersArray));
  }

  public static void getOtherUsersArrayList() {
    otherUsersArrayList.addAll(Arrays.asList(otherUsersArray));
  }

  /**
   * @return HashSet<User>
   */
  public static HashSet<User> getUsersHashSet() {
    usersHashSet.addAll(Arrays.asList(usersArray));
    return usersHashSet;
  }

  /**
   * @return HashMap<Integer, User>
   */
  public static HashMap<Integer, User> getUsersHashMap() {
    for (int i = 0; i < usersArray.length; i++) {
      usersHashMap.put(usersArray[i].hashCode(), usersArray[i]);
    }
    return usersHashMap;
  }

  /**
   * @param users
   */
  public static <T> void printValues(T users) {
    String type = users.getClass().getSimpleName();

    System.out.println("Printing " + type + " values");
    if (type.equals("ArrayList")) {
      for (int i = 0; i < usersArrayList.size(); i++) {
        System.out.println(usersArrayList.get(i));
      }
    } else if (type.equals("HashSet")) {
      for (User user : usersHashSet) {
        System.out.println(user);
      }
    } else if (type.equals("HashMap")) {
      for (Map.Entry<Integer, User> entry : usersHashMap.entrySet()) {
        System.out.println(entry.getValue());
      }
    } else if (type.equals("User[]")) {
      for (int i = 0; i < usersArray.length; i++) {
        System.out.println(usersArray[i]);
      }
    } else {
      System.out.println("Invalid type");
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    getOtherUsersArray();
    getUsersArray();

    getUsersArrayList();
    getOtherUsersArrayList();
    ArrayList<User> users = usersArrayList;
    ArrayList<User> otherUsers = otherUsersArrayList;
    ArrayList<User> commonUsers = new ArrayList<User>();
    // For each user , compare the user's name with the other users' attributes.
    users.forEach(
      user -> {
        otherUsers.forEach(
          otherUser -> {
            if (user.isEquals(otherUser)) {
              commonUsers.add(user);
            }
          }
        );
      }
    );

    // Creating a comparator to sort the users by state.
    Comparator<User> byState = (User u1, User u2) ->
      u2.getState().compareTo(u1.getState());

    // Sort the users by state in decending order.

    Collections.sort(commonUsers, byState);

    // Print the users
    for (User user : commonUsers) {
      System.out.println(user.toString());
    }
  }
}
