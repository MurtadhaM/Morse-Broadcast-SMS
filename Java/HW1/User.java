/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */

public class User implements Comparable<User> {
  private String firstName, lastName, email, gender, city, state;
  private int age;

  public User(
    String firstName,
    String lastName,
    String email,
    String gender,
    String city,
    String state,
    int age
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.city = city;
    this.state = state;
    this.age = age;
  }

  public User(String data) {
    String[] resultingTokens = data.split(",");
    this.firstName = resultingTokens[0];
    this.lastName = resultingTokens[1];
    this.age = Integer.parseInt(resultingTokens[2]);
    this.email = resultingTokens[3];
    this.gender = resultingTokens[4];
    this.city = resultingTokens[5];
    this.state = resultingTokens[6];
  }

  /**
   * @return String
   */
  @Override
  public String toString() {
    return (
      "User{" +
      "firstName='" +
      firstName +
      '\'' +
      ", lastName='" +
      lastName +
      '\'' +
      ", email='" +
      email +
      '\'' +
      ", gender='" +
      gender +
      '\'' +
      ", city='" +
      city +
      '\'' +
      ", state='" +
      state +
      '\'' +
      ", age=" +
      age +
      '}'
    );
  }

  /**
   * @param o
   * @return int
   */
  @Override
  public int compareTo(User o) {
    return -1 * (this.getAge() - o.getAge());
  }

  /**
   * @return String
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return String
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return String
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return String
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * @return String
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return String
   */
  public String getState() {
    return state;
  }

  /**
   * @param state
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @return int
   */
  public int getAge() {
    return age;
  }

  /**
   * @param age
   */
  public void setAge(int age) {
    this.age = age;
  }
}
