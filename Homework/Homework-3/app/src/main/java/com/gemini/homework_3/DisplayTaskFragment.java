package com.gemini.homework_3;

import static android.app.Activity.*;

import android.app.Activity;
import android.app.AlertDialog;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.gemini.homework_3.databinding.DisplayTaskFragmentLayoutBinding;
import com.gemini.homework_3.databinding.ActivityMainBinding;
import com.gemini.homework_3.databinding.*;
public class DisplayTaskFragment extends Fragment {
  private ToDoListFragment binding;

  Button Cancel;
  Button Delete;
  TextView Task_name;
  TextView Task_date;
  TextView Task_priority;
  Button ViewTasks;
  Button AddTask;
  TextView Tasks_text;
  @Override
  public View onCreateView(
    LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState
  ) {

    View v = inflater.inflate(R.layout.display_task_fragment_layout, container, false);

    Task currentTask = Task.selectedTask;
    Cancel = v.findViewById(R.id.selected_task_button_cancel);
    Delete = v.findViewById(R.id.selected_task_button_delete);
    Task_name = v.findViewById(R.id.textView_task_name);
    Task_date = v.findViewById(R.id.textView_task_date);
    Task_priority = v.findViewById(R.id.textView_task_priority);

    Task_name.setText(currentTask.getName());
    Task_date.setText(currentTask.getDateString());
    Task_priority.setText(currentTask.getPriority());



    Cancel.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {


      FragmentManager fm = getActivity().getSupportFragmentManager();
      fm.popBackStack();
      }


    });

      Delete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
          builder.setTitle("Delete Task");
          builder.setMessage("Are you sure you want to delete this task?");
          builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(getActivity(), "Task Deleted", Toast.LENGTH_SHORT).show();
              FragmentManager fm = getActivity().getSupportFragmentManager();
              fm.popBackStack();
              Task.tasks.remove(Task.tasks.remove(Task.tasks.indexOf(Task.selectedTask)));
            }
          });
          builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(getActivity(), "Task Not Deleted", Toast.LENGTH_SHORT).show();
            }
          });
          builder.show();
        }
      });

    return v;

  }


  public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (Task.tasks.isEmpty()) {

      Log.d("Error", "onResume:  ");
    } else {
      Log.d("Error", "onResume:  ");

    }









  }
}
