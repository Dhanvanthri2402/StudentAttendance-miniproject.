package com.example.demo.Repositories;
import com.example.demo.Entities.ClassSession;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClassSessionRepository extends JpaRepository<ClassSession,Long>{

    long countByCourse_Professor_Profid(Long profid);

    long countByCourse_Professor_ProfidAndActualstartTimeIsNotNull(Long profid);
}
