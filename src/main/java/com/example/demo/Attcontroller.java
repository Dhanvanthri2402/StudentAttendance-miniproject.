package com.example.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;

@RestController
public class Attcontroller {

    @Autowired
    private Attservice attservice;
    @GetMapping("/read/{id}")
    public StudentDTO readstdetails(@PathVariable Long id){
        return attservice.getstatus(id);
    }

    @PostMapping("/reg")
    public Student registerdetails(@Valid @RequestBody Student newStudent){
        return attservice.register(newStudent);
    }

    @PutMapping("/updt/{id}")
    public Student updatedetails(@PathVariable Long id,@RequestBody Student nstudent){
        return attservice.uplocation(id,nstudent);
    }

    @DeleteMapping("/del/{id}")
    public String deletedetails(@PathVariable Long id){
        return attservice.delatt(id);
    }


}
