package com.example.demo.Service;

import com.example.demo.entities.Contrat;
import com.example.demo.repository.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratService {
    ContratRepository contratRepository;

    public List<Contrat> retrieveAllContrat() {
        return contratRepository.findAll();
    }

    public Contrat addContrat(Contrat e) {
        return contratRepository.save(e);
    }

    public Contrat updateContrat(Contrat e) {
        return contratRepository.save(e);
    }

    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    public void deleteContrat(Long idContrat) {
        contratRepository.deleteById(idContrat);
    }
}
