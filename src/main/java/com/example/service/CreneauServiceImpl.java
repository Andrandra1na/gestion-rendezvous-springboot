package com.example.service;


import org.springframework.stereotype.Service;
import com.example.entity.Creneaux;
import com.example.repository.CreneauxRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CreneauServiceImpl implements CreneauService {

    private final CreneauxRepository creneauRepository;

    public CreneauServiceImpl(CreneauxRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }

    @Override
    public List<Creneaux> getAllCreneaux() {
        return creneauRepository.findAll();
    }

    @Override
    public Creneaux createCreneau(Creneaux creneau) {
        return creneauRepository.save(creneau);
    }

    @Override
    public Creneaux updateCreneau(Creneaux creneau) {
        Optional<Creneaux> existingCreneau = creneauRepository.findById(creneau.getIdCreneau());
        if (existingCreneau.isPresent()) {
            return creneauRepository.save(creneau);
        } else {
            throw new RuntimeException("Creneau not found with id " + creneau.getIdCreneau());
        }
    }

    @Override
    public Creneaux getCreneauById(Long idCreneau) {
        return creneauRepository.findById(idCreneau)
                .orElseThrow(() -> new RuntimeException("Creneau not found with id " + idCreneau));
    }

    @Override
    public void deleteCreneau(Long idCreneau) {
        creneauRepository.deleteById(idCreneau);
    }

}
