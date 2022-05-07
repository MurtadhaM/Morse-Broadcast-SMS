package com.gemini.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

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
