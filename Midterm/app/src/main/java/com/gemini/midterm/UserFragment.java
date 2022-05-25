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

import com.gemini.midterm.databinding.FragmentUserBinding;
import com.gemini.midterm.databinding.FragmentUserListBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.zip.Inflater;


public class UserFragment extends Fragment  implements FilterFragment.firstCharacters {

  public static ArrayList<User> users = new User().getUsers();
  private final ArrayList<Character> characters =  (ArrayList<Character>)  users.stream().map(User::getName).map(String::toUpperCase).map(s -> s.charAt(0)).collect(Collectors.toList());
  private FragmentUserListBinding userListbinding;
  private FragmentUserBinding userBinding;
  Button First_Letter_Filter_button;
  Button Age_Filter_button;
  Button clear_age_button;

    public UserFragment() {


    }

    public static UserFragment newInstance(int columnCount) {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new MyUserRecyclerViewAdapter(SortFragment.users));
        }

        return view;
    }
    public static String selectedLetter = "";
    public static String selectedAge = "";

  public static ArrayList<User> filterByAge(String ageGroup,View view) {

    ArrayList<User> clearFilter = new ArrayList<>();




    int firstAge =Integer.parseInt(ageGroup.split("-")[0]);
    int secondAge = Integer.parseInt(ageGroup.split("-")[1]);



    Log.d("ages", "filterByAge: " + firstAge + " " + secondAge);



    for(User user : users) {
      if ((Integer.parseInt(user.getAge()) >= firstAge && Integer.parseInt(user.getAge()) <= secondAge)) {

        clearFilter.add(user);
      }
    }



    UpdateUsers(clearFilter,view);
    selectedAge = ageGroup;

    // Set the adapter

      return clearFilter;




  }
  public static ArrayList<User> updatedUsers = new ArrayList<User>();

  public static ArrayList<User> UpdateUsers(ArrayList<User> usersNew, View view) {

    ((RecyclerView) view.getRootView().findViewById(R.id.list)).setAdapter(new MyUserRecyclerViewAdapter(usersNew));

   return updatedUsers;

  }

  public  static ArrayList<User> Filter(String letter, View view) {

    ArrayList<User> filteredUsers = new ArrayList<>();
    if (letter.length() >= 1) {
      for (User user : users) {
        if (user.getName().toUpperCase().charAt(0) == letter.toUpperCase().charAt(0)) {
          filteredUsers.add(user);
        }
      }

    }

    UpdateUsers(filteredUsers,view);
    selectedLetter = letter;
    return filteredUsers;

    }

  @Override
  public void setFirstCharacters(ArrayList<Character> firstCharacters) {

    // Updating the UserList
    FilterFragment.firstCharacters = this.characters;

  }
}
