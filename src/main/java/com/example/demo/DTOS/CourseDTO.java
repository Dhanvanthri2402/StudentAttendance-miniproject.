package com.example.demo.DTOS;
import java.util.List;

public class CourseDTO {
    private String coursename;
    private Long courseid;
    private List<String> studentsenrolled;
    private String professorname;

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public void setStudentsenrolled(List<String> studentsenrolled) {
        this.studentsenrolled = studentsenrolled;
    }

    public void setProfessorname(String professorname) {
        this.professorname = professorname;
    }

    public String getCoursename() {
        return coursename;
    }

    public Long getCourseid() {
        return courseid;
    }

    public List<String> getStudentsenrolled() {
        return studentsenrolled;
    }

    public String getProfessorname() {
        return professorname;
    }
}
