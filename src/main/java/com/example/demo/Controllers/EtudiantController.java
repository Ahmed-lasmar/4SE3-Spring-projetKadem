package com.example.demo.Controllers;

import com.example.demo.Service.EtudiantService;
import com.example.demo.entities.Etudiant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Etudiant")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    EtudiantService etudiantService;

    // http://localhost:8089/Kaddem/etudiant/retrieve-all-etudiants
    @Operation(description = "Retrieve all etudiant")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiant() {
        return etudiantService.retrieveAllEtudiant();
    }

    // http://localhost:8089/Kaddem/etudiant/retrieve-etudiant/8
    @Operation(description = "Retrieve etudiant by ID")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    // http://localhost:8089/Kaddem/etudiant/remove-etudiant/1
    @Operation(description = "Remove etudiant by ID")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.deleteEtudiant(etudiantId);
    }

    // http://localhost:8089/Kaddem/etudiant/add-etudiant
    @Operation(description = "add etudiant")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    // http://localhost:8089/Kaddem/etudiant/update-etudiant
    @Operation(description = "update etudiant")
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantService.updateEtudiant(e);
    }

    // http://localhost:8089/Kaddem/etudiant/assignEtToDep
    @Operation(description = "assign Etudiant To Departement")
    @PutMapping("/assignEtToDep/{etudiant-id}/{departement-id}")
    public Etudiant uassignEtToDep(@PathVariable("etudiant-id") Long etudiantId,@PathVariable("departement-id") Long departementId) {
        return etudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }

    // http://localhost:8089/Kaddem/etudiant/addAndAssignEtToEqAndCon
    @Operation(description = "add And Assign Etudiant To Equipe And Contract")
    @PostMapping("/addAndAssignEtToEqAndCon/{etudiant-id}/{Contrat-id}")
    public Etudiant addAndAssignEtToEqAndCon(@RequestBody Etudiant e,@PathVariable("etudiant-id") Long etudiantId,@PathVariable("Contrat-id") Long departementId) {
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,etudiantId,departementId);
    }

    // http://localhost:8089/Kaddem/etudiant/EtudiantsByDepartement/8
    @Operation(description = "get Etudiants By Departement")
    @GetMapping("/EtudiantsByDepartement/{departement-id}")
    public List<Etudiant> retrieveEtudiant(@PathVariable("departement-id") Long departementid) {
        return etudiantService.getEtudiantsByDepartement(departementid);
    }
}
