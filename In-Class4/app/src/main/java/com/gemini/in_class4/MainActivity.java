package com.gemini.in_class4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
  Button buttonRegistration;
  UserViewModel mViewModel;
  MainFragment mainFragment;
  UserViewModel.User user = UserViewModel.user;

/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (savedInstanceState == null) {

      mainFragment = new MainFragment();
      mainFragment.setArguments(getIntent().getExtras());


      getSupportFragmentManager().beginTransaction()

        .replace(R.id.fragmentContainerView, mainFragment)
        .addToBackStack("MainFragment")

        .commit();


    }
    mViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    mViewModel.addUser("Gemini", "Gemini@ad.com", 1212121212, "Department of Computer Science");
  }


  @Override
  public void onResume() {
    super.onResume();
    if (user != null) {
    }
  }
}
