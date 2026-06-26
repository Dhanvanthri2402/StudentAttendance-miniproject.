package com.example.demo.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import java.time.LocalDate;

@Entity
@Table(name="Attendance_Record")
public class Attrecord {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long attid;
    private LocalDate date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "Student_id",nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="session_id")
    private ClassSession classSession;



    public void setAttid(Long attid){
        this.attid=attid;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public void setStudent(Student student){
        this.student=student;
    }

    public void setClassSession(ClassSession classSession) {
        this.classSession = classSession;
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

    public Student getStudent(){
        return student;
    }

    public ClassSession getClassSession() {
        return classSession;
    }
}
