package com.example.demo.Controllers;

import com.example.demo.Service.DepartementService;
import com.example.demo.entities.Departement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Departement")
public class DepartementController {
    DepartementService departementService;

    // http://localhost:8089/Kaddem/departement/retrieve-all-departements
    @GetMapping("/retrieve-all-departements")
    public List<Departement> getDepartement() {
        List<Departement> listEquipes = departementService.retrieveAllDepartement();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/departement/retrieve-departement/8
    @GetMapping("/retrieve-departement/{departement-id}")
    public Departement retrieveDepartement(@PathVariable("departement-id") Long departementId) {
        return departementService.retrieveDepartement(departementId);
    }

    // http://localhost:8089/Kaddem/departement/remove-departement/1
    @DeleteMapping("/remove-departement/{departement-id}")
    public void removeDepartement(@PathVariable("departement-id") Long departementId) {
        departementService.deleteDepartement(departementId);
    }

    // http://localhost:8089/kaddem/departement/add-departement
    @PostMapping("/add-departement")
    public Departement addDepartement(@RequestBody Departement e) {
        Departement departement = departementService.addDepartement(e);
        return departement;
    }

    // http://localhost:8089/kaddem/departement/update-departement
    @PutMapping("/update-departement")
    public Departement updateDepartement(@RequestBody Departement e) {
        Departement departement= departementService.updateDepartement(e);
        return departement;
    }
}