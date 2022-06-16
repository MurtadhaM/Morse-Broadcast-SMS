package edu.uncc.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CourseGradesFragment.OnFragmentInteractionListener, AddCourseGradeFragment.OnCourseSelectedListener, CoursesFragment.OnFragmentInteractionListener, LetterGradeFragment.OnFragmentInteractionListener {
  public ArrayList<Grade> grades = new ArrayList<Grade>();
  String SelectedLetterGrade = "";
  DataServices.Course selectedCourse = new DataServices.Course("", "", 0);
  Grade selectedGrade = new Grade("", 0, selectedCourse);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    loadGradesForTesting(); //TODO: added entries testing purposes only .. should be removed later.

    getSupportFragmentManager().beginTransaction()
      .add(R.id.contentView, new CourseGradesFragment())
      .commit();
  }

  private void loadGradesForTesting(){
    grades.add(new Grade("A", 4.0, DataServices.getAllCourses().get(0)));
    grades.add(new Grade("B", 3.0, DataServices.getAllCourses().get(1)));
    grades.add(new Grade("C", 2.0, DataServices.getAllCourses().get(2)));
    grades.add(new Grade("D", 1.0, DataServices.getAllCourses().get(3)));
  }
  @Override
  public ArrayList<Grade> getGrades() {
    return grades;
  }

  @Override
  public void onaddCourseClick() {
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.contentView, new AddCourseGradeFragment())
      .addToBackStack(null)
      .commit();
  }

  @Override
  public void removeGrade(Grade grade) {
    grades.remove(grade);
  }


  @Override
  public DataServices.Course getSelectedCourseNumber() {
    return selectedCourse;
  }

  @Override
  public void onGotoSelectCourse() {
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.contentView, new CoursesFragment())
      .addToBackStack(null)
      .commit();

  }

  @Override
  public void onGotoSelectGrade() {
    getSupportFragmentManager().beginTransaction()
      .replace(R.id.contentView, new LetterGradeFragment())
      .addToBackStack(null)
      .commit();

  }

  @Override
  public String getSelectedGrade() {
    return SelectedLetterGrade;
  }

  @Override
  public void onAddCourseGrade(Grade grade) {
    grades.add(grade);
    getSupportFragmentManager().popBackStack();
  }

  @Override
  public void addCourseGrade(Grade grade) {
    this.grades.add(grade);
  }

  @Override
  public String onSelectedLetterGrade() {
    return SelectedLetterGrade;
  }

  @Override
  public void onSelectCourse(DataServices.Course course) {
    this.selectedCourse = course;
    getSupportFragmentManager().popBackStack();
  }

  @Override
  public void onSetSelectedLetterGrade(String letterGrade) {
    this.SelectedLetterGrade = letterGrade;
    getSupportFragmentManager().popBackStack();

  }
}
