package com.example.demo.repository;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
    @Query(value = "select dateFinContrat from  Contrat c ", nativeQuery = true)
    Date retrievedateFinContrat();
}
