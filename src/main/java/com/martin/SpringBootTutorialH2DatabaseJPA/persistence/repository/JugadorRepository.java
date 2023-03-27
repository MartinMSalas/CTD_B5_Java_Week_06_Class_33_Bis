package com.martin.SpringBootTutorialH2DatabaseJPA.persistence.repository;


import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  JugadorRepository  extends JpaRepository<Jugador, Integer> {
        }


