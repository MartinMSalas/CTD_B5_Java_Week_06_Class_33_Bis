package com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Escuela {

    @Id
    @SequenceGenerator(name= "escuela_sequence", sequenceName = "escuela_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escuela_sequence")
    private Long id;
    private String nombre;
    private String direccion;

    public Escuela() {
    }

    @OneToMany(mappedBy = "escuela", fetch = FetchType.LAZY)
    private Set<Alumno> alumnoSet = new HashSet<>();

    public Escuela(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Set<Alumno> getAlumnoSet() {
        return alumnoSet;
    }

    public void setAlumnoSet(Set<Alumno> alumnoSet) {
        this.alumnoSet = alumnoSet;
    }

    public Long getId() {
        return id;
    }
}
