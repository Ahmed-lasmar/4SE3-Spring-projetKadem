package com.example.demo.Service;

import com.example.demo.entities.DetailEquipe;
import com.example.demo.repository.DetailEquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeService {
    DetailEquipeRepository detailEquipeRepository;

    public List<DetailEquipe> retrieveAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    public DetailEquipe addDetailEquipe(DetailEquipe e) {
        return detailEquipeRepository.save(e);
    }

    public DetailEquipe updateDetailEquipe(DetailEquipe e) {
        return detailEquipeRepository.save(e);
    }

    public DetailEquipe retrieveDetailEquipe(Long idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).get();
    }

    public void deleteDetailEquipe(Long idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }
}
