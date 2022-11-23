package com.example.demo.Controllers;

import com.example.demo.Service.UniversiteService;
import com.example.demo.entities.Universite;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    UniversiteService universiteService;

    // http://localhost:8089/Kaddem/universite/retrieve-all-universites
    @Operation(description = "Retrieve all Universites")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversite() {
        List<Universite> listEquipes = universiteService.retrieveAllUniversite();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/universite/retrieve-universite/8
    @Operation(description = "Retrieve Universite by ID")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    // http://localhost:8089/Kaddem/universite/remove-universite/1
    @Operation(description = "Remove Universite by ID")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.deleteUniversite(universiteId);
    }

    // http://localhost:8089/Kaddem/universite/add-universite
    @Operation(description = "add Universite")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        Universite universite1 = universiteService.addUniversite(universite);
        return universite1;
    }
    @Operation(description = "add Universite")
    @PostMapping("/adduniv")
    public Universite addUniv(@RequestBody Universite universite){
        Universite universite1= universiteService.addUniversite(universite);
        return  universite1;
    }

    // http://localhost:8089/Kaddem/universite/update-universite
    @Operation(description = "update Universite")
    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite e) {
        Universite universite= universiteService.updateUniversite(e);
        return universite;
    }

    // http://localhost:8089/Kaddem/universite/assignUniToDep
    @Operation(description = "assign Universite To Departement")
    @PutMapping("/assignUniToDep/{idUniversite}/{departement-id}")
    public Universite assignUniToDep(@PathVariable("idUniversite")Long idUniversite, @PathVariable("departement-id")Long idDepartement) {
        Universite universite= universiteService.assignUniversiteToDepartement(idUniversite,idUniversite);
        return universite;
    }
}
