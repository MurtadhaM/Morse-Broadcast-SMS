/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */

package com.gemini.in_class4;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class RegistrationFragment extends Fragment {
  Button Registration_button;
  Button Select_department_button;
  Button Cancel_button;
  TextView name_text;
  TextView email_text;
  TextView id_text;
  TextView department_text;
  String selected_department;
  RegistrationListener mListener;



  public RegistrationFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_registration, container, false);
    Registration_button = view.findViewById(R.id.button_submit_registration);
    name_text = view.findViewById(R.id.editTextTextPersonName);
    email_text = view.findViewById(R.id.editTextTextEmailAddress);
    id_text = view.findViewById(R.id.editTextNumberSigned_id);
    Select_department_button = view.findViewById(R.id.button_select_department);
    department_text = view.findViewById(R.id.textView_selected_department_text);

    if (mListener.getDepartment() != null) {
      department_text.setText(mListener.getDepartment());
    }


    Select_department_button.setOnClickListener(v -> {
      mListener.gotoDepartment();
    });






    Registration_button.setOnClickListener(v -> {


      boolean isValid = isEmailValid(email_text.getText().toString());
      if (mListener.getDepartment() != null && email_text.getText().toString().length() > 0 && name_text.getText().toString().length() > 0 && id_text.getText().toString().length() > 0  &&isValid &&department_text.getText().toString().length() > 0) {
        mListener.setUser(new User(name_text.getText().toString(), email_text.getText().toString(), id_text.getText().toString(), mListener.getDepartment()));

        mListener.gotoProfile();

      } else if(!isValid) {
        Toast.makeText(getContext(), "Please enter a valid email address", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(getContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
      }



    });


    return view;

  }

  boolean isEmailValid(String email) {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mListener = (RegistrationListener) context;

  }

  interface RegistrationListener{
    void gotoDepartment();
    void gotoProfile();
    String getDepartment();
    void setUser(User user);
  }
}
