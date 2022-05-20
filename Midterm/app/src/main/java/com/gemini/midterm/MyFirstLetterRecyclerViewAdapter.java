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

import com.gemini.midterm.databinding.FragmentUserBinding;

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


    ViewHolder vh = new ViewHolder(FragmentUserBinding.inflate(LayoutInflater.from( parent.getContext()), parent, false));
    return vh;

  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {


  }
  @Override
  public int getItemCount() {


    return characters.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    Button button_list;

    public ViewHolder(FragmentUserBinding binding) {
      super(binding.getRoot());




    }


  }



}
