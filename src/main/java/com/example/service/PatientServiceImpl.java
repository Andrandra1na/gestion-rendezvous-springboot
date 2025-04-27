package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.*;
import com.example.repository.*;


import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Optional<Patient> existingPatient = patientRepository.findById(patient.getIdPatient());
        if (existingPatient.isPresent()) {
            return patientRepository.save(patient);
        } else {
            throw new RuntimeException("Patient not found with id " + patient.getIdPatient());
        }
    }

    @Override
    public Patient getPatientById(Long idPatient) {
        return patientRepository.findById(idPatient)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + idPatient));
    }

    @Override
    public void deletePatient(Long idPatient) {
        patientRepository.deleteById(idPatient);
    }

}
