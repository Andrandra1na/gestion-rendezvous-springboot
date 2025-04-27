package com.example.service;


import java.util.List;
import com.example.entity.Patient;


public interface PatientService {
    List<Patient> getAllPatients();
    Patient createPatient(Patient patient);
    Patient updatePatient(Patient patient);
    Patient getPatientById(Long idPatient);
    void deletePatient(Long idPatient);
}


