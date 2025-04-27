package com.example.service;

import java.util.List;

import com.example.entity.Medecin;

public interface MedecinService {

    List<Medecin> getAllMedecins();

    Medecin getMedecinById(Long idMedecin);

    Medecin createMedecin(Medecin medecin);

    Medecin updateMedecin(Medecin medecin);

    void deleteMedecin(Long idMedecin);

}
