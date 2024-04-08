package com.example.assignmentdemo.repository;

import com.example.assignmentdemo.entity.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
}
