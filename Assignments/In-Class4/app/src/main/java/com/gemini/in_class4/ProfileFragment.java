
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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
  TextView name_text;
  TextView email_text;
  TextView id_text;
  TextView department_text;
  ProfileFragmentListener mListener;


  public ProfileFragment() {
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.activity_profile, container, false);

    User user = mListener.getUser();
    if (mListener != null) {

       name_text = view.findViewById(R.id.textView_profile_name_value);
        email_text = view.findViewById(R.id.textView_profile_email_value);

        id_text = view.findViewById(R.id.textView_profile_id_value);
        department_text = view.findViewById(R.id.textView_profile_department_value);
      name_text.setText(user.getName());
      email_text.setText(user.getEmail());
      id_text.setText(user.getId());
      department_text.setText(user.getDepartment());

    } else {
      Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();
    }


    return view;
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mListener = (ProfileFragmentListener) context;
  }

  interface ProfileFragmentListener {
    User getUser();
  }
}
