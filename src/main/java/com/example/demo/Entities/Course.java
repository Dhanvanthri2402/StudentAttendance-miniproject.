package com.example.demo.Entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long courseid;

    private String coursename;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    @ManyToMany()
    @JoinTable(name="course_student",joinColumns=@JoinColumn(name="course_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> enrolledstudents= new ArrayList<>();

    public void setCourseid(Long courseid){
        this.courseid=courseid;
    }

    public void setCoursename(String coursename){
        this.coursename=coursename;
    }

    public void setProfessor(Professor professor){
        this.professor=professor;
    }

    public Long getCourseid(){
        return courseid;
    }

    public String getCoursename(){
        return coursename;
    }

    public Professor getProfessor(){
        return professor;
    }

    public void setEnrolledstudents(List<Student> enrolledstudents){
        this.enrolledstudents=enrolledstudents;
    }

    public List<Student> getEnrolledstudents(){
        return enrolledstudents;
    }

}
