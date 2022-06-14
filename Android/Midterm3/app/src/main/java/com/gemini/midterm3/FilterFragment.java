package com.gemini.midterm3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gemini.midterm3.databinding.*;

import java.util.ArrayList;

public class FilterFragment extends Fragment {
RecyclerView filterRecyclerView;
FilterAdapter filterAdapter;
LinearLayoutManager linearLayoutManager;
ArrayList<User> filterList;


    private FragmentFilterBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

      View view = inflater.inflate(R.layout.fragment_filter, container, false);
        binding = FragmentFilterBinding.inflate(inflater, container, false);



      // Getting the first Filter Item List from the main activity
      filterList = mlistener.onGetFilterList();
      // get an adapter for the filter list
      filterAdapter = new FilterAdapter();
      // get a layout manager for the filter list
      filterRecyclerView = binding.getRoot().findViewById(R.id.recyclerView_filter);
      // set the layout manager for the filter list
       linearLayoutManager = new LinearLayoutManager(getContext());
       // set orientation to horizontal
      linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
      // assign the layout manager to the filter list
      filterRecyclerView.setLayoutManager(linearLayoutManager);
      // set the adapter for the filter list
      filterRecyclerView.setAdapter(filterAdapter);





      return binding.getRoot();

    }

    // This method returns the names of Users ArrayList
  public ArrayList<String> getNames(ArrayList<User> filterList) {
      // Creating an ArrayList of Strings to store the names of the Users
      ArrayList<String> filterListNames = new ArrayList<>();
      // Looping through the ArrayList of Users
      for (User user : filterList) {
        // Adding the name of the User to the ArrayList of Strings
        filterListNames.add(user.getName());
      }
      // Returning the ArrayList of Strings
      return filterListNames;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

  OnFilterFragmentInteractionListener mlistener;
  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mlistener = (OnFilterFragmentInteractionListener) context;
  }


  interface OnFilterFragmentInteractionListener {
        void onSetFilter(Comparable<String> filter);
        ArrayList<User> onGetFilterList();
    }

}
