package com.example.controller;

import com.example.entity.Medecin;
import com.example.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medecins")
public class MedecinThymeleafController {

    @Autowired
    private MedecinService medecinService;

    @GetMapping
    public String getAllMedecins(Model model) {
        List<Medecin> medecins = medecinService.getAllMedecins();
        model.addAttribute("medecins", medecins);
        return "medecins";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("medecin", new Medecin());
        return "/ajout/ajout-medecin";
    }

    @PostMapping("/add")
    public String createMedecin(@ModelAttribute Medecin medecin) {
        medecinService.createMedecin(medecin);
        return "redirect:/medecins";
    }

    @GetMapping("/edit/{idMedecin}")
    public String showEditForm(@PathVariable Long idMedecin, Model model) {
        Medecin medecin = medecinService.getMedecinById(idMedecin);
        model.addAttribute("medecin", medecin);
        return "/modification/edit-medecin";
    }

    @PostMapping("/edit/{idMedecin}")
    public String updateMedecin(@PathVariable Long idMedecin, @ModelAttribute Medecin medecin) {
        medecin.setIdMedecin(idMedecin);
        medecinService.updateMedecin(medecin);
        return "redirect:/medecins";
    }

    @GetMapping("/delete/{idMedecin}")
    public String deleteMedecin(@PathVariable Long idMedecin) {
        medecinService.deleteMedecin(idMedecin);
        return "redirect:/medecins";
    }
}
