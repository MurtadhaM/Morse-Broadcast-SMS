/*
Author: Murtadha Marzouq
Assignment: HW3
 */

package com.gemini.hw3;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
  static int REQ_CODE = 100;
  static String VALUE_KEY = "MyTestValues";
  static String PROFILE_KEY = "PROFILE";
  static int some;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.imgAvatar).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, AvatarSelection.class);

        startActivityForResult(intent, REQ_CODE);
      }
    });
    ((SeekBar) findViewById(R.id.seekMood)).setOnSeekBarChangeListener(this);

    findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        boolean image = true;
        boolean name = true;
        boolean email = true;
        int moodDraw = R.drawable.happy;
        int profPicDraw = R.drawable.select_avatar;
        profPicDraw = some;
        String n = ((TextView) findViewById(R.id.txtName)).getText().toString();
        String e = ((TextView) findViewById(R.id.txtEmail)).getText().toString();
        String d = "SIS";
        String m = ((TextView) findViewById(R.id.txtMood)).getText().toString();

        RadioGroup rg = (RadioGroup) findViewById(R.id.radGroupDept);
        if (rg.getCheckedRadioButtonId() == R.id.radSIS) {
          d = "SIS";
        } else if (rg.getCheckedRadioButtonId() == R.id.radBIO) {
          d = "BIO";
        } else {
          d = "CS";
        }

        SeekBar one = (SeekBar) findViewById(R.id.seekMood);
        int p = one.getProgress();
        if (p == 0) {
          moodDraw = R.drawable.angry;
        } else if (p == 1) {
          moodDraw = R.drawable.sad;
        } else if (p == 2) {
          moodDraw = R.drawable.happy;
        } else {
          moodDraw = R.drawable.awesome;
        }

        if (!n.trim().equals(n)) {
          name = false;
          Toast.makeText(MainActivity.this, "Please Enter a Valid Name without the leading or trailing spaces", Toast.LENGTH_SHORT).show();
        }
        if (n == null || n.length() == 0) {
          name = false;
          Toast.makeText(MainActivity.this, "Please Enter a Valid Name that is Not Null", Toast.LENGTH_SHORT).show();
        }

        if (name) {


          if (e.indexOf('@') == e.lastIndexOf('@') && e.indexOf('@') > 0) {
            if (e.indexOf('.', e.indexOf('@') + 2) > 0 && e.indexOf('.') == e.lastIndexOf('.')) {
              email = true;
            } else {
              Toast.makeText(MainActivity.this, "Please Enter a Valid Email", Toast.LENGTH_SHORT).show();
            }
          } else {
            email = false;
            Toast.makeText(MainActivity.this, "Please Enter a Valid Email", Toast.LENGTH_SHORT).show();
          }
        }


        if (name && email) {
          Intent intent = new Intent(MainActivity.this, DisplayActivity.class);

          // Create Profile
          Profile prof = new Profile(n, e, d, m, profPicDraw, moodDraw);
          intent.putExtra(PROFILE_KEY, prof);
          startActivity(intent);

        }
      }
    });


  }


  @Override
  public void onClick(View view) {
    Log.d("Demo", "SOME RANDOM BUTTON WAS CLICKED ..>!!! BUGGGIEEE");
  }

  @Override
  public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    Log.d("test", "seekbar is changing");
    SeekBar one = (SeekBar) findViewById(R.id.seekMood);
    int p = one.getProgress();

    if (p == 0) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.angry));
      ((TextView) findViewById(R.id.txtMood)).setText("Angry >:C");
      //moodDraw = getResources().getDrawable(R.drawable.angry);
    } else if (p == 1) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.sad));
      ((TextView) findViewById(R.id.txtMood)).setText("Sad :c");
      //moodDraw = getResources().getDrawable(R.drawable.sad);
    } else if (p == 2) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.happy));
      ((TextView) findViewById(R.id.txtMood)).setText("Happy :D");
      //moodDraw = getResources().getDrawable(R.drawable.happy);
    } else {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.awesome));
      ((TextView) findViewById(R.id.txtMood)).setText("Awesome :DDD");
      //moodDraw = getResources().getDrawable(R.drawable.awesome);
    }

  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQ_CODE) {
      if (resultCode == RESULT_OK) {
        int id = data.getExtras().getInt(VALUE_KEY);
        Log.d("test", "A value was received.");
        Log.d("test", "" + id);

        switch (id) {
          case R.id.imgGirl1:
            ((ImageView) findViewById(R.id.imgAvatar)).
              setImageDrawable(getResources().getDrawable(R.drawable.avatar_f_1));
            some = R.drawable.avatar_f_1;
            break;
          case R.id.imgGirl2:
            ((ImageView) findViewById(R.id.imgAvatar)).
              setImageDrawable(getResources().getDrawable(R.drawable.avatar_f_2));
            some = R.drawable.avatar_f_2;
            break;
          case R.id.imgGirl3:
            ((ImageView) findViewById(R.id.imgAvatar)).
              setImageDrawable(getResources().getDrawable(R.drawable.avatar_f_3));
            some = R.drawable.avatar_f_3;
            break;
          case R.id.imgBoy1:
            ((ImageView) findViewById(R.id.imgAvatar)).
              setImageDrawable(getResources().getDrawable(R.drawable.avatar_m_1));
            some = R.drawable.avatar_m_1;
            break;
          case R.id.imgBoy2:
            ((ImageView) findViewById(R.id.imgAvatar)).
              setImageDrawable(getResources().getDrawable(R.drawable.avatar_m_2));
            some = R.drawable.avatar_m_2;
            break;
          case R.id.imgBoy3:
            ((ImageView) findViewById(R.id.imgAvatar)).
              setImageDrawable(getResources().getDrawable(R.drawable.avatar_m_3));
            some = R.drawable.avatar_m_3;
            break;
          default:
            some = R.drawable.select_avatar;
        }

      } else if (resultCode == RESULT_CANCELED) {
        Log.d("test", "No value was received! :(");
      }
    }
  }

  @Override
  public void onStartTrackingTouch(SeekBar seekBar) {
    Log.d("test", "seekbar was clicked");
    SeekBar one = (SeekBar) findViewById(R.id.seekMood);
    int p = one.getProgress();
    if (p == 0) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.angry));
      ((TextView) findViewById(R.id.txtMood)).setText("Angry >:C");
      //moodDraw = getResources().getDrawable(R.drawable.angry);
    } else if (p == 1) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.sad));
      ((TextView) findViewById(R.id.txtMood)).setText("Sad :c");
      //moodDraw = getResources().getDrawable(R.drawable.sad);
    } else if (p == 2) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.happy));
      ((TextView) findViewById(R.id.txtMood)).setText("Happy :D");
      //moodDraw = getResources().getDrawable(R.drawable.happy);
    } else {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.awesome));
      ((TextView) findViewById(R.id.txtMood)).setText("Awesome :DDD");
      //moodDraw = getResources().getDrawable(R.drawable.awesome);
    }

  }

  @Override
  public void onStopTrackingTouch(SeekBar seekBar) {
    Log.d("test", "seekbar was stopped to touch");
    SeekBar one = (SeekBar) findViewById(R.id.seekMood);
    int p = one.getProgress();
    if (p == 0) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.angry));
      ((TextView) findViewById(R.id.txtMood)).setText("Angry >:C");

    } else if (p == 1) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.sad));
      ((TextView) findViewById(R.id.txtMood)).setText("Sad :c");

    } else if (p == 2) {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.happy));
      ((TextView) findViewById(R.id.txtMood)).setText("Happy :D");

    } else {
      ((ImageView) findViewById(R.id.imgMoodFace)).setImageDrawable(getResources().getDrawable(R.drawable.awesome));
      ((TextView) findViewById(R.id.txtMood)).setText("Awesome :DDD");

    }

  }
}
