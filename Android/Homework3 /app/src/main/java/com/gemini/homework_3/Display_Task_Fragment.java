
/*
Authors: Muradha Marzouq & William Colvill
Assignment: HomeWork 3
 */
package com.gemini.homework_3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Display_Task_Fragment extends Fragment {
  Button Cancel;
  Button Delete;

  public Display_Task_Fragment() {
  }


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_display__task___layout, container, false);
    // Setting the Title of the Fragment
    if (getActivity() != null) {
      getActivity().setTitle(getString(R.string.displayTag));
    }
    // Attach UI elements to variables
    Cancel = view.findViewById(R.id.selected_task_button_cancel);
    Delete = view.findViewById(R.id.selected_task_button_delete);
    Task selectedTask = mListener.getSelectedTask();
    TextView task_name = view.findViewById(R.id.textView_task_name);
    TextView task_priority = view.findViewById(R.id.textView_task_priority);
    TextView task_date = view.findViewById(R.id.textView_task_date);
    // Set UI elements to selected task values
    task_name.setText(selectedTask.getName());
    task_priority.setText(selectedTask.priority);
    task_date.setText(selectedTask.getDateString());

    Cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // Cancel button

        mListener.onTaskCancled();

      }

    });

    Delete.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // get the selected task from the recycler view
      Task selectedTask =   mListener.getSelectedTask();
        // Delete button


        mListener.onTaskDeleted(selectedTask);

      }

    });


    return view;
  }



  DisplayTaskFragmentListener mListener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mListener = (DisplayTaskFragmentListener) context;

  }

// Creating Interfaces

  interface DisplayTaskFragmentListener {
    void onTaskCancled();
    void onTaskDeleted(Task selectedTask);
    Task getSelectedTask();

  }
}


