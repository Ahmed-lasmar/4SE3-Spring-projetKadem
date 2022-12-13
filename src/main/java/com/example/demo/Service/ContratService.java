package com.example.demo.Service;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Etudiant;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@EnableScheduling
@AllArgsConstructor
@Slf4j
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

    @Override
    @Scheduled(cron = "* * 13 * * *")
    public void retrieveAndUpdateStatusContrat(){
        List<Contrat> contrats=contratRepository.findAll();
        List<Contrat> finalContrats=new ArrayList<>();
        log.info("bch yverifi el date de contrat");
        for (Contrat x :contrats) {
            Date utilDate = new java.util.Date(x.getDateFinContrat().getTime());
            Instant current = utilDate.toInstant();
            LocalDateTime ldt = LocalDateTime.ofInstant(current, ZoneId.systemDefault());
            Long var = Duration.between((Temporal) LocalDateTime.now(), (Temporal) ldt).toDays();
            //log.info("diff est :" + var);
            if (0<var && var < 16) {
                log.info("diff est :" + var + " de ett :" + x.getIdContrat());
                log.info("le contrat :"+x.getIdContrat().toString()+" de date de fin :"+x.getDateFinContrat().toString()+" prévue pour les 15 prochains jours de specialite :"+x.getSpecialite().toString()+" de l'etudiant :"+x.getEtudiant().getPrenomE().toString());
            }
            if (var == 0) {
                log.info("diff est :" + var + " de ett :" + x.getIdContrat());
                x.setArchive(true);
                contratRepository.save(x);
                log.info("le contrat :"+x.getIdContrat().toString()+" de date de fin :"+x.getDateFinContrat().toString()+" de l'etudiant :"+x.getEtudiant().toString()+" est archiver");
            }
        }
    }
}
