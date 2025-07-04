package com.miracle.vjobs.repository;

import com.miracle.vjobs.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    List<Employer> findAllByPosition(String position);
}
