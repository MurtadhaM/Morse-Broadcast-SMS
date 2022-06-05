/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */

package com.gemini.in_class4;

import static android.content.ContentValues.TAG;
import static com.gemini.in_class4.UserViewModel.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationFragment extends Fragment {
  Button Registration_button;
  Button Select_department_button;
  Button Cancel_button;
  TextView name_text;
  TextView email_text;
  TextView id_text;
  TextView department_text;
  ProfileFragment profileFragment = new ProfileFragment();

  public RegistrationFragment() {
  }

  static DepartmentFragment departmentFragment = new DepartmentFragment();

  public static RegistrationFragment newInstance() {
    RegistrationFragment fragment = new RegistrationFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {


    }

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_registration, container, false);
    FragmentManager fm = getFragmentManager();
    // create the binding for the ui elements
    Registration_button = view.findViewById(R.id.button_submit_registration);
    name_text = view.findViewById(R.id.editTextTextPersonName);
    email_text = view.findViewById(R.id.editTextTextEmailAddress);
    id_text = view.findViewById(R.id.editTextNumberSigned_id);
    Cancel_button = view.findViewById(R.id.button_cancel);
    Select_department_button = view.findViewById(R.id.button_select_department);
    // the department is passed in as an extra from the Registration activity
    department_text = view.findViewById(R.id.textView_selected_department_text);
    Select_department_button.setOnClickListener(v -> {
      // pass the name, email, password, and department to the Department activity
      fm.beginTransaction()
        .replace(R.id.fragmentContainerView, departmentFragment)
        .addToBackStack("DepartmentFragment")
        .commit();


    });


    // Safty net
    if (user.getDepartment() != null && user.getDepartment().length() > 1) {
      department_text.setText(user.getDepartment());
    }

    Registration_button.setOnClickListener(v -> {
      // if the registration button is clicked, start the Profile activity
      if (name_text.getText().toString().length() > 1 && email_text.getText().toString().length() > 1 && id_text.getText().toString().length() > 1 && isEmailValid(email_text.getText().toString())) {
        user.setName(name_text.getText().toString());
        user.setEmail(email_text.getText().toString());
        user.setId(Integer.parseInt(id_text.getText().toString()));
        user.setDepartment(department_text.getText().toString());


        fm.beginTransaction()

          .replace(R.id.fragmentContainerView, profileFragment)
          .addToBackStack("ProfileFragment")
          .commit();


      } else if (!isEmailValid(email_text.getText().toString())) {
        Toast.makeText(getContext(), "Please enter a valid email address", Toast.LENGTH_SHORT).show();
      } else {
        Toast.makeText(getActivity(), "Please fill out all fields", Toast.LENGTH_SHORT).show();


      }

    });


    return view;

  }

  boolean isEmailValid(String email) {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
  }
}
