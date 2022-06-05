package com.gemini.homeowork2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayTask extends AppCompatActivity {
  Button Cancel;
  Button Delete;
  TextView Task_name;
  TextView Task_date;
  TextView Task_priority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_task);

        Cancel = findViewById(R.id.selected_task_button_cancel);
        Delete = findViewById(R.id.selected_task_button_delete);
        Task_name = findViewById(R.id.textView_task_name);
        Task_date = findViewById(R.id.textView_task_date);
        Task_priority = findViewById(R.id.textView_task_priority);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int position = extras.getInt("position");
            Task task = MainActivity.tasks.get(position);
            Task_name.setText(task.getName());
            Task_date.setText(task.getDateString());
            Task_priority.setText(String.valueOf(task.getPriority()));
          Toast.makeText(this, "Task Selected: " + position, Toast.LENGTH_SHORT).show();
          Log.d(String.valueOf(position), "onCreate: " + task.getName());
        } else {
          Toast.makeText(this, "No Task Selected", Toast.LENGTH_SHORT).show();

        }

        Cancel.setOnClickListener(view -> {
          setResult(RESULT_CANCELED);
            finish();
        });

        Delete.setOnClickListener(view -> {
          // Delete the task
          if (extras != null) {
           int position = extras.getInt("position");
            MainActivity.tasks.remove(position);
            setResult(RESULT_FIRST_USER);
            finish();

          }

        });

    }


      }

//


