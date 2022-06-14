package com.example.practice2;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;



import com.example.practice2.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserFragment.OnFragmentInteractionListener {
    ActivityMainBinding binding;
ArrayList<DataServices.User> users = DataServices.getAllUsers();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Adding The User Fragment to the Container
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new UserFragment())
                .addToBackStack(null)
                .commit();
    }

  @Override
  public ArrayList<DataServices.User> onFragmentInteraction() {
    return users;
  }
}
