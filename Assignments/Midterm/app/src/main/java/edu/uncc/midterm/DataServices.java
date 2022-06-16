package edu.uncc.midterm;

import java.io.Serializable;
import java.util.ArrayList;

public class DataServices {
    private static final ArrayList<Course> cci_courses = new ArrayList<Course>(){{
        add(new Course("ITSC 1110","Introduction to Computer Science Principles",3));
        add(new Course("ITSC 1200","Freshman Seminar",3));
        add(new Course("ITSC 1212","Introduction to Computer Science I",4));
        add(new Course("ITSC 1213","Introduction to Computer Science II",4));
        add(new Course("ITSC 1600","Computing Professionals",2));
        add(new Course("ITSC 2175","Logic and Algorithms",3));
        add(new Course("ITSC 2181","Introduction to Computer Systems",4));
        add(new Course("ITSC 2214","Data Structures and Algorithms",3));
        add(new Course("ITSC 2600","Computer Science Program Identity Career",2));
        add(new Course("ITSC 2610","Community Outreach Seminar",1));
        add(new Course("ITSC 2700","Honors Seminar",1));
        add(new Course("ITSC 3146","Introduction to Operating Systems and Networking",3));
        add(new Course("ITSC 3155","Software Engineering",3));
        add(new Course("ITSC 3181","Introduction to Computer Architecture",4));
        add(new Course("ITSC 3500","Computer Science Cooperative Education Experience",0));
        add(new Course("ITSC 3688","Computers and Their Impact on Society",3));
        add(new Course("ITSC 3695","Computer Science Cooperative Education Seminar",1));
        add(new Course("ITSC 3700","Professionalism and Communication in Technology",3));
        add(new Course("ITSC 4155","Software Development Projects",3));
        add(new Course("ITSC 4490","Professional Internship",6));
        add(new Course("ITSC 4681","Senior Design I",3));
        add(new Course("ITSC 4682","Senior Design II",3));
        add(new Course("ITSC 4750","Honors Thesis",3));
        add(new Course("ITSC 4850","Senior Project I",3));
        add(new Course("ITSC 4851","Senior Project II",3));
        add(new Course("ITSC 4990","Undergraduate Research",3));
        add(new Course("ITSC 4991","Undergraduate Thesis",3));
        add(new Course("ITIS 1102","Advanced Internet Concepts",3));
        add(new Course("ITIS 1200","Freshman Seminar",3));
        add(new Course("ITIS 1203","Survey of Computing",3));
        add(new Course("ITIS 1301","Introduction to the Financial Services Industry",3));
        add(new Course("ITIS 1350L","eScience Laboratory",0));
        add(new Course("ITIS 1350","eScience",4));
        add(new Course("ITIS 2110L","IT Infrastructure I: Design and Practice Lab",0));
        add(new Course("ITIS 2110","IT Infrastructure I: Design and Practice",3));
        add(new Course("ITIS 2301","Financial Services Computing Environment",3));
        add(new Course("ITIS 3100","Introduction to IT Infrastructure Systems",3));
        add(new Course("ITIS 3105","Server-Side Applications and Data Management",3));
        add(new Course("ITIS 3106","Structured System Analysis and Design",3));
        add(new Course("ITIS 3130","Human-Centered Design",3));
        add(new Course("ITIS 3131","Human and Computer Information Processing",3));
        add(new Course("ITIS 3132","Information Systems",3));
        add(new Course("ITIS 3135","Web-Based Application Design and Development",3));
        add(new Course("ITIS 3200","Introduction to Information Security and Privacy",3));
        add(new Course("ITIS 3216","Introduction to Cognitive Science",3));
        add(new Course("ITIS 3246","IT Infrastructure and Security",3));
        add(new Course("ITIS 3300","Software Requirements and Project Management",3));
        add(new Course("ITIS 3301","Introduction to the Regulatory Environment for Financial Services Firms",3));
        add(new Course("ITIS 3310","Software Architecture and Design",3));
        add(new Course("ITIS 3320","Introduction to Software Testing and Assurance",3));
        add(new Course("ITIS 4010","Topics in Software and Information Systems",3));
        add(new Course("ITIS 4166","Network-Based Application Development",3));
        add(new Course("ITIS 4170","Advanced Client Applications",3));
        add(new Course("ITIS 4180","Mobile Application Development",3));
        add(new Course("ITIS 4220","Vulnerability Assessment and Systems Assurance",3));
        add(new Course("ITIS 4221","Secure Programming and Penetration Testing",3));
        add(new Course("ITIS 4246","Competitive Cyber Defense",3));
        add(new Course("ITIS 4250","Computer Forensics",3));
        add(new Course("ITIS 4260","Introduction to Security Analytics",3));
        add(new Course("ITIS 4350","Rapid Prototyping",3));
        add(new Course("ITIS 4390","Interaction Design Studio",3));
        add(new Course("ITIS 4410","User-Centered Design and Evaluation",3));
        add(new Course("ITIS 4420","Usable Security and Privacy",3));
        add(new Course("ITIS 4440","Interactive Systems Design and Implementation",3));
        add(new Course("ITIS 4510","Web Mining",3));
        add(new Course("ITIS 4640","Financial Services Informatics Industry Foundations Capstone I",3));
        add(new Course("ITIS 4641","Financial Services Informatics Industry Foundations Capstone II",3));
        add(new Course("ITIS 4990","Undergraduate Research",3));
    }};

    public static class Course implements Serializable{
        String name;
        String number;
        double hours;

        public Course(String number, String name, double hours) {
            this.name = name;
            this.number = number;
            this.hours = hours;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public double getHours() {
            return hours;
        }

        public void setHours(double hours) {
            this.hours = hours;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    ", hours=" + hours +
                    '}';
        }
    }

    public static ArrayList<Course> getAllCourses(){
        return new ArrayList<>(cci_courses);
    }
}
