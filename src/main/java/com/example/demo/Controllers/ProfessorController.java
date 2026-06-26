package com.example.demo.Controllers;
import com.example.demo.Services.ClassSessionService;
import com.example.demo.Entities.Professor;
import com.example.demo.DTOS.ProfessorDTO;
import com.example.demo.Services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/prof")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ClassSessionService classSessionService;

    @GetMapping("/getall")
    public List<ProfessorDTO> getprofessors(){
       return professorService.getAllProfessors();
    }

    @PostMapping("/reg")
    public String regprofessor(@RequestBody Professor professor){
        return professorService.registerprofessor(professor);
    }

    @GetMapping("/get/{profid}")
    public ProfessorDTO getprofbyid(@PathVariable Long profid){
        return professorService.getprofessorbyid(profid);
    }

    @PutMapping("/update/{id}")
    public String updateprofbyid(@PathVariable Long id,@RequestParam String name,@RequestParam String department){
        return professorService.Updateprofessordetails(id,name,department);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteprofbyid(@PathVariable Long id){
        return professorService.Deleteprofessordetails(id);
    }

}
