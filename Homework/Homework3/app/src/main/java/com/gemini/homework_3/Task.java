
/*
Author: Murtadha Marzouq & William Colvill
Assignment: HomeWork 2
Date: 10/06/2022
 */
package com.gemini.homework_3;

import java.util.Calendar;
import java.util.Date;

// This is the Task class. It is used to store the data, name, priority for each task.
public class Task implements Comparable {

  // This is the constructor for the Task class.
  public Task selectedTask;
  // Fields
  String name;
  String priority;
  Calendar date = Calendar.getInstance();
  String dateString;

  // Constructor
  public Task(String name, String priority, Calendar date) {
    this.name = name;
    this.priority = priority;
    this.date = date;
  }


  // setters and getters


  public Task(String name, String priority, String date) {
    this.name = name;
    this.priority = priority;
    this.dateString = date;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Task getSelectedTask() {
    return selectedTask;
  }




  public void setPriority(String priority) {
    this.priority = priority;
  }

  public Date getDate() {
    // For some reason, the date is not being set correctly.
    try {
      String day = dateString.substring(0, 2);
      String month = dateString.substring(3, 5);
      String year = dateString.substring(6, 10);
      date.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    } catch (Exception e) {
      e.printStackTrace();
    }


    return date.getTime();
  }

  public void setDate(String date) {
    this.dateString = date;
  }

  public void setDate(Calendar date) {
    this.date = date;
  }

  public String getDateString() {
    return dateString;
  }

  // toString method
  @Override
  public String toString() {
    return name;
  }


  @Override
  public int compareTo(Object o) {
    return this.getDate().compareTo(((Task) o).getDate());
  }


}
