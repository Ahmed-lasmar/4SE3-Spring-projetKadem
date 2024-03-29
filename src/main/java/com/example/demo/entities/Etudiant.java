package com.example.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEtudiant")
    private Long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;
    @ManyToOne(cascade = CascadeType.ALL)
    Departement departement;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Equipe> equipes;
 // Constructeur et accesseurs (getters) et mutateurs (setters)
}