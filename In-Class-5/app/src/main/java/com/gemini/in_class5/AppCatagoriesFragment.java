/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 5

 */
package com.gemini.in_class5;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AppCatagoriesFragment extends Fragment {

  ArrayAdapter<String> adapter;
  TextView catagory_name;


  public AppCatagoriesFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragmentappcatagoriesfragmentlayout, container, false);
    adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, DataServices.getAppCategories());

    ListView listView = view.findViewById(R.id.List_View);
    listView.setAdapter(adapter);


    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String catagory = adapter.getItem(position);
        mListener.onSetAppCatagory(catagory);
//        Toast.makeText(getActivity(), "I set the catagory for apps to:  " + catagory, Toast.LENGTH_SHORT).show();
      }
    });


    return view;
  }

  /*
  TODO: Description:   This interface must be implemented by activities that contain this fragment to allow an interaction in this
 */
  AppCatagoriesFragment.onItemFragmentListener mListener;


  /*
    TODO : Setting up the onAttach method to attach the listener to the activity
   */
  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof AppCatagoriesFragment.onItemFragmentListener) {
      mListener = (AppCatagoriesFragment.onItemFragmentListener) context;
    } else {
      throw new RuntimeException(context.toString()
        + " must implement OnListFragmentInteractionListener");
    }
  }

  interface onItemFragmentListener {
    int getItemCount();

    void onSetAppCatagory(String catagory);
  }

}
