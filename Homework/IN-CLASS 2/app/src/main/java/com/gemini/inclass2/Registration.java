package com.gemini.inclass2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Registration extends AppCompatActivity {
  final static int REQUEST_CODE = 100;


  Button Registration_button;
  Button Select_department_button;
  Button Cancel_button;
  TextView name_text;
  TextView email_text;
  TextView id_text;
  TextView department_text;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("Registration");
    setContentView(R.layout.activity_registration);



    User user = getIntent().getParcelableExtra("user");

    // create the binding for the ui elements
    Registration_button = findViewById(R.id.button_submit_registration);
    name_text = findViewById(R.id.editTextTextPersonName);
    email_text = findViewById(R.id.editTextTextEmailAddress);
    id_text = findViewById(R.id.editTextNumberSigned_id);
    Cancel_button = findViewById(R.id.button_cancel);
    Select_department_button = findViewById(R.id.button_select_department);
    // the department is passed in as an extra from the Registration activity
    department_text = findViewById(R.id.textView_selected_department_text);


    // if the select department button is clicked, start the Department activity
    Select_department_button.setOnClickListener(v -> {
      // pass the name, email, password, and department to the Department activity

      Intent intent = new Intent(Registration.this, Department.class);

      startActivityForResult(intent, REQUEST_CODE);


    });

    // if the registration button is clicked, start the Profile activity
    Registration_button.setOnClickListener(v -> {
      if (name_text.getText().toString().equals("") || email_text.getText().toString().equals("") || id_text.getText().toString().equals("")) {
        // if the name, email, or id is empty, display an error message
        name_text.setError("Name is required");
        email_text.setError("Email is required");
        id_text.setError("ID is required");
      } else if (department_text.getText().toString().equals("")) {

        // Notify the user that the department is required
        Toast.makeText(Registration.this, "Please select a department", Toast.LENGTH_SHORT).show();

      } else {
        // if the name, email, and id are not empty, start the Profile activity

        Intent intent = new Intent(Registration.this, Profile.class);

        // Pass THe Parcilable object  to the Profile activity
        user.setName(name_text.getText().toString());
        user.setEmail(email_text.getText().toString());
        user.setId(Integer.parseInt(id_text.getText().toString()));
        user.setDepartment(department_text.getText().toString());
        intent.putExtra("user", user);
        startActivity(intent);
      }
    });



  }
  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == REQUEST_CODE) {
      if (resultCode == RESULT_OK) {
        // get the department from the Department activity
        String department = data.getStringExtra("department");
        // set the department text view to the department
        department_text.setText(department);
      }
    }
  }
}
