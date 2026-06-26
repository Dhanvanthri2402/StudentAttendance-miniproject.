package com.example.demo.Services;
import java.util.List;

import com.example.demo.Entities.Professor;
import com.example.demo.DTOS.ProfessorDTO;
import com.example.demo.Repositories.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public String registerprofessor(Professor professor){
        professorRepository.save(professor);
        return "Details of the professor registered Sucessfully";
    }

    public List<ProfessorDTO> getAllProfessors() {
        List<Professor> professors = professorRepository.findAll();
        return professors.stream().map(professor -> {
            ProfessorDTO pdto = new ProfessorDTO();
            pdto.setProfname(professor.getProfname());
            pdto.setProfdepartment(professor.getProfdepartment());
            pdto.setProfessorid(professor.getProfid());
            if(professor.getCourses()!=null){
                List<String> professorcourses = professor.getCourses().stream().map(Course -> Course.getCoursename()).collect(Collectors.toList());
                pdto.setCoursesteached(professorcourses);}
                return pdto;
        }).collect(Collectors.toList());
    }

    public ProfessorDTO getprofessorbyid(Long id) {
        Professor professor = professorRepository.findById(id).orElseThrow(()->new RuntimeException("Professor with this id not found"));
        ProfessorDTO pdto = new ProfessorDTO();
        pdto.setProfname(professor.getProfname());
        pdto.setProfessorid(professor.getProfid());
        pdto.setProfdepartment(professor.getProfdepartment());
        if(professor.getCourses()!=null){
            List<String> profcourses = professor.getCourses().stream().map(course->course.getCoursename()).collect(Collectors.toList());
            pdto.setCoursesteached(profcourses);
        }
        return pdto;
    }

    public String Updateprofessordetails(Long id,String name,String department) {
        Professor professor = professorRepository.findById(id).orElseThrow(() -> new RuntimeException("Professor with this id cannot be found"));
        professor.setProfname(name);
        professor.setProfdepartment(department);
        professorRepository.save(professor);
        return "Professor details are updated sucessfully";
    }

    public String Deleteprofessordetails(Long id){
        Professor professor = professorRepository.findById(id).orElseThrow(()->new RuntimeException("Professor with this id cannot be found"));
        professorRepository.delete(professor);
        return "Professor details for this id is sucessfully deleted";
    }
}
