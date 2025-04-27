package com.example.controller;

import com.example.entity.Patient;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/patients")
public class PatientThymeleafController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public String getAllPatients(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "/ajout/ajout-patient";
    }

    @PostMapping("/add")
    public String createPatient(@ModelAttribute Patient patient) {
        patientService.createPatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{idPatient}")
    public String showEditForm(@PathVariable Long idPatient, Model model) {
        Patient patient = patientService.getPatientById(idPatient);
        model.addAttribute("patient", patient);
        return "/modification/edit-patient";
    }

    @PostMapping("/edit/{idPatient}")
    public String updatePatient(@PathVariable Long idPatient, @ModelAttribute Patient patient) {
        patient.setIdPatient(idPatient);
        patientService.updatePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{idPatient}")
    public String deletePatient(@PathVariable Long idPatient) {
        patientService.deletePatient(idPatient);
        return "redirect:/patients";
    }
}
