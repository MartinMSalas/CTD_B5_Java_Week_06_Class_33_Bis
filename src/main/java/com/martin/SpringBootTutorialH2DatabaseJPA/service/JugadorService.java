package com.martin.SpringBootTutorialH2DatabaseJPA.service;


import com.martin.SpringBootTutorialH2DatabaseJPA.model.JugadorDto;
import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Jugador;
import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.repository.JugadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

  @Autowired
  private JugadorRepository repository;

  @Autowired
  private ModelMapper modelMapper;
/*
  public JugadorDto save(JugadorDto juegadorDto){
    Jugador result;
    System.out.println(juegadorDto);
    result = modelMapper.map(juegadorDto,Jugador.class);

    System.out.println(result);

    result = repository.save(result);
    System.out.println(result);
    return modelMapper.map(result,JugadorDto.class);
  }
*/
public JugadorDto save(JugadorDto juegadorDto){
  Jugador result;
  System.out.println(juegadorDto);
  result = modelMapper.map(juegadorDto,Jugador.class);

  System.out.println(result);
  result.setEquipo(null);
  result = repository.save(result);
  System.out.println(result);
  return modelMapper.map(result,JugadorDto.class);
}

  public List<JugadorDto> obtenerTodos(){

    List<JugadorDto> jugadores = new ArrayList<>();


    for (Jugador jugador : repository.findAll()) {

      jugadores.add(modelMapper.map(jugador, JugadorDto.class));
    }

    return jugadores;
  }

  public JugadorDto obternerPorId(int idJugador) {
    JugadorDto resultado;
    Optional<Jugador> jugador = repository.findById(idJugador);
    System.out.println(jugador.orElse(null));
    resultado = modelMapper.map(jugador.orElse(null),JugadorDto.class);
    System.out.println(resultado);
    return resultado;
  }
}
