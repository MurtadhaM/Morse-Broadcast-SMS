/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A fragment representing a list of Items.
 */
public class FirstLetterFragment extends Fragment implements Button.OnClickListener {

  // Event Handlers
  ArrayList<User> users = new User().getUsers();
  @Override
  public void onClick(View v) {
    Button btn = (Button) v;

    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Button btn = (Button) v;
        int id = btn.getId();
        if (id != 0) {

          switch (id) {
            case R.id.filter_Clear_Age_Range_0_18_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_0_18_Button: ");
              ageFilterSelected = "0-18";
              filterByAge(ageFilterSelected);

              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_18_25_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_18_25_Button: ");
              ageFilterSelected = "18-25";
              filterByAge(ageFilterSelected);

              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_25_35_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_25_35_Button: ");
              ageFilterSelected = "25-35";
              filterByAge(ageFilterSelected);

              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_35_55_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_35_55_Button: ");
              ageFilterSelected = "35-55";
              filterByAge(ageFilterSelected);

              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_55_older_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_55_older_Button: ");
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();

              ageFilterSelected = "55-100";
              filterByAge(ageFilterSelected);

              break;

            default:
              Log.d("Button Clicked", "Invalid Button: ");
              break;
          }
        } else {
          Log.d("Button Clicked", "Invalid Button: ");
        }
      }
    });
  }


  MyFirstLetterRecyclerViewAdapter myFirstLetterRecyclerViewAdapter = new MyFirstLetterRecyclerViewAdapter(new User().users_Names_First());
ArrayList<User> filteredUsers = new ArrayList<>();
ArrayList<User> firstFilteredUsers = new ArrayList<>();
ArrayList<User> ageFilteredUsers = new ArrayList<>();


  public ArrayList<Character> users_Names_First;
  public char firstLetterFilterSelected = ' ';
  public String ageFilterSelected = "";
    public FirstLetterFragment() {

    }

    public static FirstLetterFragment newInstance() {

        FirstLetterFragment fragment = new FirstLetterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

public void clearFirstLetterFilters(){


      ArrayList<User> clearFilter = new User().getUsers();
      clearFilter.removeAll(ageFilteredUsers);
  // Updating the UserList
  Log.d("Filtered Users", "onClick: " + filteredUsers.size());
  MyUserRecyclerViewAdapter adapter = new MyUserRecyclerViewAdapter(clearFilter);
  View myUserView = getView().getRootView().findViewById(R.id.list);
  RecyclerView recyclerView = myUserView.findViewById(R.id.list);
  recyclerView.setAdapter(adapter);
  recyclerView.setLayoutManager(new LinearLayoutManager(myUserView.getContext()));



}

  public void ageClearFilters(ArrayList<User> ageFilteredUsers){

    ArrayList<User> ageFiltered = filteredUsers;
    ageFiltered.addAll(ageFilteredUsers);



    MyUserRecyclerViewAdapter adapter = new MyUserRecyclerViewAdapter(ageFiltered);
    View myUserView = getView().getRootView().findViewById(R.id.list);
    RecyclerView recyclerView = myUserView.findViewById(R.id.list);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(myUserView.getContext()));



  }

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.first_letter_fragment_layout, container, false);

      // Set the adapter
        if (view.findViewById(R.id.First_Letter_Recycler_View) instanceof RecyclerView) {
            Context context = getContext();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.First_Letter_Recycler_View);

          LinearLayoutManager layoutManager
            = new LinearLayoutManager(requireContext(),   LinearLayoutManager.HORIZONTAL , false);

              recyclerView.setAdapter(myFirstLetterRecyclerViewAdapter);

              recyclerView.setLayoutManager( layoutManager);
        }


        // Setting up the buttons
      Button clearButtonFirst = (Button) view.findViewById(R.id.Filter_Clear_First_Letter_Clear_Button);
      Button Filter_Clear_Age_Range_Button = (Button) view.findViewById(R.id.Filter_Clear_Age_Range_Button);
      Button filter_Clear_Age_Range_0_18_Button = (Button) view.findViewById(R.id.filter_Clear_Age_Range_0_18_Button);
      Button filter_Clear_Age_Range_18_25_Button = (Button) view.findViewById(R.id.filter_Clear_Age_Range_18_25_Button);
      Button filter_Clear_Age_Range_25_35_Button = (Button) view.findViewById(R.id.filter_Clear_Age_Range_25_35_Button);
      Button filter_Clear_Age_Range_35_45_Button = (Button) view.findViewById(R.id.filter_Clear_Age_Range_35_55_Button);
      Button filter_Clear_Age_Range_55_older_Button = (Button) view.findViewById(R.id.filter_Clear_Age_Range_55_older_Button);

      // Setting up the listeners
      onClick(filter_Clear_Age_Range_0_18_Button);
      onClick(filter_Clear_Age_Range_18_25_Button);
      onClick(filter_Clear_Age_Range_25_35_Button);
      onClick(filter_Clear_Age_Range_35_45_Button);
      onClick(filter_Clear_Age_Range_55_older_Button);


      clearButtonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FirstLetterFragment", "onClick: " +  clearButtonFirst.getText() + " was clicked");
                Toast.makeText(getContext(), "1st Clear Button was clicked", Toast.LENGTH_SHORT).show();
              clearFirstLetterFilters();

              // Resetting the first letter filter
              firstLetterFilterSelected = ' ';
            }
        });


      Filter_Clear_Age_Range_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FirstLetterFragment", "onClick: " +  Filter_Clear_Age_Range_Button.getText() + " was clicked");
                Toast.makeText(getContext(), "2nd Clear Button was clicked", Toast.LENGTH_SHORT).show();
              // Resetting the first letter filter
              ageClearFilters(users);            }
        });

        return view;
    }

    public void filterByAge(String ageGroup){

      int firstAge =Integer.parseInt(ageGroup.split("-")[0]);
      int secondAge = Integer.parseInt(ageGroup.split("-")[1]);

      Log.d("ages", "filterByAge: " + firstAge + " " + secondAge);
      ArrayList<User> clearFilter = new ArrayList<>();


      for(User user : users){
        if((Integer.parseInt(user.getAge() ) >= firstAge && Integer.parseInt(user.getAge()) <= secondAge)){
          clearFilter.add(user);
        }
      }


      MyUserRecyclerViewAdapter adapter = new MyUserRecyclerViewAdapter(clearFilter);
      View myUserView = getView().getRootView().findViewById(R.id.list);
      RecyclerView recyclerView = myUserView.findViewById(R.id.list);
      recyclerView.setAdapter(adapter);
      recyclerView.setLayoutManager(new LinearLayoutManager(myUserView.getContext()));


    }



}
