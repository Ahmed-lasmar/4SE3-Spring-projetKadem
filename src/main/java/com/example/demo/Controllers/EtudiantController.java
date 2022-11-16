package com.example.demo.Controllers;

import com.example.demo.Service.EtudiantService;
import com.example.demo.entities.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    EtudiantService etudiantService;

    // http://localhost:8089/Kaddem/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiant() {
        return etudiantService.retrieveAllEtudiant();
    }

    // http://localhost:8089/Kaddem/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    // http://localhost:8089/Kaddem/etudiant/remove-etudiant/1
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.deleteEtudiant(etudiantId);
    }

    // http://localhost:8089/Kaddem/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    // http://localhost:8089/Kaddem/etudiant/update-etudiant
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantService.updateEtudiant(e);
    }

    // http://localhost:8089/Kaddem/etudiant/assignEtToDep
    @PutMapping("/assignEtToDep/{etudiant-id}/{departement-id}")
    public Etudiant uassignEtToDep(@PathVariable("etudiant-id") Long etudiantId,@PathVariable("departement-id") Long departementId) {
        return etudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }

    // http://localhost:8089/Kaddem/etudiant/addAndAssignEtToEqAndCon
    @PostMapping("/addAndAssignEtToEqAndCon/{etudiant-id}/{Contrat-id}")
    public Etudiant addAndAssignEtToEqAndCon(@RequestBody Etudiant e,@PathVariable("etudiant-id") Long etudiantId,@PathVariable("Contrat-id") Long departementId) {
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,etudiantId,departementId);
    }
}
