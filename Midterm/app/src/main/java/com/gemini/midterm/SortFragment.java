/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.gemini.midterm.databinding.SortFragmentViewBinding;

public class SortFragment extends Fragment {

    private SortFragmentViewBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = SortFragmentViewBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setting up the Buttons
      Button sortByAgeButton = binding.sortByAgeButton;
      Button sortByStateButton = binding.sortByStateButton;
      Button sortByNameButton = binding.sortByNameButton;


      // Setting up the OnClickListeners
      sortByAgeButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            Log.d("Sorting", "onClick: ");
            Toast.makeText(getContext(), "Sorting by Age", Toast.LENGTH_SHORT).show();
          }
      });


      sortByStateButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Log.d("Sorting", "Sorting by State: ");
              Toast.makeText(getContext(), "Sorting by State", Toast.LENGTH_SHORT).show();
          }
      });

      sortByNameButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Log.d("Sorting", "Sorting by Name: ");
              Toast.makeText(getContext(), "Sorting by Name", Toast.LENGTH_SHORT).show();
          }
      });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
