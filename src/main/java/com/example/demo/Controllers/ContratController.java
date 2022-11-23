package com.example.demo.Controllers;

import com.example.demo.Service.ContratService;
import com.example.demo.entities.Contrat;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Contrat")
@RestController
@AllArgsConstructor
@RequestMapping("/Contrat")
public class ContratController {
    ContratService contratService;

    // http://localhost:8089/Kaddem/Contrat/retrieve-all-contrats
    @Operation(description = "Retrieve all Contarts")
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getContrat() {
        List<Contrat> listEquipes = contratService.retrieveAllContrat();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/Contrat/retrieve-contrat/8
    @Operation(description = "Retrieve Contrat by ID")
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        return contratService.retrieveContrat(contratId);
    }

    // http://localhost:8089/Kaddem/Contrat/remove-contrat/1
    @Operation(description = "Remove Contrat by ID")
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.deleteContrat(contratId);
    }

    // http://localhost:8089/Kaddem/Contrat/add-contrat
    @Operation(description = "add Contrat")
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat e) {
        Contrat contrat = contratService.addContrat(e);
        return contrat;
    }

    // http://localhost:8089/Kaddem/Contrat/update-contrat
    @Operation(description = "update Contrat")
    @PutMapping("/update-contrat")
    public Contrat updateContrat(@RequestBody Contrat e) {
        Contrat contrat= contratService.updateContrat(e);
        return contrat;
    }

    // http://localhost:8089/Kaddem/Contrat/affectContratToEtudiant
    @Operation(description = "affect Contrat To Etudiant")
    @PostMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@RequestBody Contrat c, @PathVariable("nomE") String nomE, @PathVariable("prenomE") String prenomE) {
        return contratService.affectContratToEtudiant(c,nomE,prenomE);
    }
}
