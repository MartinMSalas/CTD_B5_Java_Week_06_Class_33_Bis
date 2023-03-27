package com.martin.SpringBootTutorialH2DatabaseJPA.controller;


import com.martin.SpringBootTutorialH2DatabaseJPA.model.JugadorDto;
import com.martin.SpringBootTutorialH2DatabaseJPA.persistence.entities.Jugador;
import com.martin.SpringBootTutorialH2DatabaseJPA.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorContoller {

  @Autowired
  JugadorService service;

  @PostMapping("/crear") //Ejemplo usando directamente la entidad
  public ResponseEntity<JugadorDto> crear(@RequestBody JugadorDto jugadorDto){
    ResponseEntity<JugadorDto> respuesta = null;

    respuesta = ResponseEntity.ok(service.save(jugadorDto));

    return respuesta;
  }

  @GetMapping("/todos") //Ejemplo usando el Dto
  public ResponseEntity<List<JugadorDto>> consultarTodos(){

    List<JugadorDto> lista =service.obtenerTodos();
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/{id}")
  public ResponseEntity<JugadorDto> obtenerPorId(@PathVariable int id){

    JugadorDto jugadorDto = service.obternerPorId(id);

    return ResponseEntity.ok(jugadorDto);
  }
}