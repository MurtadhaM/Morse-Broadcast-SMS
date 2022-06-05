/*
Author: Murtadha Marzouq & William Colvill
Assignment: HomeWork 2
Date: 10/06/2022
 */
package com.gemini.homeowork2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;

public class CreateTaskActivitity extends AppCompatActivity {
TextView textView_task_name;
RadioGroup radioGroup_task_priority;
Button cancel_button;
Button submit_button;
TextView textView_date_value;
Button dateSelect_button;
  Calendar date ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task_layout);
        // set the title of the activity
        setTitle("Create Task");
        // set the ui elements
        textView_task_name = findViewById(R.id.textView_task_name);
        radioGroup_task_priority = findViewById(R.id.radioGroup_priority);
        cancel_button = findViewById(R.id.button_create_task_cancel_button);
        submit_button = findViewById(R.id.button_create_task_Submit_button);
        textView_date_value = findViewById(R.id.textView_date_value);
        dateSelect_button = findViewById(R.id.button_select_date);
        // set on click listeners

      dateSelect_button.setOnClickListener(view -> {

        //  open date picker
        DatePickerDialog datePickerDialog = new DatePickerDialog(CreateTaskActivitity.this, (datePicker, year, month, day) -> {
            // set the date
            date = Calendar.getInstance();
            date.set(year,month,day);

            // set the date in the text view
            textView_date_value.setText(day + "/" + month + "/" + year);
        }, 2022, 6, 10);

        datePickerDialog.show();
      });

        // set the on click listeners
        cancel_button.setOnClickListener(view -> {
          // return to the main activity with result code 0
            setResult(RESULT_CANCELED);
            finish();
        });

        submit_button.setOnClickListener(view -> {
          // get the task name
          String task_name = textView_task_name.getText().toString();
          // get the task priority
          int task_priority = radioGroup_task_priority.getCheckedRadioButtonId();
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
            Toast.makeText(CreateTaskActivitity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();


          } else {

          // create a new task

          // add the task to the list of tasks

          MainActivity.tasks.add(new Task(task_name, task_priority, textView_date_value.getText().toString()));
          // finish the activity with result code SUCCESS
          setResult(RESULT_OK);
          finish();
        }
        });




    }
}
