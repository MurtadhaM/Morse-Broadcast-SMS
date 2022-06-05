/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */


package com.gemini.in_class4;

import androidx.lifecycle.ViewModel;

import java.io.Serializable;
import java.util.ArrayList;

public class UserViewModel extends ViewModel {

  public static User user = new User();

  ArrayList<User> users = new ArrayList<>();


  //remove user from users arraylist
  public void removeUser(User user) {
    users.remove(user);
  }

  // get count of users
  public int getCount() {
    return users.size();
  }

  // get user at index
  public User getUser(int index) {
    return users.get(index);
  }

  public void addUser(User user) {
    this.users.add(user);
  }

  public void addUser(String name, String email, int id, String department) {
    User user = new User(name, email, id, department);
    this.users.add(user);
  }


  public static class User implements Serializable {
    private String name;
    private String email;
    private int id;
    private String department;

    public User(String name, String email, int id, String department) {
      this.name = name;
      this.email = email;
      this.id = id;
      this.department = department;
    }

    public User() {
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getDepartment() {
      return department;
    }

    public void setDepartment(String department) {
      this.department = department;
    }

    @Override
    public String toString() {
      return "User{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", id=" + id +
        ", department='" + department + '\'' +
        '}';
    }
  }

}
