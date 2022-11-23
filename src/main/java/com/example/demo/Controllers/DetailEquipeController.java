package com.example.demo.Controllers;

import com.example.demo.Service.DetailEquipeService;
import com.example.demo.entities.DetailEquipe;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Detail Equipe")
@RestController
@AllArgsConstructor
@RequestMapping("/DetailEquipe")
public class DetailEquipeController {
    DetailEquipeService detailEquipeService;

    // http://localhost:8089/Kaddem/DetailEquipe/retrieve-all-detailEquipes
    @Operation(description = "Retrieve all Detail Equipe")
    @GetMapping("/retrieve-all-detailEquipes")
    public List<DetailEquipe> getDetailEquipe() {
        List<DetailEquipe> listEquipes = detailEquipeService.retrieveAllDetailEquipe();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/DetailEquipe/retrieve-detailEquipe/8
    @Operation(description = "Retrieve Detail Equipe by ID")
    @GetMapping("/retrieve-detailEquipe/{detailEquipe-id}")
    public DetailEquipe retrieveDetailEquipe(@PathVariable("detailEquipe-id") Long detailEquipeId) {
        return detailEquipeService.retrieveDetailEquipe(detailEquipeId);
    }

    // http://localhost:8089/Kaddem/DetailEquipe/remove-detailEquipe/1
    @Operation(description = "Remove Detail Equipe by ID")
    @DeleteMapping("/remove-detailEquipe/{detailEquipe-id}")
    public void removeDetailEquipe(@PathVariable("detailEquipe-id") Long detailEquipeId) {
        detailEquipeService.deleteDetailEquipe(detailEquipeId);
    }

    // http://localhost:8089/Kaddem/DetailEquipe/add-detailEquipe
    @Operation(description = "add Detail Equipe")
    @PostMapping("/add-detailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe e) {
        DetailEquipe detailEquipe = detailEquipeService.addDetailEquipe(e);
        return detailEquipe;
    }

    // http://localhost:8089/Kaddem/DetailEquipe/update-detailEquipe
    @Operation(description = "update Detail Equipe")
    @PutMapping("/update-detailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe e) {
        DetailEquipe detailEquipe= detailEquipeService.updateDetailEquipe(e);
        return detailEquipe;
    }
}
