package com.gemini.test;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.gemini.test.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
  ArrayList<String>strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      strings = new ArrayList<>();
      strings.add("1");
      strings.add("2");

      binding = ActivityMainBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());

      ButtonArrayAdapter adapter = new ButtonArrayAdapter(strings);
      LinearLayoutManager layoutManager = new LinearLayoutManager(this);

      binding.ListNames.setLayoutParams(new LinearLayoutManager.LayoutParams(LinearLayoutManager.LayoutParams.MATCH_PARENT, LinearLayoutManager.LayoutParams.MATCH_PARENT));

      binding.ListNames.setAdapter(adapter);


    }
}
