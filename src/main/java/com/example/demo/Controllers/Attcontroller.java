package com.example.demo.Controllers;
import com.example.demo.DTOS.AttrecordDTO;
import com.example.demo.Services.Attservice;
import com.example.demo.Entities.Student;
import com.example.demo.DTOS.StudentDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class Attcontroller {

    @Autowired
    private Attservice attservice;

    @GetMapping("/read/{id}")
    public StudentDTO readstdetails(@PathVariable Long id){ return attservice.getstatus(id); }

    @PostMapping("/reg")
    public String registerdetails(@Valid @RequestBody Student newStudent){
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


    @PostMapping("/markatt/{id}")
    public String markattendanceforstudent(@PathVariable Long id,@RequestParam Long sessionid,@RequestParam String status){
        return attservice.markSessionAttendance(id,sessionid,status);
    }

    @GetMapping("readatt/{id}")
    public List<AttrecordDTO> getattrecordbyid(@PathVariable Long id){
        return attservice.getAttByid(id);
    }


}
