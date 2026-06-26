package com.example.demo.DTOS;
import java.util.List;

public class StudentDTO {
    private String name;
    private String status;
    private String department;
    private List<String> enrolledcourses;


    public void setName(String name){
        this.name= name;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEnrolledcourses(List<String> enrolledcourses) {
        this.enrolledcourses = enrolledcourses;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public String getDepartment() {
        return department;
    }

    public List<String> getEnrolledcourses() {
        return enrolledcourses;
    }
}
