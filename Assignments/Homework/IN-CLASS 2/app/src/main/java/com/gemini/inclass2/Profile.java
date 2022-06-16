package com.gemini.inclass2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;


public class Profile extends AppCompatActivity {
  final static int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setTitle("Profile");
      setContentView(R.layout.activity_profile);
      // create the binding for the ui elements
      TextView name_text = findViewById(R.id.textView_profile_name_value);
      TextView email_text = findViewById(R.id.textView_profile_email_value);
      TextView id_text = findViewById(R.id.textView_profile_id_value);
      TextView department_text = findViewById(R.id.textView_profile_department_value);

      // Parcelable object


      Bundle bundle = getIntent().getExtras();
      if (bundle != null) {






      }


    }
}
