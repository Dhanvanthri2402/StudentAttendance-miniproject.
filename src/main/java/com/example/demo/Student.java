package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;

import java.util.List;
import java.util.ArrayList;


@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Student should provide name")
    private String name;

    @Min(value = 17,message="The age of the student should be greater than or equal to 17!")
    private int age;

    @NotBlank(message="Active or Inactive")
    private String status;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List <Attrecord> dailyrecord = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getID(){
        return id;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge(){
        return age;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }

    public void setDailyrecord(List<Attrecord> dailyrecord){
        this.dailyrecord=dailyrecord;
    }

    public List<Attrecord> getDailyrecord(){
        return dailyrecord;
    }
}


