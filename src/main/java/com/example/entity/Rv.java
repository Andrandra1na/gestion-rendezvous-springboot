package com.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rv")
public class Rv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRv;

    @ManyToOne 
    @JoinColumn(name = "idPatient")
    private Patient patient; 

    @ManyToOne 
    @JoinColumn(name = "idCreneau")
    private Creneaux creneau;

    private LocalDateTime dateHeureCreation;

    @Override
    public String toString() {
        return "Rv{" +
                "idRv=" + idRv +
                ", patient=" + patient +
                ", dateHeureCreation=" + dateHeureCreation +
                '}';
    }
    
}

