package com.gemini.inclass5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  // Declaring the UI elements
  TextView complexityValue;
  TextView ProgressValue;
  ProgressBar Generated_progressBar;
  TextView averageValue;
  TextView seekbarValue;
  ListView ItemslistView;
  SeekBar seekBar;
  Button generateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      seekBar = findViewById(R.id.seekBar_complexity);
//    complexityValue = findViewById(R.id.seekbar_value);
      Generated_progressBar = findViewById(R.id.progressBar_total);
      ProgressValue = findViewById(R.id.textView_progressBar_total_label);
      ProgressValue.setText(String.format("%d/%d", Generated_progressBar.getProgress(), Generated_progressBar.getMax()));
      averageValue = findViewById(R.id.textView_Average_Value);
      seekbarValue = findViewById(R.id.seekbar_value);
      ItemslistView = findViewById(R.id.ItemsList);
      generateButton = findViewById(R.id.button_Generate);


      // Setting the listener for the seekbar
      seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
          seekbarValue.setText(String.format("%d", progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
          seekBar.setProgress(0);

        }

      });

    }


}
