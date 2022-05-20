/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;

import android.content.Context;
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
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_18_25_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_18_25_Button: ");
              ageFilterSelected = "18-25";
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_25_35_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_25_35_Button: ");
              ageFilterSelected = "25-35";
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_35_55_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_35_55_Button: ");
              ageFilterSelected = "35-55";
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_55_older_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_55_older_Button: ");
              ageFilterSelected = "55-older";
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
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

              recyclerView.setAdapter(new MyFirstLetterRecyclerViewAdapter(new User().users_Names_First()));

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
              firstLetterFilterSelected = ' ';
            }
        });

        return view;
    }





}
