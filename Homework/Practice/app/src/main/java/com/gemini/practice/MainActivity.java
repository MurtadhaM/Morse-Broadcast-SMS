package com.gemini.practice;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
  final String TAG = "MainActivity";
  private RelativeLayout rootFirstFragment;
  private TextView First_Fragment_TextView;
  private SwitchMaterial First_Fragment_Switch;

  private SwitchMaterial Second_Fragment_Switch;
  UserAdapter userAdapter;
  private void init(Activity activity) {
    rootFirstFragment = activity.findViewById(R.id.root_first_fragment);
    First_Fragment_TextView = activity.findViewById(R.id.First_Fragment_TextView);
    First_Fragment_Switch = activity.findViewById(R.id.First_Fragment_Switch);
    Second_Fragment_Switch = activity.findViewById(R.id.Second_Fragment_Switch);
  }

  private Handler ProgreeHandler = new Handler();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    final String TAG = "MainActivity";
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    Button Firstbtn = findViewById(R.id.Firstbutton);
    Button Secondbtn = findViewById(R.id.Secondbutton);
    Button open_Dialog = findViewById(R.id.open_Dialog);
    FragmentTwo secondFragment = new FragmentTwo();
    FragmentOne firstFragmentOne = new FragmentOne();

    getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, firstFragmentOne).commit();
    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView2,  secondFragment ).commit();

    RecyclerView recyclerView = findViewById(R.id.recyclerView);

    userAdapter = new UserAdapter();
    userAdapter.setUsers(Arrays.asList(Data.users));
    recyclerView.setAdapter(userAdapter);
    LinearLayoutManager layoutManager;
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    Firstbtn.setOnClickListener(v -> {


      if (firstFragmentOne.getView() != null && firstFragmentOne.isEnabledSwitch()) {
        firstFragmentOne.updateColor(Color.GREEN);
        (secondFragment).updateColor(Color.RED);
      }
      Log.d(TAG, "onClick: FirstFragment Button");


    });


    Secondbtn.setOnClickListener(v -> {

        if (secondFragment.getView() != null && secondFragment.isEnabledSwitch()) {
          firstFragmentOne.updateColor(Color.RED);
          (secondFragment).updateColor(Color.GREEN);

        }

        Log.d(TAG, "onClick: SecondFragment Button");
      }
    );
    open_Dialog.setOnClickListener(v -> {

        setProgressValue(10);


      }


    );


  }

  private void setProgressValue(int progress) {
    Dialog dialog = new Dialog(MainActivity.this);
    dialog.setContentView(R.layout.dialog_fragment);
    dialog.setTitle("Dialog Fragment");
    dialog.show();


    // set the progress
    new Thread(new Runnable() {
      int i = 0;
      TextView textView = dialog.findViewById(R.id.dialog_value);

      public void run() {
        while (i < 10) {
          i += 1;
          ProgreeHandler.post(new Runnable() {
            public void run() {
              textView.setText(String.valueOf(i));

            }
          });
          try {
            // Sleep for 100 milliseconds to show the progress slowly.
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
            Log.d(TAG, "run: " + e.getMessage());
          }
        }
      }
    }).start();
  }



}


