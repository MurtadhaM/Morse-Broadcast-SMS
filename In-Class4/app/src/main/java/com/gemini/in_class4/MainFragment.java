/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */

package com.gemini.in_class4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainFragment extends Fragment {

  Button buttonRegistration;
  RegistrationFragment registrationFragment = new RegistrationFragment();
  private UserViewModel mViewModel;

  public static MainFragment newInstance() {
    return new MainFragment();

  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_main, container, false);
    buttonRegistration = view.findViewById(R.id.button_registration);
    buttonRegistration.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction()
          .replace(R.id.fragmentContainerView, registrationFragment)
          .commit();
      }

    });


    return view;

  }


}
