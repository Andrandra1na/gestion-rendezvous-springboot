package com.example.service;

import java.util.List;

import com.example.entity.Creneaux;

/**
 * CreneauService is an interface that defines the contract for the Creneau service layer.
 * It provides methods to perform CRUD operations on Creneaux entities.
 */
public interface CreneauService {
    List<Creneaux> getAllCreneaux();
    Creneaux createCreneau(Creneaux creneau);
    Creneaux updateCreneau(Creneaux creneau);
    Creneaux getCreneauById(Long idCreneau);
    void deleteCreneau(Long idCreneau);
    
}

