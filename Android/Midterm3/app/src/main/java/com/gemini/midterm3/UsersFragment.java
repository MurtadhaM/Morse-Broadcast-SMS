package com.gemini.midterm3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gemini.midterm3.databinding.*;

import java.util.ArrayList;

public class UsersFragment extends Fragment {
    RecyclerView RecyclerViewUserAdapter;
    ListView usersListView;
    UserAdapter usersAdapter;
    ArrayList<User> users;
    private @NonNull FragmentUsersBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentUsersBinding.inflate(inflater, container, false);









        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      users = mListener.onGetUsersArrauList();
      System.out.println("UsersFragment: onViewCreated: users: " + users.size());

      users = mListener.onGetUsersArrauList();
      // Create an ArrayAdapter for the ListView
      usersAdapter = new UserAdapter(users,getContext());
      RecyclerView userRecyclerView = view.findViewById(R.id.ListViewUsersList);
      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
      layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
      userRecyclerView.setLayoutManager(layoutManager);
      userRecyclerView.setAdapter(usersAdapter);
      // Set the adapter on the ListView









    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

  OnListFragmentInteractionListener mListener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);

    mListener = (OnListFragmentInteractionListener) context;
  }

  interface OnListFragmentInteractionListener {

      ArrayList<User> onGetUsersArrauList();
      void onSetFilter(String filter);

    }


}
