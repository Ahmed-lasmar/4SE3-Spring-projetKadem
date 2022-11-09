package com.example.demo.Controllers;

import com.example.demo.Service.ContratService;
import com.example.demo.entities.Contrat;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Contrat")
public class ContratController {
    ContratService contratService;

    // http://localhost:8089/Kaddem/Contrat/retrieve-all-contrats
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getContrat() {
        List<Contrat> listEquipes = contratService.retrieveAllContrat();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/Contrat/retrieve-contrat/8
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        return contratService.retrieveContrat(contratId);
    }

    // http://localhost:8089/Kaddem/Contrat/remove-contrat/1
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.deleteContrat(contratId);
    }

    // http://localhost:8089/Kaddem/Contrat/add-contrat
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat e) {
        Contrat contrat = contratService.addContrat(e);
        return contrat;
    }

    // http://localhost:8089/Kaddem/Contrat/update-contrat
    @PutMapping("/update-contrat")
    public Contrat updateContrat(@RequestBody Contrat e) {
        Contrat contrat= contratService.updateContrat(e);
        return contrat;
    }
}
