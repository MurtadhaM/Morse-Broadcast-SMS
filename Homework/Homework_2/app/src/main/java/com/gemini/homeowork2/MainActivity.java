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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

  // TODO:  -------PRAY FOR A MIRACLE IF IT WORKS DURING THE DEMO ------
  // THIS CODE WORKS BY THE GRACE OF GOD AND IF SOMEONE EVEN LOOKS AT IT THE WRONG WAY
  // IT BREAKS THE APP. LAST NIGHT, IT STOPPED WORKING CAUSE SOMEONE SNEEZED IN KATHMANDU
  public static ArrayList<Task> tasks = new ArrayList<>();
  // GET THEM ALL, WHO CARES ABOUT STACKS AND HEAPS, NO NULLS ALLOWED ZONE
  Button ViewTasks;
  Button AddTask;
  TextView Tasks_text;
  TextView task_name;
  TextView task_priority;
  TextView task_date;
  ListView task_list;
  // FANCY AND USELESS
  ArrayAdapter<Task> adapter;
  // BINDING EXTENSION FROM GRADLE CONFIG
  private ActivityMainBinding binding;

  @Override
  // BRACE FOR IMPACT and 1000% NULLS AS A RETURN ON INVESTMENT
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("To Do List");
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    // BOILERPLATE
    setSupportActionBar(binding.toolbar);


    // sett ui elements after binding the layout to the activity and avoiding another NULL
    ViewTasks = binding.buttonViewAllTasks;
    AddTask = binding.buttonAddTask;
    Tasks_text = binding.textViewTasksTotalLabel;
    task_list = binding.ListViewViewAllTasks;
    // FANCY AND OVERKILL FOR PRACTICE
    adapter = new ArrayAdapter<Task>(this, R.layout.list_item_task, R.id.textView_task_name, tasks);
    // set on click listeners AND DONT YOU DARE GIVE ME NULLS
    ViewTasks.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // TALK TO THE USER AND TELL THEM WHAT THEY CAN DO
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

        // create a list view to display all tasks
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "You selected " + tasks.get(i).getName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, DisplayTask.class);
            // THIS IS THE KEY TO PASSING DATA TO ANOTHER ACTIVITY AND USEFUL ABOUT ADAPTERS
            intent.putExtra("position", i);

            // WAIT AND LISTEN. AGAIN NO NULLS ALLOWED
            startActivityForResult(intent, 1);
          }
        });


        // SHOW THEM THE GOODS
        builder.show();

      }
    });
    // LISTEN FOR THE ADD TASK BUTTON
    task_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      // DONT YOU DARE GIVE ME NULLS
      public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Task task = (Task) adapterView.getItemAtPosition(i);
        // start task details activity on result
        // REDOING THIS IS A BAD IDEA BUT I NEEEEED TO AVOID NULLS ATTACK
        Intent intent = new Intent(MainActivity.this, DisplayTask.class);
        intent.putExtra("position", i);
        startActivityForResult(intent, 1);
      }
    });

    // LISTEN FOR THE ADD TASK BUTTON
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
    // update the list view with the new data
    Tasks_text.setText(new StringBuilder().append("You have ").append(String.valueOf(tasks.size())).append(" tasks").toString());

    // TESTING


    // IF THERE ARE NO TASKS, DISPLAY A MESSAGE
    if (tasks.size() > 0) {

    Collections.sort(tasks, new Comparator<Task>() {
      @Override
      public int compare(Task o1, Task o2) {
        return o1.getDateString().compareTo(o2.getDateString());
      }
    });

      Task myHighTask = tasks.get(0);

      task_name = binding.textViewTaskNameValue;
      task_priority = binding.textViewTaskPriorityValue;
      task_date = binding.textViewTaskDateValue;
      task_name.setText(myHighTask.getName());
      task_priority.setText(String.valueOf(myHighTask.getPriority()));
      task_date.setText(myHighTask.getDateString());
    } else {
      //  REALLY OVERKILL BUT I NEEED TO AVOID NULLS ATTACK
      task_name = binding.textViewTaskNameValue;
      task_name.setText("None");
      task_date = binding.textViewTaskDateValue;
      task_priority = binding.textViewTaskPriorityValue;
      task_date.setText("");
      task_priority.setText("");
    }


  }

  // THE CALLBACK METHOD FROM THE CREATE TASK ACTIVITY (NULLS ARE NOT ALLOWED)
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    // if the result is ok, update the list view
    if (requestCode == 1) {
      if (resultCode == RESULT_OK) {
        // get the task from the intent
        // TELL IT TO UPDATE THE LIST VIEW
        Task task = (Task) data.getSerializableExtra("task");
        tasks.add(task);
        adapter.notifyDataSetChanged();
      } else if (resultCode == RESULT_FIRST_USER) {

        // remove the task from the list
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
      }


    }
  }


}


