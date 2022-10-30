package com.example.demo.repository;

import com.example.demo.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {

}
