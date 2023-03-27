package com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities;

import jakarta.persistence.*;



@Entity
@Table
public class Alumno {

    @Id
    @SequenceGenerator(name = "alumno_sequence", sequenceName = "alumno _sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_sequence")
    private Long id;
    private String nombre;
    private int edad;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="escuela_id")
    private Escuela escuela;

    public Alumno() {
    }

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}