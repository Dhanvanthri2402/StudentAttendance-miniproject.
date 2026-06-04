package com.example.demo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

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

}
