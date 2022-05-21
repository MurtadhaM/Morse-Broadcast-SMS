/*
  Author: Murtadha Marzouq
  Date: Summer 2022
  Description: UserFragment.java
  Assignment: Midterm

 */

package com.gemini.midterm;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class UserFragment extends Fragment {

  public static ArrayList<User> users = new User().getUsers();
    private static final String ARG_COLUMN_COUNT = "column-count";

    public UserFragment() {
    }

    public static UserFragment newInstance(int columnCount) {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new MyUserRecyclerViewAdapter(SortFragment.users));
        }
        return view;
    }


  public void clearFirstLetterFilters(){

    ArrayList<User> clearFilter = new User().getUsers();
    clearFilter.removeAll(users);
    // Updating the UserList
    Log.d("Filtered Users", "onClick: " + clearFilter.size());
    Log.d("FilterFragment", "filterByAge: " + users.size());
    new FilterFragment().ageClearFilters(clearFilter);




  }

}