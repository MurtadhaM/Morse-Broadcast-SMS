
/*
Authors: Muradha Marzouq & William Colvill
Assignment: HomeWork 3
 */
package com.gemini.homework_3;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.SimpleFormatter;

public class MainActivity extends AppCompatActivity  implements ToDoListFragment.onToDoListFragmentListener , CreateTaskFragment.onCreateTaskFragmentListener,Display_Task_Fragment.DisplayTaskFragmentListener {

  int selected_task_index = -1;

  ArrayList<Task> tasks = new ArrayList<>();
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("To Do List");
    setContentView(R.layout.activity_main);
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.Fragment_Container, new ToDoListFragment())
      .addToBackStack(null)
      .commit();
  }
  @Override
  protected void onStart() {
    super.onStart();
    Log.d("MainActivity", "onStart");

  }


  @Override
  protected void onResume() {
    super.onResume();
    Log.d("MainActivity", "onResume");
  }
// ACTION INTERFACES

  @Override
  public void onViewTasksButtonClickedListener() {
    Log.d("MainActivity", "onViewTasksButtonClickedListener");


  }

  @Override
  public void onAddTaskButtonClickedListener() {
     Log.d("MainActivity", "onAddTaskButtonClickedListener");
    Log.d("MainActivity", "onAddTaskToListListener");
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.Fragment_Container, new CreateTaskFragment())
      .addToBackStack("CreateTaskFragment")
      .commit();



  }

  @Override
  public void onUpdateTaskTextViewListener(String text) {
    Log.d("MainActivity", "onUpdateTaskTextViewListener");


  }

  @Override
  public String onGetTaskTextViewListener() {
    return "You have " + tasks.size() + " tasks";
  }

  @Override
  public void onAddTaskToListListener(Task task) {

  }

  @Override
  public void onSetSelectedTaskListener(int position) {

    Log.d("MainActivity", "onSetSelectedTaskListener");
    selected_task_index = position;
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.Fragment_Container, new Display_Task_Fragment())
      .addToBackStack("DisplayTaskFragment")
      .commit();
  }

  @Override
  public ArrayList<Task> getTaskList() {
  tasks.sort(new Comparator<Task>() {
    @Override
    public int compare(Task o1, Task o2) {
      return o1.getDate().compareTo(o2.getDate());
    }
  });
    return this.tasks;
  }


  @Override
  public Task onImportantTaskListener() {

    tasks.sort(Comparator.comparing(Task::getDate));
   if (tasks.size() > 0) {
     return tasks.get(0);
   } else {
     return null;
   }

  }

  @Override
  public void addTaskListener(Task task) {


    Log.d("MainActivity", "addTaskListener");

    tasks.add(task);
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.Fragment_Container, new ToDoListFragment())
      .addToBackStack(null)
      .commit();

  }

  @Override
  public void updateDateListener(String date) {
    Log.d("MainActivity", "updateDateListener");
    Toast.makeText(this, date, Toast.LENGTH_SHORT).show();

  }

  @Override
  public void cancelTaskListener() {

    Log.d("Main", "cancelTaskListener: ");

    // delete the fragment
    getSupportFragmentManager().popBackStack();


  }


  @Override
  public void onTaskCancled() {
    Log.d("Main", "onTaskCancled: ");
    getSupportFragmentManager().popBackStack();

  }

  @Override
  public void onTaskDeleted(Task selectedTask) {
    Log.d("Main", "onTaskDeleted: ");
    tasks.remove(selectedTask);
    getSupportFragmentManager().popBackStack();

  }

  @Override
  public Task getSelectedTask() {
    Log.d("Main", "getSelectedTask: ");
    if(selected_task_index != -1) {
      return tasks.get(selected_task_index);
    } else {
      return new Task("No Tasks", "No Tasks", "No Tasks");
    }
  }
}




