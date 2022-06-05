
/*
Author: Murtadha Marzouq & William Colvill
Assignment: HomeWork 2
Date: 10/06/2022
 */
package com.gemini.homework_3;

import java.util.Calendar;

// This is the Task class. It is used to store the data, name, priority for each task.
public class Task implements Comparable {
  // Fields
  String name;
  int priority;
  Calendar date;
String dateString;

  // Constructor
  public Task(String name, int priority, Calendar date) {
    this.name = name;
    this.priority = priority;
    this.date = date;
  }
  public Task(String name, int priority, String date) {
    this.name = name;
    this.priority = priority;
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
  public Calendar getDate() {
    return date;
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
    return  this.getDate().compareTo(((Task) o).getDate());
  }

  public interface TaskListener  extends Comparable<Task> {

    void onTaskClick(Task task);
    void addTask(Task task);
    void deleteTask(Task task);
    void updateTask(Task task);


  }
}
