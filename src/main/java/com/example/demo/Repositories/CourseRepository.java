package com.example.demo.Repositories;
import com.example.demo.Entities.Course;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>{
}


