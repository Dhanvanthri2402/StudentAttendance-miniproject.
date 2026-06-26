package com.example.demo.Services;
import com.example.demo.DTOS.AttrecordDTO;
import com.example.demo.DTOS.StudentDTO;
import com.example.demo.Entities.Attrecord;
import com.example.demo.Entities.ClassSession;
import com.example.demo.Entities.Student;
import com.example.demo.Repositories.AttrecordRepository;
import com.example.demo.Repositories.Attrepository;
import com.example.demo.Repositories.ClassSessionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
public class Attservice {
    @Autowired
    private Attrepository attrepository;

    @Autowired
    private AttrecordRepository attrecordRepository;

    @Autowired
    private ClassSessionRepository classSessionRepository;

    public String register(Student student){
         attrepository.save(student);
         return "Student details registered successfully";

    }

    public StudentDTO getstatus(Long id){
       Student stentity = attrepository.findById(id).orElseThrow(()-> new RuntimeException("Student with this id cannot be found "));
       StudentDTO sdto = new StudentDTO();
       sdto.setName(stentity.getName());
       sdto.setStatus(stentity.getStatus());
       return sdto;
    }

    public String updatestudent(Long id,Student student){
        Student student1 = attrepository.findById(id).orElseThrow(()-> new RuntimeException("Student with this id cannot be found"));
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setStatus(student.getStatus());
        attrepository.save(student1);
        return "Student details updated for this id "+id;
    }

    public String updatestatus(Long id,String status){
        Student student1 = attrepository.findById(id).orElseThrow(()-> new RuntimeException("Student with this id cannot be found"));
        student1.setStatus(status);
        attrepository.save(student1);
        return "Status of the student with this id is updated "+id;
    }


    public String deletestudent(Long id){
        attrepository.deleteById(id);
        return "Student details are deleted for this id "+id;
    }

    public List<StudentDTO> getstudentbystatus(String status){
        List<Student> rawentity = attrepository.findByStatus(status);
        return rawentity.stream().map(Student-> {
            StudentDTO dto = new StudentDTO();
            dto.setStatus(Student.getStatus());
            dto.setName(Student.getName());
            return dto;}).collect(Collectors.toList());
    }

    public String markSessionAttendance(Long stid,Long sessionid,String status){
        Student student = attrepository.findById(stid).orElseThrow(()->new RuntimeException("Student id invalid"));
        ClassSession session = classSessionRepository.findById(sessionid).orElseThrow(()-> new RuntimeException("Session id invalid"));
        if(!"LIVE".equals(session.getStatus())){
            throw new RuntimeException("Attendance cannot be marked for the provided session id");
        }
        boolean ismarked = session.getAttendancerecords().stream().anyMatch(attrecord->attrecord.getStudent().getID().equals(stid));
        if(ismarked){
            return "The attendance is marked for the student with this id "+stid;
        }
        Attrecord attrecord = new Attrecord();
        attrecord.setClassSession(session);
        attrecord.setStatus(status);
        attrecord.setDate(LocalDate.now());
        attrecord.setStudent(student);
        attrecordRepository.save(attrecord);

        return "Attendance marked for this "+stid +" in the session "+sessionid;
    }

    public List<AttrecordDTO> getAttByid(Long id) {
        Student student = attrepository.findById(id).orElseThrow(() -> new RuntimeException("Student with this id is not recorded"));
        return student.getDailyrecord().stream().map(attrecord -> {
            AttrecordDTO dtoa = new AttrecordDTO();
            dtoa.setDate(attrecord.getDate());
            dtoa.setAttid(attrecord.getAttid());
            dtoa.setStatus(attrecord.getStatus());
            if(attrecord.getClassSession()!=null&&attrecord.getClassSession().getCourse()!=null){
                dtoa.setCoursename(attrecord.getClassSession().getCourse().getCoursename());
            }
            return dtoa;}).collect(Collectors.toList());
    }
}
