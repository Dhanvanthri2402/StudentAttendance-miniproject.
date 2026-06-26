package com.example.demo.Controllers;
import java.util.List;

import com.example.demo.DTOS.ClassSessionDTO;
import com.example.demo.Services.ClassSessionService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/session")
public class ClassSessionController {

    @Autowired
    private ClassSessionService classSessionService;

    @GetMapping
    public List<ClassSessionDTO> getsessions(){
        return classSessionService.getallsession();
    }

    @GetMapping("/get/{id}")
    public ClassSessionDTO getsessionwithid(@PathVariable Long id){
        return classSessionService.getSessionbyid(id);
    }

    @PostMapping("/reg/{id}")
    public String createnewsession(@PathVariable Long id, @RequestBody ClassSessionDTO classSessionDTO){
        return classSessionService.newsession(id,classSessionDTO);
    }

    @PutMapping("/start/{id}")
    public String startns(@PathVariable Long id){
        return classSessionService.startSession(id);
    }

    @PutMapping("/end/{id}")
    public String endns(@PathVariable Long id){
        return classSessionService.endSession(id);
    }

    @GetMapping("/getpfatt/{id}")
    public String getprofatt(@PathVariable Long id){
        return classSessionService.professorattendance(id);
    }
}
