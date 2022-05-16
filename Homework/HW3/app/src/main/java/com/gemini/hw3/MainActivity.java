package com.gemini.hw3;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.gemini.hw3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      ArrayList<String> passwords = new ArrayList<>();
      binding = ActivityMainBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());

      SeekBar seekBar = binding.passwordCountSeekbar;
      SeekBar passwordLengthSeekbar = binding.passwordLengthSeekbar;
      seekBar.setProgress(1);
      TextView passwordLength = binding.passwordLength;
      TextView passwordCount = binding.passwordCount;
      passwordLength.setText("Selected Password Length: 8");
      passwordCount.setText("Selected Password Count: 1");

      Button ThreadGenerateButton = binding.generatePasswordThreadButton;
      Button AsyncGenerateButton = binding.generatePasswordAsyncButton;


      ThreadGenerateButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
  // create dialog
                                                  int length =Integer.parseInt(passwordLength.getText().toString().substring( passwordLength.getText().length() - 1, passwordLength.getText().length()));
                                                  int count =Integer.parseInt(passwordCount.getText().toString().substring( passwordCount.getText().length() - 1, passwordCount.getText().length()));

                                                  System.out.println("Thread Generate Button Clicked");
                                                  System.out.println("Password length: " + length + " Password count: " + count);





                                                  count = count %2 == 0 ? count/2 : count/2 + 1;
                                                    Util util =  new Util((int)(count), length);
                                                    Util util2 =  new Util(count, length);
                                                  // Start the threads
                                                    util.start();
                                                    util2.start();



                                                  System.out.println("Thread Generate Button Clicked");

                                                  // set dialog to display generated passwords
                                                  Dialog dialog = new Dialog(MainActivity.this);
                                                  dialog.setContentView(R.layout.fragment_dialog);
                                                  dialog.setTitle("Generated Passwords");
                                                  dialog.show();
                                                  }




                                              });
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





