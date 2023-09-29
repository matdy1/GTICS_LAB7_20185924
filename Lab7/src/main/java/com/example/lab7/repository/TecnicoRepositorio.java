package com.example.lab7.repository;

import com.example.lab7.entitiies.Tecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepositorio extends JpaRepository<Tecnicos, Integer> {

}