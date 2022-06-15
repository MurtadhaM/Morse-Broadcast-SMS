package edu.uncc.midterm;

import java.io.Serializable;

public class Grade implements Serializable {
    public String letterGrade;
    public double numberGrade;
    public DataServices.Course course;

    public Grade() {
    }

    public Grade(String letterGrade, double numberGrade, DataServices.Course course) {
        this.letterGrade = letterGrade;
        this.numberGrade = numberGrade;
        this.course = course;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public double getNumberGrade() {
        return numberGrade;
    }

    public void setNumberGrade(double numberGrade) {
        this.numberGrade = numberGrade;
    }

    public DataServices.Course getCourse() {
        return course;
    }

    public void setCourse(DataServices.Course course) {
        this.course = course;
    }
}
