package com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities;



//Jugador:
//        Nombre: String.
//        Puesto: String (Delantero, defensor, etc.).
//        Número: int.

import jakarta.persistence.*;

@Entity
@Table
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String puesto;
    private int numero;



    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Equipo equipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
       return nombre;
     }
    public void setNombre(String nombre) {
       this.nombre = nombre;
     }

    public String getPuesto() {
       return puesto;
     }

    public void setPuesto(String puesto) {
       this.puesto = puesto;
     }

    public int getNumero() {
       return numero;
     }

    public void setNumero(int numero) {
       this.numero = numero;
     }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        String nombreEquipo = "Sin equipo asignado";
        if (equipo!=null) {
            nombreEquipo = equipo.getNombre();
        }
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", numero=" + numero +
                ", equipo=" + nombreEquipo +
                '}';
    }
}
