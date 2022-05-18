/* Assignment #: 1
 * @author Murtadha Marzouq
 * @version May 30th, 2022
 */

// Creates a new user with the given information.
public class User implements Comparable<User> {
  private String firstName, lastName, email, gender, city, state;
  private int age;

  /**
   * @return int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((gender == null) ? 0 : gender.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());

    return result;
  }

  /**
   * @param o
   * @return boolean
   */
  public boolean contains(Object o) {
    User other = (User) o;
    return (
      this.firstName.equals(other.firstName) &&
      this.lastName.equals(other.lastName) &&
      this.email.equals(other.email)
    );
  }

  /**
   * @param obj
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    return this.contains(obj);
  }

  // Creates a new user.
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

  // Constructs a user from a string.
  public User(String data) {
    String[] output = data.split(",");
    this.firstName = output[0];
    this.lastName = output[1];
    this.age = Integer.parseInt(output[2]);
    this.email = output[3];
    this.gender = output[4];
    this.city = output[5];
    this.state = output[6];
  }

  // Returns a string representation of this user.
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
    if (this.isEquals(o)) {
      return this.state == o.state ? 0 : this.state.compareTo(o.state);
    }

    return -1 * (this.getAge() - o.getAge());
  }

  /**
   * @param o
   * @return boolean
   */
  public boolean isEquals(User o) {
    boolean isEqual =
      this.age == o.age &&
      this.firstName.equals(o.firstName) &&
      this.lastName.equals(o.lastName) &&
      this.email.equals(o.email) &&
      this.city.equals(o.city) &&
      this.state.equals(o.state);
    return isEqual;
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
