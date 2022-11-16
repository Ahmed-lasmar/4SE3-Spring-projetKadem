package com.example.demo.Service;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Etudiant;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

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

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = etudiantRepository.retrieveEtudiantParNom(nomE,prenomE);

        if(e.getContrats().size()>5) {
            System.out.println("superieur a 5");
            return null;
        }
        else {
            System.out.println("else");

            Contrat cc = contratRepository.save(ce);
            cc.setEtudiant(e);
            contratRepository.save(cc);
            return cc;
        }
    }
}
