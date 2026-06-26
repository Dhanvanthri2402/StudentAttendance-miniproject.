package com.example.demo.Entities;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long profid;

    private String profname;
    private String profdepartment;

    @OneToMany(mappedBy="professor",cascade= CascadeType.ALL)
    private List<Course> courses;

    public void setProfname(String profname){
        this.profname=profname;
    }

    public void setProfid(Long profid){
        this.profid=profid;
    }

    public void setProfdepartment(String profdepartment){
        this.profdepartment=profdepartment;
    }

    public void setCourses(List <Course> courses){
        this.courses=courses;
    }

    public Long getProfid(){
        return profid;
    }

    public String getProfname(){
        return profname;
    }

    public String getProfdepartment(){
        return profdepartment;
    }

    public List<Course> getCourses(){
        return courses;
    }

}
