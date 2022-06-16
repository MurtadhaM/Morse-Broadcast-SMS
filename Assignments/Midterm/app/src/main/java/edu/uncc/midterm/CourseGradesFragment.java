package edu.uncc.midterm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class CourseGradesFragment extends Fragment {
  // Global variables
  ArrayList<Grade> grades;
  RecyclerView gradesrecyclerView;
  CourseGradesAdapter gradesAdapter;
  TextView textViewGPA;
  TextView textViewCredits;
  ImageView addButton;

    public CourseGradesFragment() {
        // Required empty public constructor
    }


    public static CourseGradesFragment newInstance(String param1, String param2) {
        CourseGradesFragment fragment = new CourseGradesFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    // A method to calculate the GPA of the course

  public String calculateGPA(ArrayList<Grade> grades) {
    double gpa = 0;
    double totalCredits = 0;
    for (Grade grade : grades) {
      gpa += grade.getNumberGrade() * grade.course.getHours();
      totalCredits += grade.course.getHours();
    }
    // limit the GPA to 2 decimal places
    return String.valueOf(Math.round((gpa / totalCredits) * 100.0) / 100.0);

  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course_grades, container, false);
      textViewGPA = view.findViewById(R.id.textViewGPA);
      textViewCredits = view.findViewById(R.id.textView2);
        // Get the list of grades from the the main activity
      /*
      TODO: PART 1: Get the list of grades from the main activity
       */
        grades = mListener.getGrades();
       /*
       TODO: PART 1: Get the recycler view from the fragment
        */
      gradesAdapter = new CourseGradesAdapter(getContext(), grades);
      gradesrecyclerView = view.findViewById(R.id.recyclerView);
      // Layout manager for the recycler view
      gradesrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
      // Set the adapter for the recycler view
      gradesrecyclerView.setAdapter(gradesAdapter);

    /*
    TODO: Part 1:  Display the grades in the recycler view
     */
      // After  displaying  the  RecyclerView  the  overall  GPA  and  total  number  of  hours
      //should be calculated and displayed.

      String gpa = String.valueOf(calculateGPA(grades));
      String credits = (calculateTotalCredits(grades));
      textViewGPA.setText("GPA: " + gpa);
      textViewCredits.setText("Total Credits: " + credits);

      /*
        TODO: Click add listener for the add button
       */
      addButton = view.findViewById(R.id.imageViewAddCourse);
      addButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          mListener.onaddCourseClick();
          gradesAdapter.notifyDataSetChanged();
        }
      });





      return view;
    }

  private String calculateTotalCredits(ArrayList<Grade> grades) {
    double totalCredits = 0;
    for (Grade grade : grades) {
      totalCredits += grade.course.getHours();
    }
    // limit the Total Hours to 2 decimal places

    return  String.valueOf(Math.round((totalCredits) * 100.0) / 100.0);

  }

  @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Course Grades");
    }

    OnFragmentInteractionListener mListener;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }
/*
 TODO:   1: Delete Grade and Refresh RecyclerView and GPA/Hours
 */
  void deleteGrade(Grade grade) {
    mListener.removeGrade(grade);
    gradesAdapter.notifyDataSetChanged();
    String gpa = String.valueOf(calculateGPA(grades));
    String credits = (calculateTotalCredits(grades));
    textViewGPA.setText("GPA: " + gpa);
    textViewCredits.setText("Total Credits: " + credits);

  }

  void recalculate()
  {
    calculateGPA(grades);
    calculateTotalCredits(grades);
  }
  interface OnFragmentInteractionListener {
      ArrayList<Grade> getGrades();

      void onaddCourseClick();

    void removeGrade(Grade grade);
  }

    class CourseGradesAdapter extends RecyclerView.Adapter<CourseGradesAdapter.CourseGradesViewHolder> {

      private ArrayList<Grade> grades;
      private Context context;

      public CourseGradesAdapter(Context context, ArrayList<Grade> grades) {
        this.grades = grades;
        this.context = context;
      }

      @NonNull
      @Override
      public CourseGradesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.course_grade_row_item, parent, false);
        return new CourseGradesViewHolder(itemView);
      }

      @Override
      public void onBindViewHolder(@NonNull CourseGradesViewHolder holder, int position) {
        Grade grade = grades.get(position);
        holder.courseNameTextView.setText(grade.getCourse().name);
        holder.gradeLetterTextView.setText(grade.getLetterGrade());
        holder.gradeHoursTextView.setText(String.valueOf(grade.course.getHours()));
        holder.courseNumberTextView.setText(String.valueOf(grade.getCourse().number));



        /*
          Click listener for the delete button
         */
        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            deleteGrade(grade);
          }
        });



      }

      @Override
      public int getItemCount() {
        return grades.size();
      }

      class CourseGradesViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTextView;
        TextView gradeLetterTextView;
        TextView gradeHoursTextView;
        TextView courseNumberTextView;
        ImageView deleteImageView;
        public CourseGradesViewHolder(View itemView) {
          super(itemView);
          courseNameTextView = itemView.findViewById(R.id.textViewCourseName);
          gradeLetterTextView = itemView.findViewById(R.id.textViewLetterGrade);
          gradeHoursTextView = itemView.findViewById(R.id.textViewCourseHours);
          courseNumberTextView = itemView.findViewById(R.id.textViewCourseNumber);
          deleteImageView = itemView.findViewById(R.id.imageViewDelete);
        }


      }


    }







}
