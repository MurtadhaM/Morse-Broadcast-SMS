/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MyFirstLetterRecyclerViewAdapter extends RecyclerView.Adapter<MyFirstLetterRecyclerViewAdapter.ViewHolder> {

  private   ArrayList<Character> characters;

  public MyFirstLetterRecyclerViewAdapter() {
  }



  public MyFirstLetterRecyclerViewAdapter(ArrayList<Character> characters) {
    this.characters = characters;
  }



  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


    ViewHolder vh = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.first_letter_fragment_item, parent, false));

     return vh; 
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    if (holder.button_pressed.findViewById(R.id.First_Letter_Filter_button) == null) {
      // Log and dont do anything
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "button_list is null");

    } else if (position >= 0 && holder.button_pressed.findViewById(R.id.First_Letter_Filter_button) != null) {

      holder.button_pressed.setText(characters.get(position).toString());
      holder.button_pressed.setOnClickListener(new View.OnClickListener() {
        @Override

        // set the button text to the first letter of the user's name
        public void onClick(View v) {
          Toast.makeText(v.getContext(), "Filtering By Letter " + characters.get(position).toString(), Toast.LENGTH_SHORT).show();
          String letter = characters.get(position).toString();

          Log.d("Filter Letter", "onClick: " + letter);
          Filter(letter, holder);






        }
      });
    }
    else if(holder.button_pressed.findViewById(R.id.First_Letter_Filter_button) != null){
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "button_list is null");
    }

    else {
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "position is less than 0");


      holder.clear_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Toast.makeText(v.getContext(), "Clearing Filter", Toast.LENGTH_SHORT).show();
          Filter(" ", holder);
        }
      });
    }
  }
  ArrayList<User> filteredUsers;

  public void Filter(String letter, ViewHolder holder) {
    if(letter.length() >= 1) {
       filteredUsers = new ArrayList<>();
      for (User user : new User().getUsers()) {
        if (user.getName().charAt(0) == letter.charAt(0)) {
          filteredUsers.add(user);
        }
      }

    }

    else {
      ArrayList<User> filteredUsers = new User().getUsers();
    }

    // Updating the UserList
    Log.d("Filtered Users", "onClick: " + filteredUsers.size());
    MyUserRecyclerViewAdapter adapter = new MyUserRecyclerViewAdapter(filteredUsers);
    View myUserView = holder.itemView.getRootView().findViewById(R.id.list);
    RecyclerView recyclerView = myUserView.findViewById(R.id.list);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(myUserView.getContext()));
  }


  public void clearFilter(ViewHolder holder) {
    ArrayList<User> filteredUsers = new User().getUsers();
    MyUserRecyclerViewAdapter adapter = new MyUserRecyclerViewAdapter(filteredUsers);
    View myUserView = holder.itemView.getRootView().findViewById(R.id.list);
    RecyclerView recyclerView = myUserView.findViewById(R.id.list);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(myUserView.getContext()));
  }

  @Override
  public int getItemCount() {


    return characters.size();
  }


  public static class ViewHolder extends RecyclerView.ViewHolder {

    Button button_pressed;
    Button clear_button;
      View rootView;




    public ViewHolder(View inflate) {
      super(inflate);

      button_pressed = inflate.findViewById(R.id.First_Letter_Filter_button);
        rootView= inflate.getRootView();
      clear_button = inflate.findViewById(R.id.First_Letter_Filter_button);



    }


    }



  }





