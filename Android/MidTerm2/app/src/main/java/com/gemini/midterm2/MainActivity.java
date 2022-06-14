package com.gemini.midterm2;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.gemini.midterm2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements SortFragment.onSortFragmentListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    ArrayList<User> users = new User().getUsers();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
          setContentView(binding.getRoot());    }


  @Override
  public void onSortByName(Comparator<User> comparator) {
    Collections.sort(users, comparator);

  }
}
