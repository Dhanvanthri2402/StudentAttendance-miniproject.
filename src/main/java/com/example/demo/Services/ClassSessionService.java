package com.example.demo.Services;
import com.example.demo.Entities.ClassSession;
import com.example.demo.DTOS.ClassSessionDTO;
import com.example.demo.Entities.Course;
import com.example.demo.Repositories.ClassSessionRepository;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.ProfessorRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassSessionService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassSessionRepository classSessionRepository;

    public String newsession(Long courseid, ClassSessionDTO csdto) {
        Course course = courseRepository.findById(courseid).orElseThrow(()->new RuntimeException("Course id invalid"));
        ClassSession classSession = new ClassSession();
        classSession.setIsactive(false);
        classSession.setStatus("SCHEDULED");
        classSession.setSessionDate(csdto.getSessionDate());
        classSession.setStartTime(csdto.getStarttime());
        classSession.setEndTime(csdto.getEndtime());
        classSession.setCourse(course);
        classSessionRepository.save(classSession);
        return "New session is scheduled";
    }

    public List<ClassSessionDTO> getallsession() {
        List<ClassSession> allsessions = classSessionRepository.findAll();
        return allsessions.stream().map(session -> this.convertTosessiondto(session)).collect(Collectors.toList());
    }



    public ClassSessionDTO getSessionbyid(Long sessionid){
        ClassSession classSession = classSessionRepository.findById(sessionid).orElseThrow(()-> new RuntimeException("Session id Invalid"));
        return convertTosessiondto(classSession);
    }

    public ClassSessionDTO convertTosessiondto(ClassSession classSession){
        ClassSessionDTO csdto = new ClassSessionDTO();
        csdto.setSessionid(classSession.getSessionid());
        csdto.setStarttime(classSession.getStartTime());
        csdto.setEndtime(classSession.getEndTime());
        csdto.setSessionDate(classSession.getSessionDate());
        csdto.setActualstartTime(classSession.getActualstartTime());
        csdto.setStatus(classSession.getStatus());
        csdto.setActualendTime(classSession.getActualendTime());

        if(classSession.getCourse()!=null){
            csdto.setCoursename(classSession.getCourse().getCoursename());
            if(classSession.getCourse().getProfessor()!=null){
                csdto.setProfessorname(classSession.getCourse().getProfessor().getProfname());
            }
        }
        return csdto;
    }

    public String startSession(Long sessionid){
        ClassSession classSession = classSessionRepository.findById(sessionid).orElseThrow(()->new RuntimeException("Session id invalid"));
        if("ENDED".equals(classSession.getStatus())){
            throw new RuntimeException("cannot start the session which is already ended");
        }
        classSession.setIsactive(true);
        classSession.setActualstartTime(LocalTime.now());
        classSession.setStatus("LIVE");
        classSessionRepository.save(classSession);
        return "The session is active now";
    }

    public String endSession(Long sessionid){
        ClassSession classSession = classSessionRepository.findById(sessionid).orElseThrow(()->new RuntimeException("Session id invalid"));
        classSession.setIsactive(false);
        classSession.setActualendTime(LocalTime.now());
        classSession.setStatus("ENDED");
        classSessionRepository.save(classSession);
        return "The session was ended";
    }

    public String professorattendance(Long profid){
        long totalsessions = classSessionRepository.countByCourse_Professor_Profid(profid);
        long activesessions = classSessionRepository.countByCourse_Professor_ProfidAndActualstartTimeIsNotNull(profid);

        return "The professor had attended "+activesessions +" sessions out of "+ totalsessions+" sessions";
    }
}
