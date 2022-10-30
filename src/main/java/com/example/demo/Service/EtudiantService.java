package com.example.demo.Service;

import com.example.demo.entities.Etudiant;
import com.example.demo.repository.EtudiantRepository;

import java.util.List;

public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;
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
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public Void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
