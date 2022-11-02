package com.example.demo.Service;

import com.example.demo.entities.Departement;
import com.example.demo.repository.DepartementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartementService {
    DepartementRepository departementRepository;

    public List<Departement> retrieveAllDepartement() {
        return departementRepository.findAll();
    }

    public Departement addDepartement(Departement e) {
        return departementRepository.save(e);
    }

    public Departement updateDepartement(Departement e) {
        return departementRepository.save(e);
    }

    public Departement retrieveDepartement(Long idDepartement) {
        return departementRepository.findById(idDepartement).get();
    }

    public void deleteDepartement(Long idDepartement) {
        departementRepository.deleteById(idDepartement);
    }
}
