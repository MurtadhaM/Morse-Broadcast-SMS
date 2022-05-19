package com.gemini.practice;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
  List<User> users  = new ArrayList<>();
  public UserAdapter() {


  }

  public void setUsers(List<String> asList) {
    for     (String str : Data.users) {
      users.add(new User(str));

    }

  }

  public static class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView user_email;
    public ImageView user_image;
    View rootView;


    public UserViewHolder(@NonNull View itemView) {


        super(itemView);
        rootView = itemView;

      name = itemView.findViewById(R.id.user_name);
      user_email = itemView.findViewById(R.id.user_email);
      user_image = itemView.findViewById(R.id.user_image);

    }
  }




  @Override
  public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.userrecyclablelayout, parent, false);
    UserViewHolder uvh = new UserViewHolder(v);


    return uvh;
  }

  @Override
  public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
    holder.name.setText(users.get(position).getFirstName());
    holder.user_email.setText(users.get(position).getEmail());
    holder.user_image.setImageResource(R.drawable.ic_launcher_background);






  }

  @Override
  public int getItemCount() {
    return users.size();
  }






}
