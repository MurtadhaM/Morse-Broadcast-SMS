/*
Author: Murtadha Marzouq
Assignment: HW3
 */
package com.gemini.hw3;

import android.graphics.drawable.Drawable;

import java.io.Serializable;


public class Profile implements Serializable {
  String name;
  String email;
  String department;
  String mood;


  int imgProfile;
  int imgMood;

  public Profile(String name, String email, String department, String mood, int imgProfile, int imgMood) {
    this.name = name;
    this.email = email;
    this.department = department;
    this.mood = mood;
    this.imgProfile = imgProfile;
    this.imgMood = imgMood;
  }


}
