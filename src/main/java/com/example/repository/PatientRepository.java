package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
