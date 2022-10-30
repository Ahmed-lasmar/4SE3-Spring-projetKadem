package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name= "DetailEquipe")
public class DetailEquipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailEquipe")
    private Long idDetailEquipe;
    private Integer salle;
    private String thematique;
    @OneToOne(mappedBy="DetailEquipe")
    private Equipe equipe;
}
