package com.example.demo;

public class StudentDTO {
    private String name;
    private String status;
    private String location;

    public void setName(String name){
        this.name= name;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public String getStatus(){
        return status;
    }

    public String getLocation(){ return location; }

}
