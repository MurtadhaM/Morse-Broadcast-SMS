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
import androidx.recyclerview.widget.RecyclerView;

import com.gemini.midterm.databinding.SortFragmentViewBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SortFragment extends Fragment {

  public static ArrayList<User> users = new User().getUsers();
    boolean isAscending = true;
    private SortFragmentViewBinding binding;

  public ArrayList<User> sortByAge(ArrayList<User> users){
    if(isAscending){
      users.sort((u1, u2) ->  Integer.parseInt(u1.getAge()) - Integer.parseInt(u2.getAge()));
      this.isAscending = false;
    }else{
      users.sort((u1, u2) ->     Integer.parseInt(u2.getAge()) - Integer.parseInt(u1.getAge()));
      this.isAscending = true;
    }
    return users;
  }

  public ArrayList<User> sortByName(ArrayList<User> users){
    if(isAscending){
      users.sort((u1, u2) ->  u1.getName().compareTo(u2.getName()));
      this.isAscending = false;
    }else{
      users.sort((u1, u2) ->     u2.getName().compareTo(u1.getName()));
      this.isAscending = true;
    }
    return users;
  }


  public ArrayList<User> sortByState(ArrayList<User> users){
    if(isAscending){
      users.sort(Comparator.comparing(User::getState));

      this.isAscending = false;
    }else{
      users.sort((u1, u2) ->     u2.getState().compareTo(u1.getState()));
      this.isAscending = true;
    }
    return users;
  }
  public String getSortType(){
    if(isAscending){
      return "ASC";
    }else{
      return "DEC";
    }

  }
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
            ((RecyclerView)getView().getRootView().findViewById(R.id.list)).setAdapter(new MyUserRecyclerViewAdapter(sortByAge( users)));
            sortByAgeButton.setText("State A-Z" + " " + getSortType());
          }
      });



      sortByStateButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {


              Log.d("Sorting", "Sorting by State: ");
            ((RecyclerView)getView().getRootView().findViewById(R.id.list)).setAdapter(new MyUserRecyclerViewAdapter(sortByState( users)));
            sortByStateButton.setText("State A-Z" + " " + getSortType());


          }
      });


      sortByNameButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Log.d("Sorting", "Sorting by Name: ");
            ((RecyclerView)getView().getRootView().findViewById(R.id.list)).setAdapter(new MyUserRecyclerViewAdapter(sortByName( users)));
            sortByNameButton.setText("Name A-Z " + " " + getSortType());

          }
      });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
