package com.example.demo.DTOS;

import java.time.LocalDate;

public class AttrecordDTO{

    private Long attid;
    private LocalDate date;
    private String status;
    private String studentname;
    private String coursename;

    public void setAttid(Long attid){
        this.attid=attid;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Long getAttid(){
        return attid;
    }

    public LocalDate getDate(){
        return date;
    }

    public String getStatus(){
        return status;
    }

    public String getStudentname() {
        return studentname;
    }

    public String getCoursename() {
        return coursename;
    }
}
