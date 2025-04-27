package com.example.service;


import com.example.entity.Medecin;
import com.example.repository.MedecinRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinServiceImpl implements MedecinService {

    private final MedecinRepository medecinRepository;

    public MedecinServiceImpl(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin createMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin updateMedecin(Medecin medecin) {
        Optional<Medecin> existingMedecin = medecinRepository.findById(medecin.getIdMedecin());
        if (existingMedecin.isPresent()) {
            return medecinRepository.save(medecin);
        } else {
            throw new RuntimeException("Medecin not found with id " + medecin.getIdMedecin());
        }
    }

    @Override
    public Medecin getMedecinById(Long idMedecin) {
        return medecinRepository.findById(idMedecin)
                .orElseThrow(() -> new RuntimeException("Medecin not found with id " + idMedecin));
    }

    @Override
    public void deleteMedecin(Long idMedecin) {
        medecinRepository.deleteById(idMedecin);
    }

}




