package com.example.controller;

import org.springframework.web.bind.annotation.*;

import com.example.entity.*;
import com.example.service.*;

import java.util.List;

/**
 * ApiController is a REST controller that handles HTTP requests for the application.
 * It provides endpoints for managing Medecins, Patients, Creneaux, and Rendez-vous (Rv).
 * The controller uses the service layer to perform CRUD operations on the entities.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private final MedecinService medecinService;
    private final PatientService patientService;
    private final CreneauService creneauService;
    private final RvService rvService;


    public ApiController(MedecinService medecinService, PatientService patientService, CreneauService creneauService, RvService rvService) {
        this.medecinService = medecinService;
        this.patientService = patientService;
        this.creneauService = creneauService;
        this.rvService = rvService;
    }

    @GetMapping("/medecins")
    public List<Medecin> getAllMedecins() {
        return medecinService.getAllMedecins();
    }

    @PostMapping("/medecins")
    public Medecin createMedecin(@RequestBody Medecin medecin) {
        return medecinService.createMedecin(medecin);
    }

    @PutMapping("/medecins/{id}")
    public Medecin updateMedecin(@PathVariable Long idMedecin, @RequestBody Medecin medecin) {
        medecin.setIdMedecin(idMedecin);
        return medecinService.updateMedecin(medecin);
    }

    @GetMapping("/medecins/{id}")
    public Medecin getMedecinById(@PathVariable Long idMedecin) {
        return medecinService.getMedecinById(idMedecin);
    }

    @DeleteMapping("/medecins/{id}")
    public void deleteMedecin(@PathVariable Long idMedecin) {
        medecinService.deleteMedecin(idMedecin);
    }


    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping("/patients")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/patients/{idPatient}")
    public Patient updatePatient(@PathVariable Long idPatient, @RequestBody Patient patient) {
        patient.setIdPatient(idPatient);
        return patientService.updatePatient(patient);
    }

    @GetMapping("/patients/{idPatient}")
    public Patient getPatientById(@PathVariable Long idPatient) {
        return patientService.getPatientById(idPatient);
    }

    @DeleteMapping("/patients/{idPatient}")
    public void deletePatient(@PathVariable Long idPatient) {
        patientService.deletePatient(idPatient);
    }

    // Endpoints pour Créneaux

    @GetMapping("/creneaux")
    public List<Creneaux> getAllCreneaux() {
        return creneauService.getAllCreneaux();
    }

    @PostMapping("/creneaux")
    public Creneaux createCreneau(@RequestBody Creneaux creneau) {
        return creneauService.createCreneau(creneau);
    }

    @PutMapping("/creneaux/{id}")
    public Creneaux updateCreneau(@PathVariable Long idCreneau, @RequestBody Creneaux creneau) {
        creneau.setIdCreneau(idCreneau);
        return creneauService.updateCreneau(creneau);
    }

    @GetMapping("/creneaux/{id}")
    public Creneaux getCreneauById(@PathVariable Long idCreneau) {
        return creneauService.getCreneauById(idCreneau);
    }

    @DeleteMapping("/creneaux/{id}")
    public void deleteCreneau(@PathVariable Long idCreneau) {
        creneauService.deleteCreneau(idCreneau);
    }

    // Endpoints pour Rendez-vous (Rv)

    @GetMapping("/rvs")
    public List<Rv> getAllRvs() {
        return rvService.getAllRvs();
    }

    @PostMapping("/rvs")
    public Rv createRv(@RequestBody Rv rv) {
        return rvService.createRv(rv);
    }

    @PutMapping("/rvs/{id}")
    public Rv updateRv(@PathVariable Long idRv, @RequestBody Rv rv) {
        rv.setIdRv(idRv);
        return rvService.updateRv(rv);
    }

    @GetMapping("/rvs/{id}")
    public Rv getRvById(@PathVariable Long idRv) {
        return rvService.getRvById(idRv);
    }

    @DeleteMapping("/rvs/{id}")
    public void deleteRv(@PathVariable Long idRv) {
        rvService.deleteRv(idRv);
    }

   
}

