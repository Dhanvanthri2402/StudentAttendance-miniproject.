package com.example.demo.Repositories;
import com.example.demo.Entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface Attrepository extends JpaRepository<Student,Long>{

    List<Student> findByStatus(String status);


}
