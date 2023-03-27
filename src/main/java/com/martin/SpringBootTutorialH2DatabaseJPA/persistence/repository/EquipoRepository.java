package com.martin.SpringBootTutorialH2DatabaseJPA.persistence.repository;

import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  EquipoRepository  extends JpaRepository<Equipo, Integer> {
}
