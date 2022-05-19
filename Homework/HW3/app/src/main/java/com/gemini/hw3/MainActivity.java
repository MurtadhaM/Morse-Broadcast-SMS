package com.gemini.hw3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.gemini.hw3.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{
  private int passCount = 1;
  private int passLength = 8;
  private String[] results;
  Handler handler;
  ProgressDialog generatePassword;
  @Override

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Update info when either seekbar is moved
    ((SeekBar)findViewById(R.id.seekPassCount)).setOnSeekBarChangeListener(this);
    ((SeekBar)findViewById(R.id.seekPassLength)).setOnSeekBarChangeListener(this);




    generatePassword = new ProgressDialog(this);
    generatePassword.setMessage("Generating Passwords");
    generatePassword.setMax(100);
    generatePassword.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    generatePassword.setCancelable(false);


    handler= new Handler(new Handler.Callback() {




      @Override
      public boolean handleMessage(Message message) {

        Log.d("demo", "Messasge received!" + message.what); // how to get the "what" status
        Log.d("demo", "Object = " + message.obj); //how to get the object message


        switch (message.what) {
          case DoWork.STATUS_START:
            generatePassword.setMessage("Generating Passwords...");
            generatePassword.setProgress(0);
            generatePassword.show();
            break;
          case DoWork.STATUS_PROGRESS:
            generatePassword.setMessage("Generating Passwords...");
            generatePassword.setProgress((Integer) message.obj);
            // 18. How you use the bundle

            Log.d("demo", "The Password is " + message.getData().toString());
            break;
          case DoWork.STATUS_STOP:
            generatePassword.setMessage("Passwords Generated!!");
            generatePassword.dismiss();
            generatePassword.setProgress(0);
            results = message.getData().getStringArray("PROGRESS");
            for(int i = 0; i < results.length; i++)
              Log.d("demo3", "THE PASSWORDS ARE " + results[i]);

            AlertDialog.Builder passwordPicker = new AlertDialog.Builder(MainActivity.this);
            passwordPicker.setTitle("Passwords")
              .setSingleChoiceItems(results,-1, new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                  Log.d("demo", results[i] + " was pressed!");

                  ((TextView)findViewById(R.id.txtShowPass)).setText(results[i]);
                  dialogInterface.dismiss();
                }
              });

            final AlertDialog alert = passwordPicker.create();
            alert.show();


            break;
        }


        return false;
      }
    });

  }

  class DoWork implements Runnable{
    // 14 make the status int constant variables for us to use :')
    static final int STATUS_START = 0x00;
    static final int STATUS_PROGRESS = 0x01;
    static final int STATUS_STOP = 0x02;
    static final String PROGRESS_KEY = "PROGRESS"; // used for bundle

    int max, length;

    public DoWork(int max, int length) {
      this.max = max;
      this.length = length;
    }

    @Override
    public void run() {

      Log.d("demo", "Started work...........");

      Message startMessage = new Message();
      startMessage.what = STATUS_START;
      handler.sendMessage(startMessage);

      String[] passwords = new String[max];
      for(int i = 0; i < max; i ++) {
        passwords[i] = Util.getPassword(length);

        startMessage = new Message();
        startMessage.obj = ((Integer)((i+1)*100/max));

        startMessage.what = STATUS_PROGRESS;
        handler.sendMessage(startMessage);
        Log.d("demo2" , "Password is : " + passwords[i]);
      }


      startMessage = new Message();
      Bundle bundle = new Bundle();
      bundle.putStringArray(PROGRESS_KEY, passwords);
      startMessage.setData(bundle);
      startMessage.what = STATUS_STOP;
      handler.sendMessage(startMessage);
      Log.d("demo", "end work...........");
    }
  }

  public void clickMe(View view) {
    Log.d("demo", "Button Was Clicked");

    Thread thread = new Thread(new DoWork(passCount, passLength), "Worker 1");
    thread.start();

    Log.d("demo3", "I guess the passwords are in");
  }

  public void clickMe2(View view) {
    Log.d("demo", "Button2 Was Clicked");


    new MyTask().execute(99);
    Log.d("demo3", "I guess the passwords are in");
  }

  public void viewThingy(String[] a){

  }

  ///////////////////////////////////////////////////////////////////////////
  // SeekBar Stuff
  ///////////////////////////////////////////////////////////////////////////

  private void teeHeeSeek(SeekBar seekBar){

    // Separate based on which Seekbar is being used
    if(seekBar.getId() == R.id.seekPassCount){
      Log.d("test", "Pass Count Seekbar is being moved~");

      SeekBar seek = (SeekBar)findViewById(R.id.seekPassCount);
      TextView txt = (TextView)findViewById(R.id.txtShowCount);
      int min = 1;
      passCount = seek.getProgress() + min;

      txt.setText(passCount + "");
    }
    else if(seekBar.getId() == R.id.seekPassLength){
      Log.d("test", "Pass Length Seekbar is being moved~");

      SeekBar seek = (SeekBar)findViewById(R.id.seekPassLength);
      TextView txt = (TextView)findViewById(R.id.txtShowLength);
      int min = 8;
      passLength = seek.getProgress() + min;

      txt.setText(passLength + "");
    }
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    teeHeeSeek(seekBar);
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {
    teeHeeSeek(seekBar);
  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {
    teeHeeSeek(seekBar);
  }

  ///////////////////////////////////////////////////////////////////////////
  // ASYNC TASK
  ///////////////////////////////////////////////////////////////////////////
  private class MyTask extends AsyncTask<Integer, String, String>{

    ProgressDialog generatePassword;

    String[] passwords = new String[passCount];
    int cnt = 0; // current index

    @Override
    protected void onPreExecute() {
      generatePassword = new ProgressDialog(MainActivity.this);
      generatePassword.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
      generatePassword.setCancelable(false);
      cnt = 0;
      generatePassword.setMessage("Generating Passwords...");
      generatePassword.setProgress(0);
      generatePassword.show();
    }

    @Override
    protected void onPostExecute(String s) {
      generatePassword.setMessage("Passwords Generated!!");
      generatePassword.setProgress(100);
      generatePassword.dismiss();
      generatePassword.setProgress(0);


      //results = message.getData().getStringArray("PROGRESS");


      for(int i = 0; i < passwords.length; i++) {
        Log.d("demo3", "THE PASSWORDS ARE " + passwords[i]);
      }

      AlertDialog.Builder passwordPicker = new AlertDialog.Builder(MainActivity.this);
      passwordPicker.setTitle("Passwords")
        .setSingleChoiceItems(passwords,-1, new DialogInterface.OnClickListener(){
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            Log.d("demo", passwords[i] + " was pressed!");

            ((TextView)findViewById(R.id.txtShowPass)).setText(passwords[i]);
            dialogInterface.dismiss();
          }
        });

      final AlertDialog alert = passwordPicker.create();
      alert.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
      passwords[cnt] = values[0];
      cnt++;
      generatePassword.setProgress(cnt*100/passCount);
    }

    @Override
    protected String doInBackground(Integer... integers) {

      for(int i = 0; i < passCount;i++){
        publishProgress(Util.getPassword(passLength) + "");
      }
      return 100 + "";
    }
  }
}



