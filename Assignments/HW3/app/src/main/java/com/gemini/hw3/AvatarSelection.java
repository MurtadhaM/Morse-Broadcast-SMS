package com.gemini.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/*
Author: Murtadha Marzouq
Assignment: HW3
 */
import androidx.appcompat.app.AppCompatActivity;


public class AvatarSelection extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_avatar_selection);
  }

  @Override
  public void onClick(View v) {

    Intent intent = new Intent();
    intent.putExtra(MainActivity.VALUE_KEY, v.getId());
    setResult(RESULT_OK, intent);

    finish();
  }

}
