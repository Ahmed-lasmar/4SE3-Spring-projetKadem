package com.example.demo.repository;

import com.example.demo.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
