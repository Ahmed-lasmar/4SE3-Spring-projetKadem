package com.example.demo.Controllers;

import com.example.demo.Service.DepartementService;
import com.example.demo.entities.Departement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Departement")
@RestController
@AllArgsConstructor
@RequestMapping("/Departement")
public class DepartementController {
    DepartementService departementService;

    // http://localhost:8089/Kaddem/Departement/retrieve-all-departements
    @Operation(description = "Retrieve all Departements")
    @GetMapping("/retrieve-all-departements")
    public List<Departement> getDepartement() {
        List<Departement> listEquipes = departementService.retrieveAllDepartement();
        return listEquipes;
    }

    // http://localhost:8089/Kaddem/Departement/retrieve-departement/8
    @Operation(description = "Retrieve Departement by ID")
    @GetMapping("/retrieve-departement/{departement-id}")
    public Departement retrieveDepartement(@PathVariable("departement-id") Long departementId) {
        return departementService.retrieveDepartement(departementId);
    }

    // http://localhost:8089/Kaddem/Departement/remove-departement/1
    @Operation(description = "Remove Departement by ID")
    @DeleteMapping("/remove-departement/{departement-id}")
    public void removeDepartement(@PathVariable("departement-id") Long departementId) {
        departementService.deleteDepartement(departementId);
    }

    // http://localhost:8089/Kaddem/Departement/add-departement
    @Operation(description = "add Departement")
    @PostMapping("/add-departement")
    public Departement addDepartement(@RequestBody Departement e) {
        Departement departement = departementService.addDepartement(e);
        return departement;
    }

    // http://localhost:8089/Kaddem/Departement/update-departement
    @Operation(description = "update Departement")
    @PutMapping("/update-departement")
    public Departement updateDepartement(@RequestBody Departement e) {
        Departement departement= departementService.updateDepartement(e);
        return departement;
    }
}