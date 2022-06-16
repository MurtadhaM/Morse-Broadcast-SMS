package edu.uncc.midterm;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class CoursesFragment extends Fragment {
  ArrayList<DataServices.Course> courses;
  ListView CoursesListView;
    public CoursesFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CoursesFragment newInstance(String param1, String param2) {
        CoursesFragment fragment = new CoursesFragment();
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
        View view =  inflater.inflate(R.layout.fragment_courses, container, false);
        /*
        TODO: Retrieve  the  list  of  courses  by  calling  DataServices.getAllCourses()  method,  which
            returns the list of courses to use in this application
         */
      courses = DataServices.getAllCourses();
      CoursesListView = view.findViewById(R.id.listView);

        /*
          TODO: The  ListView  should  display  the  courses  as  shown  in  Figure  2(a),  where  for  each
            course it should display the course name, number and credit hours
         */
      ArrayAdapter<DataServices.Course> adapter = new CoursesAdapter(getContext(), R.layout.course_grade_row_item, courses);
      CoursesListView.setAdapter(adapter);


        return  view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Courses");
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
        void  onSelectCourse(DataServices.Course course);
    }

  class CoursesAdapter extends ArrayAdapter<DataServices.Course> {
    public CoursesAdapter(Context context, ArrayList<DataServices.Course> courses) {
      super(context, 0, courses);

    }

    public CoursesAdapter(Context context, int course_grade_row_item, ArrayList<DataServices.Course> courses) {
      super(context, course_grade_row_item, courses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      LayoutInflater inflater = LayoutInflater.from(getContext());
      View itemView = inflater.inflate(R.layout.course_row_item, parent, false);
      DataServices.Course course = getItem(position);
      itemView.setTag(course);
      TextView courseName = itemView.findViewById(R.id.textViewCourseName);
      courseName.setText(course.getName());
      TextView courseNumber = itemView.findViewById(R.id.textViewCourseNumber);
      courseNumber.setText(course.getNumber());
      TextView courseCreditHours = itemView.findViewById(R.id.textViewCourseHours);
      courseCreditHours.setText(course.getHours() + " Credit Hours");


      /*
        TODO: onClickListener for the course row item
       */
      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          DataServices.Course course = (DataServices.Course) v.getTag();
          mListener.onSelectCourse(course);

        }
      });

      return itemView;
    }

    @Override
    public int getCount() {
      return courses.size();
    }
    @Override
    public DataServices.Course getItem(int position) {
      return courses.get(position);
    }


  }
}
