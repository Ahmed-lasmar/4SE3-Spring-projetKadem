package com.example.demo.repository;

import com.example.demo.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface khademRepository extends JpaRepository<Etudiant, Long>{
    List<Etudiant> findByDepartement_IdDepart(Long IdDepart);
    List<Etudiant> findByEquipeidEquipeANDNiveauLike(Long idEquipe ,String Niveau);

}
