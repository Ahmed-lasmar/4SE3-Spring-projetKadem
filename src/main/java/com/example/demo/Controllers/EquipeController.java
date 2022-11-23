package com.example.demo.Controllers;

import com.example.demo.Service.EquipeService;
import com.example.demo.entities.Equipe;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Equipe")
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {
 EquipeService equipeService;

    // http://localhost:8089/Kaddem/equipe/retrieve-all-equipes
    @Operation(description = "Retrieve all Equipes")
    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/equipe/retrieve-equipe/8
    @Operation(description = "Retrieve Equipe by ID")
    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer equipeId) {
        Equipe e= equipeService.retrieveEquipe(equipeId);
        return e;
    }

    // http://localhost:8089/Kaddem/equipe/remove-equipe/1
    @Operation(description = "Remove Equipe by ID")
    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeOperateur(@PathVariable("equipe-id") Long equipeId) {
        equipeService.deleteEquipe(equipeId);
    }

    // http://localhost:8089/Kaddem/equipe/add-equipe
    @Operation(description = "add Equipe")
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe e) {
        Equipe equipe = equipeService.addEquipe(e);
        return equipe;
    }

    // http://localhost:8089/Kaddem/equipe/update-equipe
    @Operation(description = "update Equipe")
    @PutMapping("/update-equipe")
    public Equipe updateEtudiant(@RequestBody Equipe e) {
        Equipe equipe= equipeService.updateEquipe(e);
        return equipe;
    }



}




