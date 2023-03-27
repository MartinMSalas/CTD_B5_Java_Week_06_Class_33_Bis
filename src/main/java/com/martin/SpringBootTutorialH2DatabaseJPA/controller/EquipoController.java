package com.martin.SpringBootTutorialH2DatabaseJPA.controller;

import com.martin.SpringBootTutorialH2DatabaseJPA.model.EquipoDto;


import com.martin.SpringBootTutorialH2DatabaseJPA.service.EquipoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {



  @Autowired
  EquipoService service;

  @PostMapping("/crear") //Ejemplo usando directamente la entidad
  public ResponseEntity<EquipoDto> crear(@RequestBody EquipoDto equipoDto){
    ResponseEntity<EquipoDto> respuesta = null;

    respuesta = ResponseEntity.ok(service.save(equipoDto));

    return respuesta;
  }

  @GetMapping("/todos") //Ejemplo usando el Dto
  public ResponseEntity<List<EquipoDto>> consultarTodos(){

    List<EquipoDto> lista =service.obtenerTodos();
    return ResponseEntity.ok(lista);
  }
  @GetMapping("/{id}") //Ejemplo usando el Dto
  public ResponseEntity<EquipoDto> obtenerPorId (@PathVariable int id){

    EquipoDto equipoDto =service.obtenerPorId(id);
    return ResponseEntity.ok(equipoDto);
  }

  @PutMapping("/actualizar")
  public ResponseEntity<EquipoDto> actualizarEquipo(@RequestBody EquipoDto equipoDto){
    ResponseEntity<EquipoDto> respuesta = null;


    respuesta = ResponseEntity.ok(service.actualizar(equipoDto));

    return respuesta;
  }
  @PostMapping("/agregarjugador/{idJugador}/{idEquipo}")
  public ResponseEntity<EquipoDto> agregarJugador(@PathVariable int idJugador,@PathVariable  int idEquipo){

    ResponseEntity<EquipoDto> respuesta = null;



    respuesta = ResponseEntity.ok(service.agregarJugadorAlEquipo(idJugador, idEquipo));

    return respuesta;
  }

  /*


save(entity) - saves or updates the given entity.

findAll() - returns all entities.

findById(id) - returns the entity with the given ID, or null if none exists.

deleteById(id) - deletes the entity with the given ID.

existsById(id) - returns true if an entity with the given ID exists, false otherwise.

count() - returns the number of entities.

flush() - flushes pending changes to the database.

delete(entity) - deletes the given entity.

deleteAll() - deletes all entities.

findByX(x)

   */


}