package com.example.demo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface Attrepository extends JpaRepository<Student,Long>{

    List<Student> findByStatus(String status);

    List<Student> findByLocation(String location);


}
