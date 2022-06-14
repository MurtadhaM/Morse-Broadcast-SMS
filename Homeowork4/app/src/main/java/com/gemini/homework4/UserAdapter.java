package com.gemini.homework4;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAdapter extends ArrayAdapter<DataServices.User> {

  // declaring our ArrayList of items
  private final ArrayList<DataServices.User> usersArrayList;

  public UserAdapter(Context context, int textViewResourceId, ArrayList<DataServices.User> objects) {
    super(context, textViewResourceId, objects);
    this.usersArrayList = objects;
  }

  @SuppressLint("InflateParams")
  public View getView(int position, View convertView, ViewGroup parent){

    View v = convertView;

    if (v == null) {
      LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      v = inflater.inflate(R.layout.users_template_layout, null);
    }

    DataServices.User i = usersArrayList.get(position);

    if (i != null) {
      TextView Name = (TextView) v.findViewById(R.id.TextView_Name);
      TextView Age = (TextView) v.findViewById(R.id.TextView_Age);
      TextView State = (TextView) v.findViewById(R.id.Text_View_State);
      TextView Group = (TextView) v.findViewById(R.id.textView_Group);
      ImageView Icon = (ImageView) v.findViewById(R.id.imageView_User_Icon);


      if (Name != null) {
        Name.setText(i.name);
      }

      if (Age != null) {
        Age.setText(String.valueOf(i.age));
      }


      if (State != null) {
        State.setText(i.state);
      }

      if (Group != null) {
        Group.setText(i.group);
      }

      if (Icon != null) {
        if(i.gender.equals(("Male"))){
          Icon.setImageResource(R.drawable.avatar_male);
        } else {
          Icon.setImageResource(R.drawable.avatar_female);
        }

      }

      }


    

    return v;

  }

}
