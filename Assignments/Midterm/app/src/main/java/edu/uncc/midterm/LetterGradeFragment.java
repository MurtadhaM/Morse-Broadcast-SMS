package edu.uncc.midterm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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


public class LetterGradeFragment extends Fragment {

  public LetterGradeFragment() {
    // Required empty public constructor
  }

  public static LetterGradeFragment newInstance(String param1, String param2) {
    LetterGradeFragment fragment = new LetterGradeFragment();

    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_letter_grade, container, false);
        /*
        TODO: List letter grades
         */
    ArrayList<String> lettergrades = new ArrayList<String>();
      /*
      TODO: Populate the list of letter grades
       */
    lettergrades.add("A");
    lettergrades.add("B");
    lettergrades.add("C");
    lettergrades.add("D");
    lettergrades.add("F");


/*
TODO: Create an ArrayAdapter to display the letter grades
 */
    ListView letterGradeListView = view.findViewById(R.id.listView);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, lettergrades);
    letterGradeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String letterGrade = (String) parent.getItemAtPosition(position);
        mListener.onSetSelectedLetterGrade(letterGrade);
      }
    });
    letterGradeListView.setAdapter(adapter);


    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getActivity().setTitle("Letter Grade");
  }

  OnFragmentInteractionListener mListener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      Toast.makeText(context, "Interface Not Implemented", Toast.LENGTH_SHORT).show();
    }

  }

  interface OnFragmentInteractionListener {
    void onSetSelectedLetterGrade(String letterGrade);
  }
}
