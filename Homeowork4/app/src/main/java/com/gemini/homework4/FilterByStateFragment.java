package com.gemini.homework4;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.gemini.homework4.databinding.FilterbystatefragmentBinding;

import java.util.ArrayList;
import java.util.Comparator;

public class FilterByStateFragment extends Fragment {
    ListView UniqueStatesListView;

    private FilterbystatefragmentBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FilterbystatefragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();








    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            getActivity().setTitle("Filter by State");
        }

        // Bind the List to the object
      UniqueStatesListView = binding.ListViewUniqueStates;

      // Get the States from The MainActivity
      ArrayList<String> uniqueStatesArrayList = mListener.onGetUniqStates();
      // Adding ALL STATES to the ArrayList
      uniqueStatesArrayList.add("All States");

      // Sort the ArrayList by State in Ascending Order
      uniqueStatesArrayList.sort(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
          // if the state name is "ALL STATES" then it should be at the top of the list
          if (o1.equals("All States")) {
            return -1;
          }
          return o1.compareTo(o2);
        }
      });


      Log.d(TAG, "onViewCreated: Got the Unique States" + uniqueStatesArrayList.size());
      // Create the Adapter
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, uniqueStatesArrayList);

      // Set the Adapter
      UniqueStatesListView.setAdapter(adapter);



      // Set the OnClickListener
      UniqueStatesListView.setOnItemClickListener((parent, view1, position, id) -> {
        // Get the State
        String state = (String) UniqueStatesListView.getItemAtPosition(position);
        Log.d(TAG, "onViewCreated: " + state);
        if(state.equals("All States")){
          // If the State is "All States" then we want to show all the users
          mListener.onSelectState("All States");
        } else {
          // If the State is not "All States" then we want to filter the users by the state
          mListener.onSelectState(state);
        }
      });








    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

  FilterByStateFragment.onFilterByStateFragmentListener mListener;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);


    try {
      mListener = (FilterByStateFragment.onFilterByStateFragmentListener) context;

    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement onAppListFragmentListener");
    }
  }

  interface onFilterByStateFragmentListener {
    void onSelectState(String state);
    ArrayList<String> onGetUniqStates();

  }

}
