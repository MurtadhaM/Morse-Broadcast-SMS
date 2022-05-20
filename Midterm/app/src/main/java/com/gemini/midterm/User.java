/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
  public static ArrayList<Character> users_Names_First= new ArrayList<>();
  public  HashMap<Character, String> usersFirstName = new HashMap<>();
  ArrayList<Character> characters = new ArrayList<>();

  public  ArrayList<Character> users_Names_First() {


      getUsers();
  if(users_Names_First.size()==0) {
    // get unique first letters
    for (User user : users) {
      if (!characters.contains(user.getName().charAt(0))) {
        characters.add(user.getName().charAt(0));
        System.out.println(String.valueOf(user.getName().charAt(0)));
      }
    }
  }


    return characters;
  }

    public static ArrayList<User> users = new ArrayList<User>();
    public  ArrayList<User> getUsers() {

      if(users.size() <= 0){
        users.add(new User("David", "California","22","Work","M"));
        users.add(new User("Gemini", "Texas","32","Family","F"));
        users.add(new User("Baba", "North Carolina","52","Friend","M"));
        users.add(new User("Gemini", "California","57","Family","F"));
        users.add(new User("Ali", "California","18","Work","F"));
        users.add(new User("Zmini", "California","57","Family","F"));
        users.add(new User("Hemini", "California","57","Family","F"));

      }
      return users;
    }
    User(){

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
