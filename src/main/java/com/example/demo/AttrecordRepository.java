package com.example.demo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface AttrecordRepository extends JpaRepository<Attrecord,Long> {

    List<Attrecord> findByDate(LocalDate date);


}
