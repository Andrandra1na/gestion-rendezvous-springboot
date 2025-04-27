package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "creneaux")
public class Creneaux {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCreneau;

    @ManyToOne
    @JoinColumn(name = "idMedecin")
    private Medecin medecin;

    private LocalDateTime dateHeureDebut;

    private LocalDateTime dateHeureFin;

    @Enumerated(EnumType.STRING)
    private StatutCreneau statut;

    public enum StatutCreneau {
        DISPONIBLE,
        RESERVE
    }
    @OneToMany(mappedBy = "creneau", fetch = FetchType.LAZY)
    @JsonIgnore // Excludes rvs list from JSON serialization
    private List<Rv> rvs;
}
