/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;
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

    if(holder.button_pressed.findViewById(R.id.First_Letter_Filter_button) == null) {
      // Log and dont do anything
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "button_list is null");

    }
    else {
      // Log and Update the UI
      Log.d("MyFirstLetterRecyclerViewAdapter", "onBindViewHolder: " + "button_list is not null" + holder.itemView.findViewById(R.id.First_Letter_Filter_button));
      holder.button_pressed.setText(characters.get(position).toString());
      holder.button_pressed.findViewById(R.id.First_Letter_Filter_button).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Toast.makeText(v.getContext(), "Filtering By Letter " + characters.get(position).toString(), Toast.LENGTH_SHORT).show();
        }
      });

    }

  }
  @Override
  public int getItemCount() {


    return characters.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    Button button_pressed;
    TextView textView;




    public ViewHolder(View inflate) {
      super(inflate);

      button_pressed = inflate.findViewById(R.id.First_Letter_Filter_button);

    }


    }


  }





