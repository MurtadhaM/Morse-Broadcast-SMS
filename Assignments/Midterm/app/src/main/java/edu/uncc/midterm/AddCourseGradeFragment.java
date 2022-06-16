package edu.uncc.midterm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCourseGradeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCourseGradeFragment extends Fragment {
  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";
  Button SelectCourseButton;
  Button SelectGradeButton;
  Button CancelButton;
  Button SubmitButton;
  TextView textViewCourseNumber;
  TextView textViewCourseName;
  TextView textViewSelectedGrade;
  TextView textViewCourseHours;
  OnCourseSelectedListener mlistener;
  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  public AddCourseGradeFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment AddCourseGradeFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static AddCourseGradeFragment newInstance(String param1, String param2) {
    AddCourseGradeFragment fragment = new AddCourseGradeFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_add_course_grade, container, false);
    CancelButton = view.findViewById(R.id.buttonCancel);
    SelectCourseButton = view.findViewById(R.id.buttonSelectCourse);
    SelectGradeButton = view.findViewById(R.id.buttonSelectGrade);
    SubmitButton = view.findViewById(R.id.buttonSubmit);
    textViewCourseNumber = view.findViewById(R.id.textViewCourseNumber);
    textViewCourseName = view.findViewById(R.id.textViewCourseName);
    textViewSelectedGrade = view.findViewById(R.id.textViewSelectedGrade);
    textViewCourseHours = view.findViewById(R.id.textViewCourseHours);

         /*
        TODO:   Click "Select Course" and correct navigation
         */
    SelectCourseButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // TODO: GO TO SELECT COURSE FRAGMENT
        mlistener.onGotoSelectCourse();
      }
    });

        /*
        TODO: Part 2: Click "Select Grade" and correct navigation
         */
    SelectGradeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        // TODO: GO TO SELECT GRADE FRAGMENT
        mlistener.onGotoSelectGrade();
      }

    });

        /*
        TODO:  Part 2: Receive course selected and display correctly in textViewCourseNumber
         */
    DataServices.Course selectedCourse = mlistener.getSelectedCourseNumber();
    if (selectedCourse.getNumber().length() > 1) {
      textViewCourseNumber.setText("Course Number: " + selectedCourse.getNumber());
      textViewCourseName.setText("Course Name: " + selectedCourse.getName());
      textViewCourseHours.setText("Course Hours: " + selectedCourse.getHours());
    } else {
      textViewCourseName.setText("No Course Selected");
    }

        /*
          TODO:   Part 2: Receive grade selected and display correctly

         */

    String selectedGrade = mlistener.getSelectedGrade();

    if (selectedGrade.length() > 1) {
      textViewSelectedGrade.setText("Grade: " + selectedGrade);
    } else {
      textViewSelectedGrade.setText(mlistener.onSelectedLetterGrade());
    }

        /*
        TODO: Cancel button
         */
    CancelButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        getParentFragmentManager().popBackStack();
      }
    });



      /*
        TODO: Submit button
       */
    SubmitButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        // Check if course and grade are selected
        if (selectedCourse.getNumber().length() <= 1) {
          Toast.makeText(getContext(), "Select a Course", Toast.LENGTH_SHORT).show();
        } else if (selectedGrade.isEmpty()) {
          Toast.makeText(getContext(), "Select a Grade", Toast.LENGTH_SHORT).show();
        } else {
          // TODO: Add course and grade
          mlistener.onAddCourseGrade(new Grade(selectedGrade, getNumberGrade(selectedGrade), new DataServices.Course(selectedCourse.getNumber(), selectedCourse.getName(), selectedCourse.getHours())));
          // TODO: Pop back stack
          getParentFragmentManager().popBackStack();
        }

      }
    });


    return view;

  }

  private double getNumberGrade(String selectedGrade) {
    double numberGrade = 0;
    switch (selectedGrade) {
      case "A":
        numberGrade = 4.0;
        break;
      case "B":
        numberGrade = 3.0;
        break;
      case "C":
        numberGrade = 2.0;
        break;
      case "D":
        numberGrade = 1.0;
        break;
      case "F":
        numberGrade = 0.0;
        break;
      default:
        numberGrade = 0.0;
        break;

    }
    return numberGrade;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getActivity().setTitle("Add Course Grade");
  }

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof OnCourseSelectedListener) {
      mlistener = (OnCourseSelectedListener) context;
    } else {
      throw new ClassCastException(context.toString()
        + " must implement OnCourseSelectedListener");
    }

  }

  /*
  Interface for communication between fragments and main activity
   */
  interface OnCourseSelectedListener {
    DataServices.Course getSelectedCourseNumber();

    void onGotoSelectCourse();

    void onGotoSelectGrade();

    String getSelectedGrade();

    void onAddCourseGrade(Grade grade);

    void addCourseGrade(Grade grade);

    String onSelectedLetterGrade();
  }
}
