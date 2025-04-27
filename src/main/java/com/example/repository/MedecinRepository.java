package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
