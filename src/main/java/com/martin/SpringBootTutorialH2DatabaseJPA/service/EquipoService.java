package com.martin.SpringBootTutorialH2DatabaseJPA.service;

import com.martin.SpringBootTutorialH2DatabaseJPA.model.EquipoDto;

import com.martin.SpringBootTutorialH2DatabaseJPA.model.JugadorDto;
import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Equipo;
import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Jugador;
import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.repository.EquipoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

  @Autowired
  private EquipoRepository equipoRepository;

  @Autowired
  private JugadorService jugadorService;

  @Autowired
  private ModelMapper modelMapper;

  public EquipoDto save(EquipoDto equipoDto){
    Equipo result;
    System.out.println(equipoDto);
    result = modelMapper.map(equipoDto,Equipo.class);
    System.out.println(result);
    result = equipoRepository.save(result);
    System.out.println(result);
    return modelMapper.map(result,EquipoDto.class);
  }

  public List<EquipoDto> obtenerTodos(){

    List<EquipoDto> equipos = new ArrayList<>();
    System.out.println("Soy una prueba");

    for (Equipo equipo : equipoRepository.findAll()) {

      equipos.add(modelMapper.map(equipo, EquipoDto.class));
    }

    return equipos;
  }

  public EquipoDto actualizar(EquipoDto equipoDto) {

    EquipoDto result;

    Equipo equipo = equipoRepository.save(modelMapper.map(equipoDto, Equipo.class));
    result = modelMapper.map(equipo, EquipoDto.class);
    return result;

  }

  public EquipoDto obtenerPorId(int id) {
    EquipoDto result = modelMapper.map(equipoRepository.findById(id), EquipoDto.class);
    return result;
  }



  public EquipoDto agregarJugadorAlEquipo(int idJugador, int idEquipo) {


    Optional<Equipo> e = equipoRepository.findById(idEquipo);
    Equipo equipo = e.orElse(null);
    Jugador jugador = modelMapper.map(jugadorService.obternerPorId(idJugador), Jugador.class);

    System.out.println("----------------------------------------");
    System.out.println(equipo);
    equipo.getJugadorSet().add(jugador);
    System.out.println(equipo);

    System.out.println("----------------------------------------");
    jugador.setEquipo(equipo);
    System.out.println(jugador);
    System.out.println("----------------------------------------");
    equipoRepository.save(equipo);
    System.out.println("----------------------------------------");
    jugadorService.save(modelMapper.map(jugador, JugadorDto.class));

    return null;
  }

  /*



   */
}
