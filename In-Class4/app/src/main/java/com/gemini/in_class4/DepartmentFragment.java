/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */

package com.gemini.in_class4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class DepartmentFragment extends Fragment {

  RadioGroup radioGroup;

  public DepartmentFragment() {
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
    View v = inflater.inflate(R.layout.fragment_department, container, false);

    Button button_submit_department = v.findViewById(R.id.button_select);
    Button button_cancel_department = v.findViewById(R.id.button_cancel);
    radioGroup = v.findViewById(R.id.radioGroup);
    button_submit_department.setOnClickListener(v1 -> {
      if(radioGroup.getCheckedRadioButtonId() != -1){
        RadioButton rd = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        String department = rd.getText().toString();

        mListener.onDepartmentSelected(department);
      }

    });


    button_cancel_department.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        mListener.onDepartmentCancelled();



      }
    });


    return v;
  }


  DepartmentFragmentListener mListener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    mListener = (DepartmentFragmentListener) context;

  }

  interface DepartmentFragmentListener {
    void onDepartmentSelected(String department);
    void onDepartmentCancelled();
  }
}
