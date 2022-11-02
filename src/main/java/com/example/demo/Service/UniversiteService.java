package com.example.demo.Service;

import com.example.demo.entities.Universite;
import com.example.demo.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService {
    UniversiteRepository universiteRepository;

    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    public Universite addUniversite(Universite e) {
        return universiteRepository.save(e);
    }

    public Universite updateUniversite(Universite e) {
        return universiteRepository.save(e);
    }

    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    public void deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
}
