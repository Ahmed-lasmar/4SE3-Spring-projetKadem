package com.example.demo.repository;

import com.example.demo.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement,Long> {
}
