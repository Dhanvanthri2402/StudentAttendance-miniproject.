package com.example.demo;

import jakarta.persistence.*;

import java.time.LocalDate;

public class AttrecordDTO{

    private Long attid;
    private LocalDate date;
    private String status;

    public void setAttid(Long attid){
        this.attid=attid;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public void setStatus(String status){
        this.status=status;
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


}
