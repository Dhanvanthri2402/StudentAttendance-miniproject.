package com.example.demo.DTOS;
import java.time.LocalTime;
import java.time.LocalDate;

public class ClassSessionDTO {
    private Long sessionid;
    private LocalDate sessionDate;
    private LocalTime starttime;
    private LocalTime endtime;
    private String coursename;
    private String professorname;
    private String status;
    private LocalTime actualstartTime;
    private LocalTime actualendTime;

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setSessionid(Long sessionid) {
        this.sessionid = sessionid;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public void setProfessorname(String professorname) {
        this.professorname = professorname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setActualstartTime(LocalTime actualstartTime) {
        this.actualstartTime = actualstartTime;
    }

    public void setActualendTime(LocalTime actualendTime) {
        this.actualendTime = actualendTime;
    }

    public Long getSessionid() {
        return sessionid;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public String getCoursename() {
        return coursename;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public String getProfessorname() {
        return professorname;
    }

    public String getStatus() {
        return status;
    }

    public LocalTime getActualstartTime() {
        return actualstartTime;
    }

    public LocalTime getActualendTime() {
        return actualendTime;
    }
}
