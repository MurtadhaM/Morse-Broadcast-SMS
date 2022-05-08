package com.gemini.morser;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class DisplayMessageActivity  extends AppCompatActivity{
  String message = "";
  DisplayMessageActivity() {
    super();
  }
   DisplayMessageActivity(String message) {
     this.message = message;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_display_message);
         
}
}
