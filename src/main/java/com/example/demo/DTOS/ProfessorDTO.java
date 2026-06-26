package com.example.demo.DTOS;
import java.util.List;

public class ProfessorDTO {
    private String profname;
    private String profdepartment;
    private Long professorid;

    private List<String> coursesteached;

    public void setProfname(String profname){
        this.profname=profname;
    }

    public void setProfdepartment(String profdepartment){
        this.profdepartment=profdepartment;
    }

    public void setProfessorid(Long professorid){
        this.professorid=professorid;
    }

    public void setCoursesteached(List<String> coursesteached){
        this.coursesteached=coursesteached;
    }

    public String getProfname(){
        return profname;
    }

    public String getProfdepartment(){
        return profdepartment;
    }

    public Long getProfessorid(){
        return professorid;
    }

    public List<String> getCoursesteached(){
        return coursesteached;
    }
}
