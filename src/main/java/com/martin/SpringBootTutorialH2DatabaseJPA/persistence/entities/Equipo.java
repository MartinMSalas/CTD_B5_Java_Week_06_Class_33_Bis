package com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


//        Equipo:
//        Nombre: String.
//        Ciudad: String.
@Entity
@Table
public class Equipo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEquipo;
  private String nombre;
  private String ciudad;


  @OneToMany(mappedBy = "equipo",fetch = FetchType.LAZY)
  private Set<Jugador> jugadorSet = new HashSet<>();

  public Integer getIdEquipo() {
    return idEquipo;
  }

  public void setIdEquipo(Integer idEquipo) {
    this.idEquipo = idEquipo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Set<Jugador> getJugadorSet() {
    return jugadorSet;
  }

  public void setJugadorSet(Set<Jugador> jugadorSet) {
    this.jugadorSet = jugadorSet;
  }

  @Override
  public String toString() {

    return "Equipo{" +
            "idEquipo=" + idEquipo +
            ", nombre='" + nombre + '\'' +
            ", ciudad='" + ciudad + '\'' +
            ", jugadorSet=" + jugadorSet +
            '}';
  }

}
