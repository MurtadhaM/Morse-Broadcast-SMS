/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */


package com.gemini.in_class4;

import androidx.lifecycle.ViewModel;

import java.io.Serializable;
import java.util.ArrayList;

  public  class User implements Serializable {
    private String name;
    private String email;
    private String id;
    private String department;

    public User(String name, String email, String id, String department) {
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

    public String getId() {
      return id;
    }

    public void setId(String id) {
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


