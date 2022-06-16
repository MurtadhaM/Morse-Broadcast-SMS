/*
Author: Murtadha Marzouq & William Colvill
Assignment: HomeWork 2
Date: 10/06/2022
 */
package com.gemini.homeowork2;

import android.icu.text.AlphabeticIndex;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.SimpleFormatter;

// This is the Task class. It is used to store the data, name, priority for each task.
public class Task  implements   Serializable {
  // Fields
  String name;
  int priority;
  Date date;
String dateString;

  // Constructor FOR DAYS
  public Task(String name, int priority, Date date) {
    this.name = name;
    this.priority = priority;
    this.date = date;
    this.dateString = date.toString();

  }
  public Task(String name, int priority, String date) {
    this.name = name;
    this.priority = priority;
    SimpleFormatter formatter = new SimpleFormatter();
    this.dateString = date;
  }


  // setters and getters


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPriority() {
// HANDLE PRIORITY HERE
    if (priority == 3) {
      return "High";
    } else if (priority == 2) {
      return "Medium";
    } else {
      return "Low";
    }
  }
  public void setPriority(int priority) {
    this.priority = priority;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }
  public String getDateString() {
    return dateString;
  }

  // toString method
  @NonNull
  @Override
  public String toString() {
    return name;
  }



  }

