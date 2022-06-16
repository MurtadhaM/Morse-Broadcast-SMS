package com.gemini.hw1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.gemini.hw1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());


    setContentView(R.layout.activity_main);

    // Setting the buttons
    TextView InputPrice_Input = (TextView) findViewById(R.id.editText_InputPrice);
    TextView InputPrice_Output = (TextView) findViewById(R.id.DiscountPrice);
    RadioButton Radio_Button_5 = (RadioButton) findViewById(R.id.radioButton_5);
    RadioButton Radio_Button_10 = (RadioButton) findViewById(R.id.radioButton_10);
    RadioButton Radio_Button_15 = (RadioButton) findViewById(R.id.radioButton_15);
    RadioButton Radio_Button_20 = (RadioButton) findViewById(R.id.radioButton_20);
    RadioButton Radio_Button_50 = (RadioButton) findViewById(R.id.radioButton_50);
    Button Button_Calculate = (Button) findViewById(R.id.button_Calculate);
    Button Button_Clear = (Button) findViewById(R.id.button_clear);


    // Setting the onClickListener for the buttons and logic
    Button_Calculate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick (View v){
        // IT WORKS I SWEAR


        if( InputPrice_Input.getText().toString().isEmpty()) {
          Toast.makeText(MainActivity.this, "Please enter a price", Toast.LENGTH_SHORT).show();
          InputPrice_Input.setText("");

        }
       else if (Radio_Button_5.isChecked()) {
          InputPrice_Output.setText(String.valueOf(Integer.parseInt(InputPrice_Input.getText().toString() ) * 0.95));


        } else if (Radio_Button_10.isChecked()) {
          InputPrice_Output.setText(String.valueOf(Integer.parseInt(InputPrice_Input.getText().toString()) * 0.9));


        } else if (Radio_Button_15.isChecked()) {

          InputPrice_Output.setText(String.valueOf(Integer.parseInt(InputPrice_Input.getText().toString()) * 0.85));

        } else if (Radio_Button_20.isChecked()) {
          InputPrice_Output.setText(String.valueOf(Integer.parseInt(InputPrice_Input.getText().toString()) * 0.80));


        } else if (Radio_Button_50.isChecked()) {
          InputPrice_Output.setText(String.valueOf(Integer.parseInt(InputPrice_Input.getText().toString()) * 0.5));

        } else {
          Toast.makeText(MainActivity.this, "Please select a discount rate", Toast.LENGTH_SHORT).show();
        }
      }





    });

    // reset the view to default
    Button_Clear.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        InputPrice_Input.setText("");
        InputPrice_Output.setText("");
        Radio_Button_5.setChecked(false);
        Radio_Button_10.setChecked(false);
        Radio_Button_15.setChecked(false);
        Radio_Button_20.setChecked(false);
        Radio_Button_50.setChecked(false);
      }
    });
  }

}
