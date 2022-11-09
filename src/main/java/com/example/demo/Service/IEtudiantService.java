package com.example.demo.Service;


import com.example.demo.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiant();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant (Integer idEtudiant);

    Void deleteEtudiant(Long idEtudiant);


    public Etudiant assignEtudiantToDepartement (Long etudiantId, Long departementId) ;
}
