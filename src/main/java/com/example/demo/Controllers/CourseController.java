package com.example.demo.Controllers;
import com.example.demo.DTOS.CourseDTO;
import com.example.demo.Services.CourseService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;


@RestController
@RequestMapping("/Course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/getall")
    public List<CourseDTO> getall(){
        return courseService.getallcourses();
    }

    @GetMapping("/get/{courseid}")
    public CourseDTO getcoursewithid(@PathVariable Long courseid){
        return courseService.getCoursebyid(courseid);
    }

    @PutMapping("/update/{id}")
    public String updatecoursebyid(@PathVariable Long id,@RequestParam Long profid,@RequestBody CourseDTO courseDTO){
        return courseService.updateCourse(id,profid,courseDTO);
    }

    @PostMapping("/reg/{profid}")
    public String registernewcourse(@PathVariable Long profid,@RequestBody CourseDTO courseDTO){
        return courseService.createnewcourse(profid,courseDTO);
    }

    @PostMapping("/regst/{stid}")
    public String registerstudentforcourse(@PathVariable Long stid,@RequestParam Long courseid){
        return courseService.enrollstudents(stid,courseid);
    }

    @DeleteMapping("/del/{id}")
    public String deletecoursewithid(@PathVariable Long id){
        return courseService.deleteCourse(id);
    }

}
