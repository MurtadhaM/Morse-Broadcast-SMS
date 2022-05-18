/*
  Author: Murtadha Marzouq

  @description: You are provided with the Data class that contains a users array (Data.users)
  which is an array of users. Each element in the array represents a single user record.
  Each record is a string formatted as : firstname,lastname,age,email,gender,city,state.
  You are asked to perform the following tasks:
1. YourimplementationforthisquestionshouldbeincludedinMainPart1.javafile.
2. Create a User class that should parse all the parameters for each user.
Hint: extract each value from a user's record using Java's String.split() method and set the delimiter to a comma,
see provided code below. Each user record should to be
assigned to a User object.
3. YourgoalistoPrintouttheTOP10oldestusers.
4. Hint: To sort use the Collections.sort(). http://docs.oracle.com/javase/6/docs/api/java/util/
Collections.html


*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MyMainPart1 {
  private static User[] usersArray = new User[Data.users.length];
  // Declare Collections of Users
  //ArrayList of Users
  private static ArrayList<User> usersArrayList = new ArrayList<User>(); // An Array but expandable
  private static HashSet<User> usersHashSet = new HashSet<User>(); // A set of unique elements
  private static HashMap<Integer, User> usersHashMap = new HashMap<Integer, User>(); // a map of element with key and value

  
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
    User[] users = getUsersArray();
    // print the values for each data type
    // printValues(users);
    // Creating A Comparator for sorting by age
    Comparator<User> sortByAge = (User u1, User u2) ->
      u1.getAge() - u2.getAge();

    Collections.sort(Arrays.asList(users), sortByAge);

    // Print the top 10 oldest users
    for (int i = 0; i < 10; i++) {
      System.out.println(users[users.length - 1 - i]);
    }
  }
}
