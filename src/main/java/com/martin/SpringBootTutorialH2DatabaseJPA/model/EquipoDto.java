package com.martin.SpringBootTutorialH2DatabaseJPA.model;

import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Jugador;

import java.util.HashSet;
import java.util.Set;

public class EquipoDto {
  private Integer idEquipo;
  private String nombre;
  private String ciudad;

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
    return "EquipoDto{" +
            "idEquipo=" + idEquipo +
            ", nombre='" + nombre + '\'' +
            ", ciudad='" + ciudad + '\'' +
            ", jugadorSet=" + jugadorSet +
            '}';
  }
}
