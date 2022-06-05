
/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */
package com.gemini.in_class4;

import static com.gemini.in_class4.UserViewModel.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
  public ProfileFragment() {
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
    View v = inflater.inflate(R.layout.fragment_profile, container, false);

    TextView name = v.findViewById(R.id.textView_profile_name_value);
    TextView email = v.findViewById(R.id.textView_profile_email_value);
    TextView id = v.findViewById(R.id.textView_profile_id_value);
    TextView department = v.findViewById(R.id.textView_profile_department_value);
    // set the text of the textviews to the values of the user object
    name.setText(user.getName());
    email.setText(user.getEmail());
    id.setText(String.valueOf(user.getId()));
    department.setText(user.getDepartment());


    return v;
  }
}
