package com.example.demo.Controllers;

import com.example.demo.Service.UniversiteService;
import com.example.demo.entities.Universite;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    UniversiteService universiteService;

    // http://localhost:8089/Kaddem/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")

    public List<Universite> getUniversite() {
        List<Universite> listEquipes = universiteService.retrieveAllUniversite();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    // http://localhost:8089/Kaddem/universite/remove-universite/1
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.deleteUniversite(universiteId);
    }

    // http://localhost:8089/Kaddem/universite/add-universite
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite) {
        Universite universite1 = universiteService.addUniversite(universite);
        return universite1;
    }
    @PostMapping("/adduniv")
    public Universite addUniv(@RequestBody Universite universite){
        Universite universite1= universiteService.addUniversite(universite);
        return  universite1;
    }

    // http://localhost:8089/Kaddem/universite/update-universite
    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite e) {
        Universite universite= universiteService.updateUniversite(e);
        return universite;
    }

    // http://localhost:8089/Kaddem/universite/assignUniToDep
    @PutMapping("/assignUniToDep/{idUniversite}/{departement-id}")
    public Universite assignUniToDep(@PathVariable("idUniversite")Long idUniversite, @PathVariable("departement-id")Long idDepartement) {
        Universite universite= universiteService.assignUniversiteToDepartement(idUniversite,idUniversite);
        return universite;
    }
}
