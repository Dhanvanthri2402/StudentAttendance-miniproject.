package com.example.demo.Entities;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.time.LocalTime;
import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;

@Entity
public class ClassSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionid;

    private LocalDate sessionDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalTime actualstartTime;
    private LocalTime actualendTime;
    private String status;
    private boolean isactive =false;

    @OneToMany(mappedBy = "classSession", cascade = CascadeType.ALL)
    private List<Attrecord> attendancerecords;

    @ManyToOne()
    @JoinColumn(name = "Course_id")
    private Course course;

    public void setSessionid(Long sessionid) {
        this.sessionid = sessionid;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setAttendancerecords(List<Attrecord> attendancerecords) {
        this.attendancerecords = attendancerecords;
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

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public Long getSessionid() {
        return sessionid;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Course getCourse() {
        return course;
    }

    public List<Attrecord> getAttendancerecords() {
        return attendancerecords;
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