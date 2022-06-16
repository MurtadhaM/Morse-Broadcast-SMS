package com.gemini.homework_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements Task.TaskListener {



  public static final String RESULT_KEY = "result";
  public static final String TASK_KEY = "task";
  static ArrayList<Task> tasks = new ArrayList<>();
  Button ViewTasks;
  Button AddTask;
  TextView Tasks_text;
  TextView task_name;
  TextView task_priority;
  TextView task_date;
  ListView task_list;
  ArrayAdapter<Task> adapter;
  Button buttonRegistration;
  Task.TaskListener mViewModel;
  ToDoListFragment mainFragment;
  private ToDoListFragment binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("To Do List");

    setContentView(R.layout.activity_main);


    mainFragment = new ToDoListFragment();
    mainFragment.setArguments(getIntent().getExtras());
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, mainFragment)
      .addToBackStack("ToDoListFragment")
      .commit();



  }
  @Override
  protected void onStart() {
    super.onStart();
    //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new ToDoListFragment()).commit();
  }





  @Override
  public void onTaskClick(Task task) {
    Intent intent = new Intent(this, DisplayTaskFragment.class);
    intent.putExtra(TASK_KEY, String.valueOf(task));
    startActivity(intent);
  }

  @Override
  public void addTask(Task task) {

  }

  @Override
  public void deleteTask(Task task) {

  }

  @Override
  public void updateTask(Task task) {

  }
  @Override
  protected void onResume() {
    super.onResume();


    if (Task.tasks.isEmpty()){

      Log.d("Error", "onResume:  ");
    }
    else {
          }
    // TESTING





  }

  @Override
  public int compareTo(Task o) {
    return 0;
  }  public Task getLowestDateTask() {

    if (tasks.size() > 1) {
      Task lowestDateTask = tasks.get(0);
      for (int i = 1; i < tasks.size(); i++) {
        if (lowestDateTask.getDateString().compareTo(tasks.get(i).getDateString()) < 0) {
          lowestDateTask = tasks.get(i);
        }
      }
      return lowestDateTask;
    } else {
      return null;
    }
  }
}




