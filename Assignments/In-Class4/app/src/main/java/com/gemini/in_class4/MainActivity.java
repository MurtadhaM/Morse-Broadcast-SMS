package com.gemini.in_class4;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import java.util.Objects;

public class MainActivity extends AppCompatActivity  implements MainFragment.MainFragmentListener , RegistrationFragment.RegistrationListener,
  DepartmentFragment.DepartmentFragmentListener ,ProfileFragment.ProfileFragmentListener {
  User user;
/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new MainFragment())
      .commit();


  }


  @Override
  public void gotoRegistration() {
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new RegistrationFragment(), "RegistrationFragment")
      .addToBackStack(null)
      .commit();
  }

  @Override
  public void gotoDepartment() {
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new DepartmentFragment(), "DepartmentFragment")
      .addToBackStack("DepartmentFragment")
      .commit();
  }

  @Override
  public void gotoProfile() {
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.fragmentContainerView, new ProfileFragment(), "ProfileFragment")
      .addToBackStack("ProfileFragment")
      .commit();
  }

  @Override
  public String getDepartment() {
    if (user != null) {
      return user.getDepartment();
    }
    this.user = new User();
    return user.getDepartment();
  }

  @Override
  public void onDepartmentSelected(String department) {
    // Setting the department of the user
    user.setDepartment(department);

    // replace the fragment with the profile fragment

    // pop the back stack after the user has selected the department
    getSupportFragmentManager().popBackStack();
    Log.d("Department", "onDepartmentSelected: " + user.getDepartment());



  }

  @Override
  public void onDepartmentCancelled() {
    getSupportFragmentManager().popBackStack();
  }

  @Override
  public User getUser() {
    return user;
  }

  @Override
  public void setUser(User user) {
    this.user = user;
  }
}
