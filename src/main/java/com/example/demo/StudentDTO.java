package com.example.demo;

public class StudentDTO {
    private String name;
    private String status;

    public void setName(String name){
        this.name= name;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

}
