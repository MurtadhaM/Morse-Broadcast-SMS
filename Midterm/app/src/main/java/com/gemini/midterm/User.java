package com.gemini.midterm;

import java.util.ArrayList;

public class User {



    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<User> getUsers() {
      users.add(new User("Gemini", "California","22","Work","M"));
      users.add(new User("Gemini", "Texas","32","Family","F"));
      users.add(new User("Gemini", "North Carolina","52","Friend","M"));
      users.add(new User("Gemini", "California","57","Family","F"));
      users.add(new User("Gemini", "California","18","Work","F"));

      return users;
    }
    User(){
        users.add(new User("Gemini", "California","22","Work","M"));
      users.add(new User("Gemini", "Texas","32","Family","F"));
      users.add(new User("Gemini", "North Carolina","52","Friend","M"));
      users.add(new User("Gemini", "California","57","Family","F"));
      users.add(new User("Gemini", "California","18","Work","F"));

    }

    public User(String name, String state, String age, String status,String gender) {
        this.name = name;
        this.gender = gender;
        this.state = state;
        this.age = age;
        this.status = status;
    }

    public String name;
    public String state;

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String gender;



  public void setUsers(ArrayList<User> users) {
    this.users = users;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String age;
    public String status;
    public String image;



    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", age='" + age + '\'' +
                ", status='" + status + '\'' +
                ", image='" + image + '\'' +
                '}';
    }


}
