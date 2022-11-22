package com.example.demo.Service;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Departement;
import com.example.demo.entities.Equipe;
import com.example.demo.entities.Etudiant;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.EquipeRepository;
import com.example.demo.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    DepartementRepository departemenRepository;
    ContratRepository contratRepository;
    EquipeRepository equipeRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return null;
    }


    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant assignEtudiantToDepartement(Long etudiantId, Long departementId) {
        Etudiant et =etudiantRepository.findById(etudiantId).get();
        Departement de =departemenRepository.findById(departementId).get();
        et.setDepartement(de);
        etudiantRepository.save(et);
        return et;
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Long idContrat, Long idEquipe) {
        Contrat cn = contratRepository.findById(idContrat).get();
        Equipe eq = equipeRepository.findById(idEquipe).get();
        e.getEquipes().add(eq);
        e.getContrats().add(cn);
        etudiantRepository.save(e);
        return e;
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
    List<Etudiant> et = Collections.singletonList(etudiantRepository.retrieveEtudiantPardepartement(idDepartement));
        return et;
    }
}
