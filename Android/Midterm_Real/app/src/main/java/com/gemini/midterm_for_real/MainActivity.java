package com.gemini.midterm_for_real;

import androidx.appcompat.app.AppCompatActivity;
import com.gemini.midterm_for_real.databinding.ActivityMainBinding;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      binding = ActivityMainBinding.inflate(getLayoutInflater());

    BlankFragment blankFragment = new BlankFragment();
    getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, blankFragment).commit();

        setContentView(R.layout.activity_main);
    }
}
