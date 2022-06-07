package com.gemini.homework_3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class ToDoListFragment extends Fragment {
  private static final String requestKey = "result";
  private static final String result = "result";
  ArrayList<Task> tasks = Task.tasks;
  Button ViewTasks;
  TextView Tasks_text;
  TextView task_name;
  TextView task_priority;
  TextView task_date;
  ListView task_list;
  ArrayAdapter<Task> adapter;
  Button buttonCreateTaskSubmitButton;
  private ToDoListFragment binding;

  public ToDoListFragment() {
    // Required empty public constructor
  }

  public static ToDoListFragment newInstance(String param1, String param2) {
    ToDoListFragment fragment = new ToDoListFragment();
    Bundle args = new Bundle();
    args.putString(requestKey, requestKey);
    args.putString(result, result);
    fragment.setArguments(args);
    return fragment;
  }

  public static Fragment newInstance() {
    return new ToDoListFragment();

  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_to_do_list, container, false);
    adapter = new ArrayAdapter<Task>(getActivity(), android.R.layout.simple_list_item_1, Task.tasks);

    Tasks_text = v.findViewById(R.id.textView_tasks_important_label);
    ViewTasks = v.findViewById(R.id.button_view_all_tasks);

    ViewTasks.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(ToDoListFragment.this.getContext());
        // dialog box to display all tasks
        builder.setTitle("Select a task");
        // create a cancel button to close the dialog box
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
          }
        });



        builder.show();

      }
    });

    buttonCreateTaskSubmitButton = v.findViewById(R.id.button_add_task);

    buttonCreateTaskSubmitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
          .replace(R.id.fragmentContainerView, new CreateTaskFragment())
          .addToBackStack("CreateTaskFragment")

          .commit();
      }

    });


    return v;

  }


  @Override
  public void onResume() {
   // To update the high priority task and the number of tasks
    task_name = getView().findViewById(R.id.textView_task_name_value);
    task_priority = getView().findViewById(R.id.textView_task_priority_value);
    task_date = getView().findViewById(R.id.textView_task_date_value);
    Tasks_text = getView().findViewById(R.id.textView_Tasks_Total_label);

    super.onResume();
    if(Task.tasks.size() == 0) {
      Tasks_text.setText("No tasks");
      task_name.setText(" ");
      task_priority.setText(" ");
      task_date.setText(" ");

    }
    else {
      Task lowest =getLowestDateTask();
      TextView labelT = getView().findViewById(R.id.textView_Tasks_Total_label);
      String numberOfTasks = "Number of " + (Task.tasks.size() ) + " tasks";
      labelT.setText(numberOfTasks);

      String NameofTask = lowest.getName()  ;
      String PriorityofTask = lowest.getPriority() ;
      String DateofTask = lowest.getDateString() ;

      task_name = getView().findViewById(R.id.textView_task_name_value);
      task_name.setText(NameofTask);
      task_priority = getView().findViewById(R.id.textView_task_priority_value);
      task_priority.setText(PriorityofTask);
      task_date = getView().findViewById(R.id.textView_task_date_value);
      task_date.setText(DateofTask);


    }

  }

    public Task getLowestDateTask () {

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
