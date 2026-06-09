package com.example.demo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Service
public class Attservice {
    @Autowired
    private Attrepository attrepository;

    @Autowired
    private AttrecordRepository attrecordRepository;

    public Student register(Student student){
        return attrepository.save(student);
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

    public String markDailyAttendance(Long id,String status){
        Student student = attrepository.findById(id).orElseThrow(()-> new RuntimeException("Student with this id doesn't exist"));
        LocalDate today = LocalDate.now();
        boolean isMarked = student.getDailyrecord().stream().anyMatch(attrecord -> attrecord.getDate().equals(today));
        if(isMarked){
            return "Attendance for this student is already marked " + id;
        }
        Attrecord attrecord = new Attrecord();
        attrecord.setDate(today);
        attrecord.setStatus(status);
        attrecord.setStudent(student);
        attrecordRepository.save(attrecord);
        return "Attendance for this id is marked "+id;
    }

    public List<AttrecordDTO> getAttByid(Long id) {
        Student student = attrepository.findById(id).orElseThrow(() -> new RuntimeException("Student with this id is not recorded"));
        return student.getDailyrecord().stream().map(attrecord -> {
            AttrecordDTO dtoa = new AttrecordDTO();
            dtoa.setDate(attrecord.getDate());
            dtoa.setAttid(attrecord.getAttid());
            dtoa.setStatus(attrecord.getStatus());
            return dtoa;}).collect(Collectors.toList());
    }
}
