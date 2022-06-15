package com.gemini.homework_3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gemini.homework_3.databinding.ActivityCreateTaskLayoutBinding;

import java.util.ArrayList;


public class CreateTaskFragment extends Fragment   {
  public       String date = "";

  public static final Object RESULT_KEY = "result";
  ActivityCreateTaskLayoutBinding binding;

  Task task;



TextView task_name;
TextView task_priority;
TextView task_date;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      binding = ActivityCreateTaskLayoutBinding.inflate(inflater, container, false);
        binding = binding.inflate(inflater, container, false);

        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    binding = ActivityCreateTaskLayoutBinding.inflate(getLayoutInflater());
      String task_name =binding.textViewTaskName.getText().toString();


      Button buttonCreateTaskSubmitButton = binding.buttonCreateTaskSubmitButton;
      buttonCreateTaskSubmitButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          String taskDate = binding.textViewDateValue.getText().toString();

          String taskName = binding.textViewTaskName.getText().toString();


          // get the task name
          // get the task priority
          int task_priority = binding.radioGroupPriority.getCheckedRadioButtonId();
          if (task_priority == R.id.radioButton_priority_high) {
            task_priority = 3;
          } else if (task_priority == R.id.radioButton_priority_medium) {
            task_priority = 2;
          } else if (task_priority == R.id.radioButton_priority_low) {
            task_priority = 1;
          }



          if (taskName.isEmpty() || taskDate.isEmpty() || task_priority <= 0) {
            Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "Task Name: " + taskName, Toast.LENGTH_SHORT).show();
          } else {
            task = new Task(taskName, task_priority, taskDate);
            Task.tasks.add(task);
            Task.selectedTask = task;
            FragmentManager fm = getActivity().getSupportFragmentManager();
            fm.popBackStack();
          }


        }
      });

      Button SelectDateButton = binding.buttonSelectDate;
      SelectDateButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//
//          FragmentManager fragmentManager = getFragmentManager();
//          fragmentManager.beginTransaction()
//                  .replace(R.id.fragmentContainerView, new CreateTaskFragment())
//                  .addToBackStack(null)
//                  .commit();

          DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
              date = dayOfMonth + "/" + (month + 1) + "/" + year;
              binding.textViewDateValue.setText(date);



            }


          }, 2020, 1, 1);

          datePickerDialog.show();



          // get the task name
          // get the task priority
          int task_priority = binding.radioGroupPriority.getCheckedRadioButtonId();
          if (task_priority == R.id.radioButton_priority_high) {
            task_priority = 3;
          } else if (task_priority == R.id.radioButton_priority_medium) {
            task_priority = 2;
          } else if (task_priority == R.id.radioButton_priority_low) {
            task_priority = 1;
          }

          // if any of the fields are empty
          if (task_name.isEmpty() || task_name.length() <= 1 || task_priority != 1 && task_priority != 2 && task_priority != 3) {
            // show a toast
            Toast.makeText(getContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();

          } else {

            // create a new task

            // add the task to the list of tasks
            Task.tasks.add(new Task(task_name, task_priority, binding.textViewDateValue.getText().toString()));

          }






        }


      });
binding.buttonCreateTaskCancelButton.setOnClickListener(new View.OnClickListener() {
  @Override
  public void onClick(View v) {
    FragmentManager fragmentManager = getFragmentManager();
    fragmentManager.popBackStack();
  }
});



    }


  public static Fragment newInstance() {
    return new CreateTaskFragment();

  }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }




  }

//

