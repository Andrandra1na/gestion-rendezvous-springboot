package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.*;
import com.example.exception.CreneauIndisponibleException;
import com.example.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class RvServiceImpl implements RvService {

    @Autowired
    private final RvRepository rvRepository;

    @Autowired
    private CreneauxRepository creneauRepository;

    public RvServiceImpl(RvRepository rvRepository) {
        this.rvRepository = rvRepository;
    }

    @Override
    public List<Rv> getAllRvs() {
        return rvRepository.findAll();
    }

    @Transactional
    @Override
  public Rv createRv(Rv newRv) { // Remove Model parameter
    // Retrieve the creneau and check if it exists
    Long creneauId = newRv.getCreneau().getIdCreneau();
    Optional<Creneaux> existingCreneau = creneauRepository.findById(creneauId);

    // Handle creneau non-existence by returning null
    if (!existingCreneau.isPresent()) {
    return null;
    }

    // Check creneau availability
    Creneaux creneau = existingCreneau.get();
    if (creneau.getStatut() != Creneaux.StatutCreneau.DISPONIBLE) {
      // Handle unavailable creneau (throw exception or log error)
      throw new CreneauIndisponibleException("Le creneau est déjà réservé.");  // Throw custom exception
    }
    // Update creneau status and save
    creneau.setStatut(Creneaux.StatutCreneau.RESERVE);
    creneauRepository.save(creneau);

    // Create and save the appointment
    Rv createdRv = rvRepository.save(newRv);
    return createdRv;
}

    @Override
    public Rv updateRv(Rv rv) {
        Optional<Rv> existingRv = rvRepository.findById(rv.getIdRv());
        if (existingRv.isPresent()) {
            return rvRepository.save(rv);
        } else {
            throw new RuntimeException("Rv not found with id " + rv.getIdRv());
        }
    }

    @Override
    public Rv getRvById(Long idRv) {
        return rvRepository.findById(idRv)
                .orElseThrow(() -> new RuntimeException("Rv not found with id " + idRv));
    }

    @Override
    public void deleteRv(Long idRv) {
        rvRepository.deleteById(idRv);
    }

    @Override
    public boolean existsByCreneau(Creneaux creneau) {
        return RvRepository.existsByCreneau(creneau);
    }

}
