package com.example.demo.repository;

import com.example.demo.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    @Query(value = "select * from  Etudiant e where e.nomE = :n and e.prenomE = :p", nativeQuery = true)
    Etudiant retrieveEtudiantParNom(@Param("n") String nomE, @Param("p") String prenomE);

    @Query(value = "select * from  Etudiant e where e.departement = :d ", nativeQuery = true)
    Etudiant retrieveEtudiantPardepartement(@Param("d") Long departement);

}

