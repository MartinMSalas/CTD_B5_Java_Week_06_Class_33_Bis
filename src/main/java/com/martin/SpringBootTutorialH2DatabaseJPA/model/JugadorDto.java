package com.martin.SpringBootTutorialH2DatabaseJPA.model;

import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Equipo;

public class JugadorDto {

  private Integer id;
  private String nombre;
  private String puesto;
  private int numero;



  private int equipoId;
  //private Equipo equipo;
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public int getEquipoId() {
    return equipoId;
  }

  public void setEquipoId(int equipoId) {
    this.equipoId = equipoId;
  }

  @Override
  public String toString() {
    return "JugadorDto{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", puesto='" + puesto + '\'' +
            ", numero=" + numero +
            ", equipoId=" + equipoId +
            '}';
  }


  /*
  public Equipo getEquipo() {
    return equipo;
  }

  public void setEquipo(Equipo equipo) {
    this.equipo = equipo;
  }

  @Override
  public String toString() {
    return "JugadorDto{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", puesto='" + puesto + '\'' +
            ", numero=" + numero +
            ", equipo=" + equipo +
            '}';
  }

   */
}
