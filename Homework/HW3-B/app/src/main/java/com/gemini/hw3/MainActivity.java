package com.gemini.hw3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  , SeekBar.OnSeekBarChangeListener {


  private static final String TAG = "MainActivity";
  private int count = 1;
  private int length = 8;
  public String[] passwords;
  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // Setting up elements
      SeekBar LengthSeekbar = findViewById(R.id.seekPassLength);
      SeekBar CountSeekBar = findViewById(R.id.seekPassCount);
      Button Generate_Password_Thread_button = findViewById(R.id.Generate_Password_Thread_button);
      Button Generate_Password_AsyncTask_button = findViewById(R.id.Generate_Password_ASYNC_button);
    // Setting up the action Listensers for Elements
    Generate_Password_Thread_button.setOnClickListener(this);
    LengthSeekbar.setOnSeekBarChangeListener(this);
    CountSeekBar.setOnSeekBarChangeListener(this);
    Generate_Password_AsyncTask_button.setOnClickListener(this);





    }
    public void showAlert(){
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.getContext( );
      builder.setView(R.layout.dialog);
      builder.show();
      startThreads();

    }
public void startThreads(){


  Log.d(TAG, "Start Thread: ");
  for (int i = 0; i < count; i++) {


    Log.d(TAG, "Adding Progress Bar: " +  i);

  }

    Log.d(TAG, "StopThreads: ");



}
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
      Log.d(TAG, "onClick: ");
      switch (view.getId()) {
        case R.id.Generate_Password_Thread_button:
          Log.d(TAG, "onClick: Thread");
      showAlert();



          break;
        case R.id.Generate_Password_ASYNC_button:
          Log.d(TAG, "onClick: AsyncTask");
    showPasswords();
          break;
      }
    }





 public void showPasswords(){
   String[] passwords = {"asd","asd","asd","asd","asd","asd","asd","asd"};

   Log.d(TAG, "showPasswords: ");
   AlertDialog.Builder builder = new AlertDialog.Builder(this);
   builder.setTitle("Passwords");
   builder.setView(R.layout.select_password);
   builder.setItems(passwords, new DialogInterface.OnClickListener() {
     @Override
     public void onClick(DialogInterface dialogInterface, int i) {
       Log.d(TAG, "onClick: " + i);
       Log.d(TAG, "Value of Password: " + passwords[i]);


     }
   }
   );
   builder.show();
   startThreads();

  }


 



   @Override
   protected void onStart() {
     super.onStart();


   }
  @SuppressLint("NonConstantResourceId")


  @Override
  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    switch (seekBar.getId()) {
      case R.id.seekPassCount: {
        TextView textView = findViewById(R.id.Value_PassCount);
        textView.setText(String.valueOf(seekBar.getProgress()));
        count = seekBar.getProgress();
      }
      break;

    case R.id.seekPassLength: {
      TextView textView = findViewById(R.id.Value_PassLength);
      textView.setText(String.valueOf(((seekBar.getProgress() +8) ) ));
      length = seekBar.getProgress() + 8;
    }
    break;
    default:
      Log.d(TAG, "onClick: Seek Bar Wrong");


  }

  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {

  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {

  }
}





