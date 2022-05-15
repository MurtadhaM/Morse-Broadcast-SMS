package com.gemini.hw3;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.gemini.hw3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      binding = ActivityMainBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());


      SeekBar seekBar = binding.passwordCountSeekbar;
      SeekBar passwordLengthSeekbar = binding.passwordLengthSeekbar;
      seekBar.setProgress(1);
      TextView passwordLength = binding.passwordLength;
      TextView passwordCount = binding.passwordCount;
      passwordLength.setText("Selected Password Length: 8");
      passwordCount.setText("Selected Password Count: 1");

      passwordLengthSeekbar.setProgress(8);


      seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
          binding.passwordCount.setText("Selected Password Count:" + String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }


      });
      passwordLengthSeekbar.setMax(23 - 8);
      passwordLengthSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
          binding.passwordLength.setText("Selected Password Length:" + String.valueOf(progress + 8));




        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }


      } );

      }
    }





