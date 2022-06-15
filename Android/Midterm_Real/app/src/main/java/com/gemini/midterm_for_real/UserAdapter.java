package com.gemini.midterm_for_real;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<DataServices.User> users;

    public UserAdapter(ArrayList<DataServices.User> users) {
        this.users = users;
    }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
    View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.users_template_layout, viewGroup, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

      holder.mTextviewName.setText(users.get(position).name);
      holder.mTextviewAge.setText(String.valueOf(users.get(position).age));
      holder.mTextviewGroup.setText(users.get(position).group);
      holder.mTextViewState.setText(users.get(position).state);
      if(users.get(position).gender.equals("Female")){
        holder.mImageviewUserIcon.setImageResource(R.drawable.ic_launcher_background);

      } else{
        holder.mImageviewUserIcon.setImageResource(R.drawable.ic_launcher_foreground);

      }

  }

  public int getItemCount() {
    return users.size();
  }


  static class ViewHolder extends RecyclerView.ViewHolder {
    TextView mText1;
    TextView mTextviewName;
    TextView mTextViewState;
    TextView mTextviewAge;
    TextView mTextviewGroup;
    ImageView mImageviewUserIcon;

    public ViewHolder(View itemView) {
      super(itemView);
      this.mText1 = itemView.findViewById(android.R.id.text1);
      this.mTextviewName = itemView.findViewById(R.id.TextView_Name);
      this.mTextViewState = itemView.findViewById(R.id.Text_View_State);
      this.mTextviewAge = itemView.findViewById(R.id.TextView_Age);
      this.mTextviewGroup = itemView.findViewById(R.id.textView_Group);
      this.mImageviewUserIcon = itemView.findViewById(R.id.imageView_User_Icon);
    }
  }
}
