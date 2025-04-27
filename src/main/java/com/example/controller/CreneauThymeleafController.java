package com.example.controller;

import com.example.entity.Creneaux;
import com.example.entity.Creneaux.StatutCreneau;
import com.example.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/creneaux")
public class CreneauThymeleafController {

    private final CreneauService creneauService;
    private final MedecinService medecinService;

    public CreneauThymeleafController(CreneauService creneauService, MedecinService medecinService) {
        this.creneauService = creneauService;
        this.medecinService = medecinService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping
    public String getAllCreneaux(Model model) {
        List<Creneaux> creneaux = creneauService.getAllCreneaux();
        model.addAttribute("creneaux", creneaux);
        return "creneaux";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("creneau", new Creneaux());
        model.addAttribute("medecins", medecinService.getAllMedecins());
        model.addAttribute("statuts", StatutCreneau.values());
        return "/ajout/ajout-creneau";
    }

    @PostMapping("/add")
    public String createCreneau(@ModelAttribute Creneaux creneau) {
        creneauService.createCreneau(creneau);
        return "redirect:/creneaux";
    }

    @GetMapping("/edit/{idCreneau}")
    public String showEditForm(@PathVariable Long idCreneau, Model model) {
        Creneaux creneau = creneauService.getCreneauById(idCreneau);
        model.addAttribute("creneau", creneau);
        model.addAttribute("medecins", medecinService.getAllMedecins());
        model.addAttribute("statuts", StatutCreneau.values());
        return "modification/edit-creneau";
    }

    @PostMapping("/edit/{idCreneau}")
    public String updateCreneau(@PathVariable Long idCreneau, @ModelAttribute Creneaux creneau) {
        creneau.setIdCreneau(idCreneau);
        creneauService.updateCreneau(creneau);
        return "redirect:/creneaux";
    }

    @GetMapping("/delete/{idCreneau}")
    public String deleteCreneau(@PathVariable Long idCreneau) {
        creneauService.deleteCreneau(idCreneau);
        return "redirect:/creneaux";
    }
}
