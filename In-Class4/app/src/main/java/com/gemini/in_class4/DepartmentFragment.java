/*
Authors: Murtadha Marzouq && Will Colvill
Assignment: In Class 4

 */

package com.gemini.in_class4;

import static com.gemini.in_class4.UserViewModel.user;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DepartmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DepartmentFragment extends Fragment {

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "User";
  RadioGroup radioGroup;
  // TODO: Rename and change types of parameters
  private String mParam1;

  public DepartmentFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment DepartmentFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static DepartmentFragment newInstance(UserViewModel.User user) {
    DepartmentFragment fragment = new DepartmentFragment();
    Bundle args = new Bundle();
    args.putSerializable(ARG_PARAM1, user);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
    }
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
      int selectedId = radioGroup.getCheckedRadioButtonId();
      RadioButton radioButton = v.findViewById(selectedId);
      String department = radioButton.getText().toString();
      user.setDepartment(department);
      Log.d("DepartmentFragment", "Department: " + department);
      Toast.makeText(getContext(), "Department: " + department, Toast.LENGTH_SHORT).show();
      // start the main activity


      if (getFragmentManager() != null) {
        getFragmentManager().popBackStack();


      }

    });


    button_cancel_department.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (getParentFragmentManager().getBackStackEntryCount() > 0) {
          getParentFragmentManager().popBackStack();


        }


      }
    });


    return v;
  }
}
