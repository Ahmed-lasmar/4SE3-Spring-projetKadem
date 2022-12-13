package com.example.demo.Service;

import com.example.demo.entities.Equipe;
import com.example.demo.repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
@AllArgsConstructor
public class EquipeService implements IEquipeService {

    EquipeRepository equipeRepository ;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {

        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return null;
    }


    public Equipe retrieveEquipe(Long idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    @Override
    public void deleteEquipe(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    @Scheduled(cron = "* * 1 * * *")
    public void faireEvoluerEquipes() {
        List<Equipe> equipes = equipeRepository.findAll();
        for (Equipe e :equipes){

        }

    }
}
