/*
  Author: Murtadha Marzouq

  @description: Using the same Data.users array. You are asked to perform the following tasks:
1. YourimplementationforthisquestionshouldbeincludedinMainPart2.javafile.
2. The goal is to count the number of users living each state. Print out the list of State,
Count order in ascending order by count.


*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class MyMainPart2 {
  private static User[] usersArray = new User[Data.users.length];
  // Declare Collections of Users
  //ArrayList of Users
  private static ArrayList<User> usersArrayList = new ArrayList<User>(); // An Array but expandable
  private static HashSet<User> usersHashSet = new HashSet<User>(); // A set of unique elements
  private static HashMap<Integer, User> usersHashMap = new HashMap<Integer, User>(); // a map of element with key and value
  private static HashMap<String, Integer> numberofUsersPerState = new HashMap<String, Integer>();

  /**
   * @return HashMap<String, Integer>
   */
  public static HashMap<String, Integer> getNumberofUsersPerState() {
    for (int i = 0; i < usersArray.length; i++) {
      String state = usersArray[i].getState();
      if (numberofUsersPerState.containsKey(state)) {
        numberofUsersPerState.put(state, numberofUsersPerState.get(state) + 1);
      } else {
        numberofUsersPerState.put(state, 1);
      }
    }
    return numberofUsersPerState;
  }

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

  public static void getUsersArrayList() {
    usersArrayList.addAll(Arrays.asList(usersArray));
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
    // Populate the usersArray
    getUsersArray();
    //Get the number of users per state
    getNumberofUsersPerState();
    // print the values for each data type
    // printValues(users);
    // Creating A Comparator for sorting by state

    // convert the HashMap to an array of Map.Entry objects
    ArrayList<Entry<String, Integer>> sortedbyState = new ArrayList<Entry<String, Integer>>(
      numberofUsersPerState.entrySet()
    );

    // sort the numberofUsersPerState by state (FOR GIGGLES)
    Collections.sort(
      sortedbyState,
      (Entry<String, Integer> o1, Entry<String, Integer> o2) ->
        o1.getKey().compareTo(o2.getKey())
    );

    // sort the numberofUsersPerState by count ACTUAL ANSWER
    Collections.sort(
      sortedbyState,
      (Entry<String, Integer> o1, Entry<String, Integer> o2) ->
        o1.getValue().compareTo(o2.getValue())
    );

    // Print the sorted list
    sortedbyState.forEach(System.out::println);
  }
}
