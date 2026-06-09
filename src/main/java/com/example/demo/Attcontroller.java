package com.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import java.util.List;

@RestController
public class Attcontroller {

    @Autowired
    private Attservice attservice;

    @GetMapping("/read/{id}")
    public StudentDTO readstdetails(@PathVariable Long id){ return attservice.getstatus(id); }

    @PostMapping("/reg")
    public Student registerdetails(@Valid @RequestBody Student newStudent){
        return attservice.register(newStudent);
    }

    @PutMapping("update/{id}")
    public String updatedetails(@PathVariable Long id,@RequestBody Student student){
        return attservice.updatestudent(id,student);
    }

    @PutMapping("updatests/{id}")
    public String updatestudentstatus(@PathVariable Long id, @RequestParam String status){
        return attservice.updatestatus(id,status);
    }

    @DeleteMapping("/del/{id}")
    public String deletedetails(@PathVariable Long id){
        return attservice.deletestudent(id);
    }

    @GetMapping("/r/status/{status}")
    public List<StudentDTO> Getstbystatus(@PathVariable String status){
        return attservice.getstudentbystatus(status);
    }


    @PostMapping("/regatt/{id}")
    public String markattendance(@PathVariable Long id, @RequestParam String status){
        return attservice.markDailyAttendance(id,status);
    }

    @GetMapping("readatt/{id}")
    public List<AttrecordDTO> getattrecordbyid(@PathVariable Long id){
        return attservice.getAttByid(id);
    }


}
