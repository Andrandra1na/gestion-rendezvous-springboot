package com.example.service;

import java.util.List;

import com.example.entity.Creneaux;

public interface CreneauService {
    List<Creneaux> getAllCreneaux();
    Creneaux createCreneau(Creneaux creneau);
    Creneaux updateCreneau(Creneaux creneau);
    Creneaux getCreneauById(Long idCreneau);
    void deleteCreneau(Long idCreneau);
    
}

