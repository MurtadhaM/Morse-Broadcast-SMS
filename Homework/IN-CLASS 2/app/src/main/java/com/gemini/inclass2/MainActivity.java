package com.gemini.inclass2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;


import com.gemini.inclass2.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

  // Create a Key for the Intent extra serializable object
  final static String USER_KEY = "User";
  final static int REQUEST_CODE = 100;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    ActivityMainBinding binding;

    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.buttonRegistration.setOnClickListener(v -> {
      // start the Registration activity

      FragmentManager fm = getSupportFragmentManager();
      fm.beginTransaction()
          .replace( binding.getRoot().findViewById(R.layout.activity_main).findViewById(R.id.co), MainFragment.newInstance())
          .commitNow();
    });

  }


}
