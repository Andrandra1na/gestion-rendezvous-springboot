package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Creneaux;

/**
 * CreneauxRepository is an interface that extends JpaRepository to provide CRUD operations for Creneaux entities.
 * It allows for easy interaction with the database without the need for boilerplate code.
 */
public interface CreneauxRepository extends JpaRepository<Creneaux, Long> {
}
