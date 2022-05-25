package com.gemini.midterm2;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.gemini.midterm2.databinding.ActivityMainBinding;
import com.gemini.midterm2.databinding.FragmentUserBinding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.zip.Inflater;

public class UserFragment extends Fragment {

  public static ArrayList<User> users = new User().getUsers();
  ArrayList<Character> characters = (ArrayList<Character>)  users.stream().map(User::getName).map(String::toUpperCase).map(s -> s.charAt(0)).collect(Collectors.toList());
  private UserAdapter userAdapter;
  boolean isAscending = true;


  public ArrayList<User> sortByAge(ArrayList<User> users){
    if(isAscending){
      users.sort((u1, u2) ->  Integer.parseInt(u1.getAge()) - Integer.parseInt(u2.getAge()));
      this.isAscending = false;
    }else{
      users.sort((u1, u2) ->     Integer.parseInt(u2.getAge()) - Integer.parseInt(u1.getAge()));
      this.isAscending = true;
    }
    return users;
  }

  public ArrayList<User> sortByName(ArrayList<User> users){
    if(isAscending){
      users.sort((u1, u2) ->  u1.getName().compareTo(u2.getName()));
      this.isAscending = false;
    }else{
      users.sort((u1, u2) ->     u2.getName().compareTo(u1.getName()));
      this.isAscending = true;
    }
    return users;
  }

  public ArrayList<User> sortByState(ArrayList<User> users){
    if(isAscending){
      users.sort(Comparator.comparing(User::getState));

      this.isAscending = false;
    }else{
      users.sort((u1, u2) ->     u2.getState().compareTo(u1.getState()));
      this.isAscending = true;
    }
    return users;
  }
  public String getSortType(){
    if(isAscending){
      return "ASC";
    }else{
      return "DEC";
    }

  }


  public static UserFragment newInstance(int columnCount) {
    UserFragment fragment = new UserFragment();
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_user_list, container, false);
    View viewButtons = inflater.inflate(R.layout.filter_fragment_item, container, false);


    // Set the adapter
    if (view instanceof RecyclerView) {
      Context context = view.getContext();
      RecyclerView recyclerView = (RecyclerView) view;
      userAdapter = new UserAdapter(characters,users);

      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      recyclerView.setAdapter(userAdapter);

    }
    return view;
  }







    }






