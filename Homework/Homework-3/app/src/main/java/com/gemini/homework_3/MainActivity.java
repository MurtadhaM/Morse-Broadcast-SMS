package com.gemini.homework_3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.gemini.homework_3.databinding.FragmentToDoListBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.gemini.homework_3.databinding.FragmentToDoListBinding;
import com.gemini.homework_3.databinding.ListItemTaskBinding;
import com.gemini.homework_3.databinding.DisplayTaskFragmentLayoutBinding;
import com.gemini.homework_3.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity  implements Task.TaskListener {

  private AppBarConfiguration appBarConfiguration;
  private ToDoListFragment binding;
  Button ViewTasks;
  Button AddTask;
  TextView Tasks_text;
  TextView task_name;
  TextView task_priority;
  TextView task_date;
  ListView task_list;
  ArrayAdapter<Task> adapter;
  ArrayList<Task> tasks = new ArrayList<>();
  Button buttonRegistration;

  ToDoListFragment mainFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("To Do List");
    setContentView(R.layout.activity_main);











    mainFragment = new ToDoListFragment();
    mainFragment.setArguments(getIntent().getExtras());
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, mainFragment)
      .addToBackStack("ToDoListFragment")
      .commit();






    // sett ui elements

//      FragmentManager fm = getSupportFragmentManager();
//      Fragment fragment = ToDoListFragment.newInstance();
//      fragment = new ToDoListFragment();
//      fm.beginTransaction().add(R.id.fragmentContainerView, fragment).commit();


//
//      // set on click listeners
//      ViewTasks.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//          AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//          // dialog box to display all tasks
//          builder.setTitle("Select a task");
//          // create a cancel button to close the dialog box
//          builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//              dialogInterface.dismiss();
//            }
//          });
//          builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//              dialogInterface.dismiss();
//            }
//          });
//          AlertDialog dialog = builder.create();
//          dialog.show();
//
//        }
//      });
//
//    }

    }

  @Override
  public void onTaskClick(Task task) {





  }

  @Override
  public void addTask(Task task) {
    tasks.add(task);

  }

  @Override
  public void deleteTask(Task task) {
    tasks.remove(task);

  }

  @Override
  public void updateTask(Task task) {

  }

  @Override
  public int compareTo(Task o) {
    return 0;
  }
}

