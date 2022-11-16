package com.example.demo.Service;


import com.example.demo.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiant();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant (Integer idEtudiant);

    void deleteEtudiant(Long idEtudiant);


    Etudiant assignEtudiantToDepartement (Long etudiantId, Long departementId) ;

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat,Long idEquipe);

}
