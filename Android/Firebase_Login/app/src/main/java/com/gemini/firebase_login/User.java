package com.gemini.firebase_login;

import java.io.Serializable;

public class User implements Serializable {
  String firstName;
  String lastName;
  String email;
  String password;
  String confirmPassword;

  String LastLogin;
String name;
  public String getName(){
    return firstName + " " + lastName;
  }


  public String getLastLogin(){
    return LastLogin;
  }
  public User(String firstName, String lastName, String email, String password, String confirmPassword) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  public User(String name,String email, String LastLogin) {
    this.name = name;
    this.email = email;
    this.LastLogin = LastLogin;
  }



  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  String phoneNumber;
}
