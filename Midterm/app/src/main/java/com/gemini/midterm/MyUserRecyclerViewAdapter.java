/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */
package com.gemini.midterm;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gemini.midterm.databinding.FragmentUserBinding;

import java.util.ArrayList;
import java.util.List;


public class MyUserRecyclerViewAdapter extends RecyclerView.Adapter<MyUserRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<User> users;
    FragmentUserBinding userBinding;
    private ArrayList<User> filteredUsers = new ArrayList<>();


    public MyUserRecyclerViewAdapter(ArrayList<User> items) {
        users = items;
        filteredUsers = items;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    public void setFilteredUsers(ArrayList<User> filteredUsers) {
        this.filteredUsers = filteredUsers;
    }
    public void updateList(ArrayList<User> users) {

    }

    public ArrayList<User> getFilteredUsers() {
        return filteredUsers;
    }

    public void removeItem(int position) {

    }

    public void addItem(User user) {
        filteredUsers.add(user);
        notifyItemInserted(users.size() - 1);
    }





    public void clearFilter() {

        filteredUsers.clear();
        filteredUsers.addAll(users);
        notifyDataSetChanged();






    }

  public void setFilter(ArrayList<User> newList) {
    users.clear();
    users.addAll(newList);

    notifyItemRangeChanged(0, users.size());
  }



    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.muser = users.get(position);
        holder.mAgeView.setText(users.get(position).age);
        holder.userId.setText(users.get(position).getName());
        holder.mStateView.setText(users.get(position).getState());
        holder.mStatusView.setText(users.get(position).getStatus());
        if(users.get(position).getGender().equals("F")) {
          holder.mImageView.setImageResource(R.drawable.img);
        }
        else {
            holder.mImageView.setImageResource(R.drawable.img1);
        }
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      public User muser;
        public final TextView userId;
        public final TextView mAgeView;
        public final TextView mStatusView;
        public final ImageView mImageView;
        public final TextView mStateView;
        public final Button mButton_list;

        public ViewHolder(FragmentUserBinding binding) {
            super(binding.getRoot());
          userId = binding.TextViewName;
            mAgeView = binding.TextViewAge;
            mStatusView = binding.textViewStatus;
            mImageView = binding.imageViewUserIcon;
            mStateView = binding.TextViewState;
            mButton_list = binding.getRoot().findViewById(R.id.my_Bullet_List);
        }




    }

    // create an interface to sort the users by name


}
