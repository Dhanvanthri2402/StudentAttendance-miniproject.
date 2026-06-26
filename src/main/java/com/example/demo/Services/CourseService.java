package com.example.demo.Services;
import com.example.demo.Entities.Course;
import com.example.demo.DTOS.CourseDTO;
import com.example.demo.Entities.Professor;
import com.example.demo.Repositories.Attrepository;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.ProfessorRepository;
import com.example.demo.Entities.Student;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private Attrepository attrepository;

    public String enrollstudents(Long stid,Long courseid){
        Student student = attrepository.findById(stid).orElseThrow(()-> new RuntimeException("Student id invalid"));
        Course course = courseRepository.findById(courseid).orElseThrow(()-> new RuntimeException("Course id invalid"));
        course.getEnrolledstudents().add(student);
        Course courseupdate = courseRepository.save(course);
        return "The student is added for the course successfully";
    }

    public CourseDTO convertcoursedto(Course course){
        CourseDTO cdto = new CourseDTO();
        cdto.setCourseid(course.getCourseid());
        cdto.setCoursename(course.getCoursename());
        if(course.getProfessor()!=null){
            cdto.setProfessorname(course.getProfessor().getProfname());
        }
        if(course.getEnrolledstudents()!=null) {
            List<String> enrolledsts = course.getEnrolledstudents().stream().map(student -> student.getName()).collect(Collectors.toList());
            cdto.setStudentsenrolled(enrolledsts);
        }
        return cdto;
    }

    public String createnewcourse(Long profid,CourseDTO coursedto){
        Professor professor = professorRepository.findById(profid).orElseThrow(()-> new RuntimeException("Professor id invalid"));
        Course course = new Course();
        course.setCoursename(coursedto.getCoursename());
        course.setProfessor(professor);
        Course savecourse= courseRepository.save(course);
        return "The new course is created according to the details";
    }

    public List<CourseDTO> getallcourses(){
        List<Course> allcourses= courseRepository.findAll();
        return allcourses.stream().map(course->this.convertcoursedto(course)).collect(Collectors.toList());
    }

    public String deleteCourse(Long courseid){
        courseRepository.deleteById(courseid);
        return "The with the provided id is deleted";
    }

    public CourseDTO getCoursebyid(Long courseid){
        Course course = courseRepository.findById(courseid).orElseThrow(()-> new RuntimeException("Course id invalid"));
       return convertcoursedto(course);
    }

    public String updateCourse(Long courseid,Long profid,CourseDTO coursedto){
        Course course1 = courseRepository.findById(courseid).orElseThrow(()->new RuntimeException("Course id invalid"));
        course1.setCoursename(coursedto.getCoursename());
        if(profid!=null) {
            Professor professor = professorRepository.findById(profid).orElseThrow(() -> new RuntimeException("Professor id invalid"));
            course1.setProfessor(professor);
        }
        Course updatedcourse= courseRepository.save(course1);
        return "Course details are updated";
    }
}
