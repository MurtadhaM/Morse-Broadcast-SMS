package com.example.practice2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice2.databinding.FragmentUsersLayoutBinding;

import java.util.ArrayList;

public class UserFragment extends Fragment {
    RecyclerView ListOfUsers;
    UserAdapter userAdapter;
    ArrayList<DataServices.User> users;
    private FragmentUsersLayoutBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentUsersLayoutBinding.inflate(inflater, container, false);

        users = mListener.onFragmentInteraction();

      userAdapter = new UserAdapter(users);

        ListOfUsers = binding.UsersRecycleView;
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
      ListOfUsers.setLayoutManager(linearLayoutManager);

        ListOfUsers.setAdapter(userAdapter);








        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
  OnFragmentInteractionListener mListener;
  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mListener = (OnFragmentInteractionListener) context;

  }

  interface OnFragmentInteractionListener {
    ArrayList<DataServices.User> onFragmentInteraction();
  }


}
