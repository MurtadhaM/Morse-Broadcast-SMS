package com.gemini.homework4;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class SortFragment extends Fragment implements SortAdapter.ISorterRecyclerViewListener {


    public SortFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.sortfragment, container, false);

      if (getActivity() != null) {
        getActivity().setTitle("Sort");
      }

      // Create the recycler view and fetch the layout
      RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.Recycle_View_Sort_Fragment);

      // Passing data and mlisterner to the adapter
      SortAdapter adapter = new SortAdapter(mListener.getSortList(), this);
      recyclerView.setHasFixedSize(true);
      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

      // use a linear layout manager
      recyclerView.setLayoutManager(layoutManager);

      // set the adapter
      recyclerView.setAdapter(adapter);



      return view;
    }

    /*
    TODO : SETTING UP INTERFACE
     */
  SortFragment.onSortFragmentListener mListener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);


    try {
      mListener = (SortFragment.onSortFragmentListener) context;
    } catch (ClassCastException e) {
      throw new ClassCastException(context.toString() + " must implement onAppListFragmentListener");
    }
  }


  @Override
  public void onSelectedSortRecyclerMethod(String sortMethod, String sortOrder) {
    Log.d(TAG, "onSelectedSortMethod: " + sortMethod + " " + sortOrder);
    mListener.onSetSortMethodListener(sortMethod, sortOrder);
  }


  interface onSortFragmentListener {
    void onSetSortMethodListener(String sortMethod, String sortOrder);
    Sorter[] getSortList();
  }
}
