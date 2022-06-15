
/*
Authors: Muradha Marzouq & William Colvill
Assignment: HomeWork 3
 */
package com.gemini.homework_3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Date;


public class CreateTaskFragment extends Fragment   {

TextView task_name;
TextView task_priority;
TextView task_date;
Button set_date_button;
Button create_task_button;
Button cancel_task_button;
onCreateTaskFragmentListener mListener;
String task_name_string;
String task_priority_string;
String task_date_string;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_create_task_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
        // Setting the Title of the Fragment
        if (getActivity() != null) {
            getActivity().setTitle(getString(R.string.create_tag));
        }

      set_date_button = view.findViewById(R.id.button_select_date);
      create_task_button = view.findViewById(R.id.button_create_task_Submit_button);
      cancel_task_button = view.findViewById(R.id.button_create_task_cancel_button);
      task_name = view.findViewById(R.id.textView_task_name);
      task_priority = view.findViewById(R.id.textView_task_priority_value);
      task_date = view.findViewById(R.id.textView_date_value);

        Date date = new Date();

      set_date_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                  new DatePickerDialog.OnDateSetListener() {
                      @Override
                      public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                          task_date.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                      }

                  },
                    date.getYear() + 1900, date.getMonth(), date.getDate()
            );
            datePickerDialog.getDatePicker().setMinDate(date.getTime());
          datePickerDialog.show();
        }
      });





create_task_button.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
    // get the task priority from the radio group
    RadioGroup radioGroup = view.findViewById(R.id.radioGroup_priority);
    int task_priority =   radioGroup.getCheckedRadioButtonId();
    if (task_priority == R.id.radioButton_priority_high) {
      task_priority_string = "High";
    } else if (task_priority == R.id.radioButton_priority_medium) {
      task_priority_string = "Medium";
    } else if (task_priority == R.id.radioButton_priority_low) {
      task_priority_string = "Low";
    } else {
      task_priority_string = "";
    }
// -------------------------------------------------- //

    /*
            INPUT VALIDATION
     */
    if(task_name.getText().toString().isEmpty()){
      Toast.makeText(getContext(), "Please enter a task name", Toast.LENGTH_SHORT).show();
    } else if (task_priority_string.isEmpty()) {
      Toast.makeText(getContext(), "Please select a task priority", Toast.LENGTH_SHORT).show();
    } else if (task_date.getText().toString().isEmpty()) {
      Toast.makeText(getContext(), "Please select a task date", Toast.LENGTH_SHORT).show();
    } else {
        // create a new task object
        Task task = new Task(task_name.getText().toString(), task_priority_string, task_date.getText().toString());
        mListener.addTaskListener(task);
    }


  }
});


      cancel_task_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          // close the fragment
          mListener.cancelTaskListener();
        }
      });

    }





    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mListener = (onCreateTaskFragmentListener) context;


    }
    interface onCreateTaskFragmentListener {
        void addTaskListener(Task task);
        void updateDateListener(String date);
        void cancelTaskListener();



    }

  }


//

