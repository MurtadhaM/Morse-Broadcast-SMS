/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;

import static com.gemini.midterm.R.id.First_Letter_Filter_button;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.gemini.midterm.databinding.FragmentUserBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * A fragment representing a list of Items.
 */
public class FilterFragment extends Fragment implements Button.OnClickListener {
  public static ArrayList<Character> firstCharacters;
  // Event Handlers
  ArrayList<User> users = new User().getUsers();
  //ArrayList<Character> firstCharacters = (ArrayList<Character>)  users.stream().map(User::getName).map(String::toUpperCase).map(s -> s.charAt(0)).collect(Collectors.toList());

  MyUserRecyclerViewAdapter adapter = new MyUserRecyclerViewAdapter(users);
  MyFirstLetterRecyclerViewAdapter myFirstLetterRecyclerViewAdapter = new MyFirstLetterRecyclerViewAdapter();
  UserFragment UserFragment = new UserFragment();
public interface firstCharacters{
  public void setFirstCharacters(ArrayList<Character> firstCharacters);
}


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
              UserFragment.filterByAge(ageFilterSelected,getView());
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_18_25_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_18_25_Button: ");
              ageFilterSelected = "18-25";
              UserFragment.filterByAge(ageFilterSelected,getView());
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_25_35_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_25_35_Button: ");
              ageFilterSelected = "25-35";
              UserFragment.filterByAge(ageFilterSelected,getView());
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_35_55_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_35_55_Button: ");
              ageFilterSelected = "35-55";
              UserFragment.filterByAge(ageFilterSelected,getView());
              Toast.makeText(getContext(), "Age Range: " + ageFilterSelected, Toast.LENGTH_SHORT).show();
              break;
            case R.id.filter_Clear_Age_Range_55_older_Button:
              Log.d("Button Clicked", "filter_Clear_Age_Range_55_older_Button: ");

              ageFilterSelected = "55-100";
              UserFragment.filterByAge(ageFilterSelected,getView());
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


//  public  ArrayList<User> filterByAge(String ageGroup) {
//
//    int firstAge = Integer.parseInt(ageGroup.split("-")[0]);
//    int secondAge = Integer.parseInt(ageGroup.split("-")[1]);
//
//
//    Log.d("ages", "filterByAge: " + firstAge + " " + secondAge);
//    ArrayList<User> clearFilter = new ArrayList<User>();
//
//
//    for (User user : users) {
//      if ((Integer.parseInt(user.getAge()) >= firstAge && Integer.parseInt(user.getAge()) <= secondAge)) {
//
//        clearFilter.add(user);
//      }
//    }
//
//
//
//    return clearFilter;
//
//
//  }



  public char firstLetterFilterSelected = ' ';
  public String ageFilterSelected = "";
    public FilterFragment() {

    }

    public static FilterFragment newInstance() {

        FilterFragment fragment = new FilterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



  public void ageClearFilters(ArrayList<User> ageFilteredUsers) {

    if (ageFilteredUsers.size() > 0) {
      myFirstLetterRecyclerViewAdapter = new MyFirstLetterRecyclerViewAdapter();

    }
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

              ((RecyclerView)getView().getRootView().findViewById(R.id.list)).setAdapter(new MyUserRecyclerViewAdapter(SortFragment.users));

              firstLetterFilterSelected = ' ';
            }
        });


      Filter_Clear_Age_Range_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FirstLetterFragment", "onClick: " +  Filter_Clear_Age_Range_Button.getText() + " was clicked");
              // Resetting the first letter filter
              ((RecyclerView)getView().getRootView().findViewById(R.id.list)).setAdapter(new MyUserRecyclerViewAdapter(filterByFirstLetter()));

            }
        });

        return view;
    }
public ArrayList<User> filterByFirstLetter(){

  return users;



}




}
