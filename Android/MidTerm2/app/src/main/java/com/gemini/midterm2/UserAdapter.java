package com.gemini.midterm2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gemini.midterm2.databinding.FragmentUserBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
  private final ArrayList<User> users;
  public ArrayList<Character> characters = new ArrayList<>();

  public UserAdapter(ArrayList<Character> characters, ArrayList<User> users) {
    this.characters = characters;
    this.users = users;
  }


  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(FragmentUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
    return  users.size();
  }
  public static class ViewHolder extends RecyclerView.ViewHolder {
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
      mButton_list = binding.getRoot().findViewById(R.id.Bullet_List);
    }




  }


}
