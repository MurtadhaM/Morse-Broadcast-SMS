/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 5

 */
package com.gemini.in_class5;


import android.content.Context;
import android.os.Bundle;

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

public class AppDetailsFragment extends Fragment {
  TextView app_name;
  TextView app_artist;
  TextView app_release_date;

  ArrayList<String> app_genres;
  ArrayAdapter<DataServices.App> adapter;
  ListView listView;
  DataServices.App app;

  public AppDetailsFragment() {
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
    View view = inflater.inflate(R.layout.fragment_app_details, container, false);


    // Getting the SElected App
    app = mListener.onGetApp();

    // Assign the app UI elements
    app_name = view.findViewById(R.id.app_details_name);
    app_artist = view.findViewById(R.id.app_details_artist);
    app_release_date = view.findViewById(R.id.app_details_release_date);

// -- Setting the values of the text views
    app_name.setText(String.format("Name: %s", app.name));
    app_artist.setText(String.format("Artist: %s", app.artistName));
    app_release_date.setText(String.format("Release Date: %s", app.releaseDate));

    // -- Setting the list view
    listView = view.findViewById(R.id.app_details_genres_listView);
    app_genres = app.genres;
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, app_genres);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String genre = app_genres.get(position);
//        Toast.makeText(getContext(), genre, Toast.LENGTH_SHORT).show();

      }
    });


    return view;
  }

/*
TODO: SECOND INTERFACE
 */

  AppDetailsFragment.onAppDetailsFragmentListener mListener;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);


    try {
      mListener = (AppDetailsFragment.onAppDetailsFragmentListener) context;

    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement onAppListFragmentListener");
    }
  }


  interface onAppDetailsFragmentListener {

    DataServices.App onGetApp();


  }

}
