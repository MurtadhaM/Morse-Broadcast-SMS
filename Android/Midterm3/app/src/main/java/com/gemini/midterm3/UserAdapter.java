package com.gemini.midterm3;
import static com.gemini.midterm3.R.layout.user_list_row_layout;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;



// TODO: THIS IS WHERE I WANT MY ADAPTER BASED ON A LAYOUT:

// WAIT FOR IT
class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>  {
  private ArrayList<User> users;
  private Context context;
  private ViewGroup viewGroup;
  private int viewType;


  public UserAdapter(ArrayList<User> users, Context context) {
    this.users = users;
    this.context = context;
  }

  /*
   * Provide a reference to the views for each data item.
   */
  static class UserViewHolder extends RecyclerView.ViewHolder {
    final TextView userName;
    final TextView userAge;
    final ImageView userImage;

    public UserViewHolder(@NonNull View itemView) {
      super(itemView);
      userName = itemView.findViewById(R.id.textViewusername);
      userAge = itemView.findViewById(R.id.textViewUserAge);
      userImage = itemView.findViewById(R.id.imageView_userIcon);

    }



  }



  @NonNull

  @Override
  public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(user_list_row_layout, parent, false);
    return new UserViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
    User user = users.get(position);
    holder.userName.setText(user.getName());
    holder.userAge.setText(String.valueOf(user.getAge()));
    holder.userImage.setImageResource(user.getImage());

    holder.userImage.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("UserViewHolder: onClick: userImage: " + user.getGroup());
      }
    });
  }

  @Override

  public int getItemCount() {
    return users.size();
  }


}
// BOOM!
