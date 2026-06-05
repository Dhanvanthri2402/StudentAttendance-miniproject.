package com.example.demo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Attservice {
    @Autowired
    private Attrepository attrepository;

    public Student register(Student student){
        if(student.getLocation().equals("in")){
            student.setStatus("Attended");
        }
        else{
            student.setStatus("Not Attended");
        }

        return attrepository.save(student);
    }

    public StudentDTO getstatus(Long id){
       Student stentity = attrepository.findById(id).orElseThrow(()-> new RuntimeException("Student with this id cannot be found "));

       StudentDTO sdto = new StudentDTO();
       sdto.setName(stentity.getName());
       sdto.setStatus(stentity.getStatus());

       return sdto;
    }

    public Student uplocation(Long id, Student upstudent){
        Student estudent = attrepository.findById(id).orElseThrow(()-> new RuntimeException("cannot update"));
        estudent.setName(upstudent.getName());
        estudent.setAge(upstudent.getAge());
        estudent.setLocation(upstudent.getLocation());
        if(estudent.getLocation().equals("in")){
            estudent.setStatus("Attended");
        }
        else{
            estudent.setStatus("Not Attended");
        }

        return attrepository.save(estudent);


    }

    public String delatt(Long id){
        attrepository.deleteById(id);
        return "Student Att and id is deleted";
    }

    public List<StudentDTO> getstudentbystatus(String status){

        List<Student> rawentity = attrepository.findByStatus(status);

        return rawentity.stream().map(Student-> {
            StudentDTO dto = new StudentDTO();
            dto.setStatus(Student.getStatus());
            dto.setName(Student.getName());
            return dto;
        }

        ).collect(Collectors.toList());
    }

    public List<StudentDTO> getstudentbylocation(String location){
        List<Student> rentity = attrepository.findByLocation(location);

        return rentity.stream().map(Student -> {
            StudentDTO dtol = new StudentDTO();
            dtol.setName(Student.getName());
            dtol.setLocation(Student.getLocation());
            dtol.setStatus(Student.getStatus());

            return dtol;
        }).collect(Collectors.toList());
    }



}
