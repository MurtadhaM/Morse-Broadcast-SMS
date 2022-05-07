package com.gemini.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

  }
  @Override
  protected void onStart() {
    Button myButton = (Button) findViewById(R.id.button);
     myButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Start the next activity
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        startActivity(intent);
      }
     } );
    super.onStart();


  }
  @Override
  protected void onResume() {
    super.onResume();
  } @Override
  protected void onPause() {
    super.onPause();
  }
  @Override
  protected void onStop() {
    super.onStop();
  }
  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

   /** Called when the user taps the Send button */
  public void sendMessage(View view) {
    // Do something in response to button
  }
}
