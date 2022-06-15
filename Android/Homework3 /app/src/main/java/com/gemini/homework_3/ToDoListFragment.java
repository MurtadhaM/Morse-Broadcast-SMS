
/*
Authors: Muradha Marzouq & William Colvill
Assignment: HomeWork 3
 */
package com.gemini.homework_3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoListFragment extends Fragment {

  ArrayList<Task> taskList = new ArrayList<>();


  Button ViewTasks;
  Button AddTask;
  TextView Tasks_text;

  // OTHER
  TextView task_name;
  TextView task_priority;
  TextView task_date;
  ListView task_list;
  CardView task_card;
  // FANCY AND USELESS
  ArrayAdapter<Task> adapter;
  onToDoListFragmentListener mListerner;
// Important Task View
TextView textView_task_name_value;
TextView textView_task_priority_value;
TextView textView_task_date_value;
Task importantTask;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_to_do_list, container, false);
    ViewTasks = view.findViewById(R.id.button_view_all_tasks);
    AddTask = view.findViewById(R.id.button_add_task);
    Tasks_text = view.findViewById(R.id.textView_Tasks_Total_label);
    task_card = view.findViewById(R.id.cardView_important_task);
    // Setting the Title of the Fragment
    if (getActivity() != null) {
      getActivity().setTitle("To Do List");
    }
     textView_task_name_value = view.findViewById(R.id.textView_task_name_value);
     textView_task_priority_value = view.findViewById(R.id.textView_task_priority_value);
     textView_task_date_value = view.findViewById(R.id.textView_task_date_value);
      task_list = view.findViewById(R.id.ListView);
    // First Recieve the data from the MainActivity
    ArrayList<Task> tasks = mListerner.getTaskList();
    importantTask = mListerner.onImportantTaskListener();
    // Set Important Task
    if(importantTask != null) {

      task_card.setVisibility(View.VISIBLE);
      // Set Important Task
      Tasks_text.setText("You have " + tasks.size() + " tasks");
      textView_task_name_value.setText(importantTask.getName());
      textView_task_priority_value.setText(importantTask.priority);
      textView_task_date_value.setText(importantTask.getDateString());
    } else {
      task_card.setVisibility(View.GONE);
      Tasks_text.setText(R.string.NoTASKS);

    }


    ArrayAdapter<Task> adapter = new ArrayAdapter<Task>(getContext(), android.R.layout.select_dialog_item, tasks);
// ----------------------------------------------------------------------------------------------------------------------
    // View TASK BUTTON
    // ----------------------------------------------------------------------------------------------------------------------

    ViewTasks.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {


        // TALK TO THE USER AND TELL THEM WHAT THEY CAN DO
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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
            mListerner.onSetSelectedTaskListener(i);
          }
        });
        // SHOW THEM THE GOODS
        builder.show();
      }
    });


    // ----------------------------------------------------------------------------------------------------------------------
    // ADD TASK BUTTON
    // ----------------------------------------------------------------------------------------------------------------------


    // LISTEN FOR THE ADD TASK BUTTON
    AddTask.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Log.d("MainActivity", "onAddTaskToListListener");

      mListerner.onAddTaskButtonClickedListener();

      }

    });

    return view;



  }








@Override
public void onAttach(Context context) {
        super.onAttach(context);
   mListerner = (onToDoListFragmentListener) context;


    }


    interface onToDoListFragmentListener {
        void onViewTasksButtonClickedListener();
        void onAddTaskButtonClickedListener();
        void onUpdateTaskTextViewListener(String text);
        String onGetTaskTextViewListener();
        void onAddTaskToListListener(Task task);
        void onSetSelectedTaskListener(int position);
        ArrayList<Task> getTaskList();
        Task onImportantTaskListener();

    }


}
