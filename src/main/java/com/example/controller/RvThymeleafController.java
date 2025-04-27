package com.example.controller;

import com.example.entity.Rv;
import com.example.exception.CreneauIndisponibleException;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rv")
public class RvThymeleafController {

    @Autowired
    private RvService rvService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private MedecinService medecinService;

    @Autowired
    private CreneauService creneauService;

    @GetMapping
    public String getAllRvs(Model model) {
        List<Rv> rvs = rvService.getAllRvs();
        model.addAttribute("rv", rvs);
        return "rv";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("rv", new Rv());
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("medecins", medecinService.getAllMedecins());
        model.addAttribute("creneaux", creneauService.getAllCreneaux());
        return "/ajout/ajout-rv";
    }

    @PostMapping("/add")
    public String createRv(@ModelAttribute Rv newRv, Model model) {
        try {
            rvService.createRv(newRv);
            return "success"; // Redirect to a success page
        } catch (CreneauIndisponibleException e) {
        model.addAttribute("errorMessage", e.getMessage());
            return "createRv"; // Re-render the form with error message
    }
}

    @GetMapping("/edit/{idRv}")
    public String showEditForm(@PathVariable Long idRv, Model model) {
        Rv rv = rvService.getRvById(idRv);
        model.addAttribute("rv", rv);
        model.addAttribute("patients", patientService.getAllPatients());
        model.addAttribute("creneaux", creneauService.getAllCreneaux());
        return "modification/edit-rv";
    }

    @PostMapping("/edit/{idRv}")
    public String updateRv(@PathVariable Long idRv, @ModelAttribute Rv rv) {
        rv.setIdRv(idRv);
        rvService.updateRv(rv);
        return "redirect:/rv";
    }
    @GetMapping("/delete/{idRv}")
    public String deleteRv(@PathVariable Long idRv) {
        rvService.deleteRv(idRv);
        return "redirect:/rv";
    }
}

