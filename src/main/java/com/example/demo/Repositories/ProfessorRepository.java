package com.example.demo.Repositories;
import com.example.demo.Entities.Professor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long>{

}
