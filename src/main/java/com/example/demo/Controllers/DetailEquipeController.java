package com.example.demo.Controllers;

import com.example.demo.Service.DetailEquipeService;
import com.example.demo.entities.DetailEquipe;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/DetailEquipe")
public class DetailEquipeController {
    DetailEquipeService detailEquipeService;

    // http://localhost:8089/Kaddem/detailEquipe/retrieve-all-detailEquipes
    @GetMapping("/retrieve-all-detailEquipes")
    public List<DetailEquipe> getDetailEquipe() {
        List<DetailEquipe> listEquipes = detailEquipeService.retrieveAllDetailEquipe();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/detailEquipe/retrieve-detailEquipe/8
    @GetMapping("/retrieve-detailEquipe/{detailEquipe-id}")
    public DetailEquipe retrieveDetailEquipe(@PathVariable("detailEquipe-id") Long detailEquipeId) {
        return detailEquipeService.retrieveDetailEquipe(detailEquipeId);
    }

    // http://localhost:8089/Kaddem/detailEquipe/remove-detailEquipe/1
    @DeleteMapping("/remove-detailEquipe/{detailEquipe-id}")
    public void removeDetailEquipe(@PathVariable("detailEquipe-id") Long detailEquipeId) {
        detailEquipeService.deleteDetailEquipe(detailEquipeId);
    }

    // http://localhost:8089/kaddem/detailEquipe/add-detailEquipe
    @PostMapping("/add-detailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e) {
        DetailEquipe detailEquipe = detailEquipeService.addDetailEquipe(e);
        return detailEquipe;
    }

    // http://localhost:8089/kaddem/detailEquipe/update-detailEquipe
    @PutMapping("/update-detailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe e) {
        DetailEquipe detailEquipe= detailEquipeService.updateDetailEquipe(e);
        return detailEquipe;
    }
}
