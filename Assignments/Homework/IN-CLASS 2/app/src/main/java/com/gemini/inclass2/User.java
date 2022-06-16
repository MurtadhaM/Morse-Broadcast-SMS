package com.gemini.inclass2;


import static java.lang.System.in;

import android.os.Parcel;

import java.io.Serializable;

public class User implements Serializable {
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
 public String toString() {
   return "User{" +
           "name='" + name + '\'' +
           ", email='" + email + '\'' +
           ", id=" + id +
           ", department='" + department + '\'' +
           '}';
 }

}
