package com.gemini.midterm3;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String state;
    String group;
    String gender;
    int age;


    public User(String name, String state, String group, int age, String gender) {
        this.name = name;
        this.state = state;
        this.group = group;
        this.age = age;
        this.gender =gender;
    }



  @NonNull
  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", state='" + state + '\'' +
      ", group='" + group + '\'' +
      ", age=" + age +
      '}';
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

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getImage() {
      if (gender.equals("f")){
        return  R.drawable.ic_launcher_background;
    }
    else {
        return R.drawable.ic_launcher_foreground;
    }

  }
}
