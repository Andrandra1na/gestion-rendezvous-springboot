package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Creneaux;
import com.example.entity.Rv;

public interface RvRepository extends JpaRepository<Rv, Long> {

    static boolean existsByCreneau(Creneaux creneau) {
        throw new UnsupportedOperationException("Unimplemented method 'existsByCreneau'");
    }
}
