/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;
import static com.gemini.midterm.R.id.First_Letter_Filter_button;
import static com.gemini.midterm.R.id.recyclerView;

import androidx.annotation.NonNull;
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
import java.util.stream.Collectors;


public class MyFirstLetterRecyclerViewAdapter extends RecyclerView.Adapter<MyFirstLetterRecyclerViewAdapter.ViewHolder> {

  private ArrayList<User> users = new User().getUsers();
  private   ArrayList<Character> characters = new User().users_Names_First();
  public MyFirstLetterRecyclerViewAdapter() {

  }








  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


    return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.first_letter_fragment_item, parent, false));
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    if (holder.button_pressed.findViewById(First_Letter_Filter_button) == null) {
      // Log and dont do anything
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "button_list is null");

    } else if (position >= 0 && holder.button_pressed.findViewById(First_Letter_Filter_button) != null) {

      holder.button_pressed.setText(characters.get(position).toString());
      holder.button_pressed.setOnClickListener(new View.OnClickListener() {
        @Override

        // set the button text to the first letter of the user's name
        public void onClick(View v) {
          Log.d("LOH", "onClick: " + holder.button_pressed.getText());
          String letter = holder.button_pressed.getText().toString();

           UserFragment.Filter(letter, holder.rootView);









        }
      });
    }
    else if(holder.button_pressed.findViewById(First_Letter_Filter_button) != null){
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "button_list is null");
    }

    else {
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "position is less than 0");


    }
  }





  @Override
  public int getItemCount() {
    return characters.size();
  }
  ViewHolder holder;



  public static class ViewHolder extends RecyclerView.ViewHolder {


    Button button_pressed;
    Button clear_button;
    View rootView;




    public ViewHolder(View inflate) {
      super(inflate);

      if (inflate.findViewById(First_Letter_Filter_button) != null) {
        rootView = inflate;
        button_pressed = inflate.findViewById(First_Letter_Filter_button);
        rootView = inflate.getRootView();
        clear_button = inflate.findViewById(First_Letter_Filter_button);
      }



    }


    }



  }





