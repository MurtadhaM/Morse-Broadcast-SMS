package com.gemini.in_class6;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
  // Creating the HANDLER
  Handler handler;
  ExecutorService threadPool;
  // Declaring the UI elements
  TextView ProgressValue;
  ProgressBar Generated_progressBar;
  TextView averageValue;
  TextView seekbarValue;
  ListView ItemslistView;
  TextView textView_progressBar_total_label;
  TextView textView_Average_Label;
  ArrayAdapter<Double> myadapter;
  SeekBar seekBar_complexity;
  Button generateButton;
  ArrayList<Double> numbersList = new ArrayList<>();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Assigning the UI elements
    ProgressValue = findViewById(R.id.seekbar_label);
    averageValue = findViewById(R.id.textView_Average_Value);
    seekbarValue = findViewById(R.id.seekbar_value);
    ItemslistView = findViewById(R.id.ItemsList);
    textView_Average_Label = findViewById(R.id.textView_Average_Label);
    seekBar_complexity = findViewById(R.id.seekBar_complexity);
    Generated_progressBar = findViewById(R.id.progressBar_total);
    textView_progressBar_total_label = findViewById(R.id.textView_progressBar_total_label);
    // Assigning the listeners
    generateButton = findViewById(R.id.button_Generate);
    generateButton.setOnClickListener(v -> {
      // Clearing the list
      numbersList.clear();
      // Disable the button
      generateButton.setEnabled(false);
      // Disable the seekbar
      seekBar_complexity.setEnabled(false);


      // Create am ArrayAdapter
      myadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbersList);
      // Generate the list of items
      ItemslistView.setAdapter(myadapter);
      // Show UI elements
      ProgressValue.setVisibility(View.INVISIBLE);
      averageValue.setVisibility(View.VISIBLE);
      ProgressValue.setVisibility(View.VISIBLE);
      textView_Average_Label.setVisibility(View.VISIBLE);
      seekBar_complexity.setVisibility(View.VISIBLE);
      ItemslistView.setVisibility(View.VISIBLE);
      Generated_progressBar.setVisibility(View.VISIBLE);
      ItemslistView.setVisibility(View.VISIBLE);
      textView_progressBar_total_label.setVisibility(View.VISIBLE);
      // Update the progress bar and the average value
      UpdateProgressBar();




      /* TODO:
          Step 1:Create a handler in the main thread
          Step 2:Create a worker thread that is going to do the actual work, make sure to pass the handler to the worker thread.
          Step 3:The worker thread can now do work that can take longer than 5 seconds and will not hold the main thread.
          Step 4:The worker thread will use the handler to send status messages and results to the handler.
          Step 5:The received messages will be processed by the main thread
       */

      // Step 1:Create a handler in the main thread
      handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
//          int STATUS_START = 0x00;
//          int STATUS_PROGRESS = 0x01;
//          int STATUS_FINISHED = 0x02;
//          int STATUS_ERROR = 0x03;
//

          switch (msg.what) {
            case 0x00:
              Log.d(TAG, "handleMessage: " + "Start");
              break;
            case 0x01:
              Log.d(TAG, "handleMessage: " + "Progress");
              // add the number to the list
              numbersList.add((double) msg.obj);
              // Update the progress bar
              Generated_progressBar.setProgress(numbersList.size());
              // Update the progress bar label
              textView_progressBar_total_label.setText(new StringBuilder().append(numbersList.size()).append("/").append(seekBar_complexity.getProgress()).toString());
              // Update the average value
              UpdateAverage();
              // Update the list of items
              myadapter.notifyDataSetChanged();


              break;
            case 0x02:
              Log.d(TAG, "handleMessage: " + "Finished Successfully Not Updating The List View  with " + msg.obj);
              // enable the button
              generateButton.setEnabled(true);
              // enable the seekbar
              seekBar_complexity.setEnabled(true);

              break;
            case 0x03:
              Log.d(TAG, "handleMessage: " + "Error");
              break;
            default:
              Log.d(TAG, "handleMessage: " + "Unknown");
              break;
          }
// enable the button
          return false;
        }
      });


      NumberCalculator calculator = new NumberCalculator(seekBar_complexity.getProgress(), handler);
      // Thread pool of size 2
      threadPool = Executors.newFixedThreadPool(2);
      threadPool.execute(calculator);


    });


    // Assigning the listeners
    seekBar_complexity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        seekbarValue.setText(String.valueOf(progress) + " Times");
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
      }
    });
  }

  public void UpdateProgressBar() {
    Generated_progressBar.setMax(Integer.parseInt(seekbarValue.getText().toString().split(" ")[0]));
    Generated_progressBar.setProgress(numbersList.size());
    textView_progressBar_total_label.setText(String.valueOf(numbersList.size() + "/" + seekbarValue.getText().toString().split(" ")[0]));
  }

  public void UpdateAverage() {
    double sum = 0;
    for (Double number : numbersList) {
      sum += number;
    }
    averageValue.setText(String.valueOf(sum / numbersList.size()));
  }

  class NumberCalculator implements Runnable {
    final static int STATUS_START = 0x00;
    final static int STATUS_PROGRESS = 0x01;
    final static int STATUS_FINISHED = 0x02;
    final static int STATUS_ERROR = 0x03;
    private final int complexity;
    private final Handler handler;

    public NumberCalculator(int complexity, Handler handler) {
      this.complexity = complexity;
      this.handler = handler;
    }

    @Override
    public void run() {
      // Setting the status to start
      Message message = handler.obtainMessage(STATUS_START);
      handler.sendMessage(message);
      for (int i = 0; i < complexity; i++) {
        try {
          Log.d(TAG, "run: started in Number Calculator on thread: " + Thread.currentThread().getName() + "Thread ID: " + Thread.currentThread().getId());
          // Send the status message to the handler
          message = handler.obtainMessage(STATUS_PROGRESS, HeavyWork.getNumber());
          handler.sendMessage(message);
          // Sleep
        } catch (Exception e) {

          e.printStackTrace();
          // Send error message to the handler
          message = handler.obtainMessage(STATUS_ERROR, e);
          handler.sendMessage(message);

        }
      }
      // Send the status message to the handler
      message = handler.obtainMessage(STATUS_FINISHED, HeavyWork.getNumber());
      handler.sendMessage(message);

      Log.d(TAG, "run: finished in Number Calculator on thread: " + Thread.currentThread().getName() + "Thread ID: " + Thread.currentThread().getId());
    }

  }
}




