/*
Author: Murtadha Marzouq & William Colvill
Assignment: HomeWork 2
Date: 10/06/2022
 */
package com.gemini.homeowork2;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import com.gemini.homeowork2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;

  Button ViewTasks;
  Button AddTask;
  TextView Tasks_text;
  TextView task_name;
  TextView task_priority;
  TextView task_date;

  public static ArrayList<Task> tasks = new ArrayList<>();


  ListView task_list;
  ArrayAdapter<Task> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("To Do List");
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.toolbar);


    // sett ui elements
    ViewTasks = binding.buttonViewAllTasks;
    AddTask = binding.buttonAddTask;
    Tasks_text = binding.textViewTasksTotalLabel;
    task_list = binding.ListViewViewAllTasks;
    adapter = new ArrayAdapter<Task>(this, R.layout.list_item_task, R.id.textView_task_name, tasks);

    // set on click listeners
    ViewTasks.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // dialog box to display all tasks
        builder.setTitle("Select a task");
        // create a cancel button to close the dialog box
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
          }
        });

        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "You selected " + tasks.get(i).getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, DisplayTask.class);
            intent.putExtra("position", i);

            startActivityForResult(intent, 1);
          }
        });


        builder.show();

      }
    });
    task_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Task task = (Task) adapterView.getItemAtPosition(i);
        // start task details activity on result
        Intent intent = new Intent(MainActivity.this, DisplayTask.class);
        intent.putExtra("position", i);
        startActivityForResult(intent, 1);
      }
    });

    AddTask.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, CreateTaskActivitity.class);
        // start the activity and wait for result (startActivityForResult)
        startActivityForResult(intent, 1);
      }

    });


  }


  @Override
  protected void onResume() {
    super.onResume();
    Tasks_text.setText(new StringBuilder().append("You have ").append(String.valueOf(tasks.size())).append(" tasks").toString());

    // TESTING


    if (tasks.size() > 0) {
      Task myHighTask = getLowestDateTask();

      task_name = binding.textViewTaskNameValue;
      task_priority = binding.textViewTaskPriorityValue;
      task_date = binding.textViewTaskDateValue;
      task_name.setText(myHighTask.getName());
      task_priority.setText(String.valueOf(myHighTask.getPriority()));
      task_date.setText(myHighTask.getDateString());
    } else {
      task_name = binding.textViewTaskNameValue;
      task_name.setText("None");
      task_date = binding.textViewTaskDateValue;
      task_priority = binding.textViewTaskPriorityValue;
      task_date.setText("");
      task_priority.setText("");
    }


  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1) {
      if (resultCode == RESULT_OK) {
        // get the task from the intent
        adapter.notifyDataSetChanged();
      } else if (resultCode == RESULT_FIRST_USER) {


        // remove the task from the list
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
      }


    }
  }

  public Task getLowestDateTask() {

    if (tasks.size() > 0) {
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


