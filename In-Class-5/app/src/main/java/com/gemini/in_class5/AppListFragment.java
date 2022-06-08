/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 5

 */
package com.gemini.in_class5;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.gemini.in_class5.databinding.*;

import java.util.ArrayList;
import java.util.List;

public class AppListFragment extends Fragment {
  ArrayAdapter<DataServices.App> adapter;
  TextView app_name;

  ScriptGroup.Binding binding;


  public AppListFragment() {
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
    View view = inflater.inflate(R.layout.app_list_layout, container, false);

      /*
      TODO: FIRST INTERFACE
       */

    ArrayList<DataServices.App> apps = mListerner.onGetApps();


    ListAdapter adapter = new AppAdapter((Activity) getContext(), apps);

    // GET THE LIST VIEW
    ListView listView = (ListView) view.findViewById(R.id.listView_apps);
    // ATTACH THE ADAPTER TO THE LIST VIEW
    listView.setAdapter(adapter);

    // SET THE LISTENER
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DataServices.App selectedApp = (DataServices.App) parent.getItemAtPosition(position);

        Log.d(TAG, "onItemClick: You clicked on: " + selectedApp.name);
//        Toast.makeText(getContext(), "You clicked on: " + apps.get(position).name, Toast.LENGTH_SHORT).show();

        mListerner.onsetSelectedApp(selectedApp);
      }
    });


//    Toast.makeText(getContext(), apps.get(0).toString(), Toast.LENGTH_SHORT).show();
    return view;
  }

  onAppListFragmentListener mListerner;

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);


    try {
      mListerner = (onAppListFragmentListener) context;

    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement onAppListFragmentListener");
    }
  }


  interface onAppListFragmentListener {
    ArrayList<String> onGetAppNames();

    ArrayList<DataServices.App> onGetApps();

    void onsetSelectedApp(DataServices.App selectedApp);


  }
}
