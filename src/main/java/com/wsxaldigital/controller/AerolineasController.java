package com.wsxaldigital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wsxaldigital.entity.AerolineasEntity;
import com.wsxaldigital.service.AerolineasService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AerolineasController {
	
	@Autowired
	public AerolineasService aerolineasService;
	
	@GetMapping(value= "/aerolineas", produces = "application/json")
	@ApiOperation(
            value = "Devuelve todas las aerolineas registradas"
    )
	public ResponseEntity<List<AerolineasEntity>> obtenerAerolineas(){
		List<AerolineasEntity> aerolineas = aerolineasService.getAerolineas();
		if(aerolineas != null && !aerolineas.isEmpty()) {
			return new ResponseEntity<List<AerolineasEntity>>(aerolineas, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<AerolineasEntity>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/aerolineas/{id_aerolinea}", produces = "application/json")
	@ApiOperation(
            value = "Devuelve todas la aerolinea con el id ingresado"
    )
	public ResponseEntity<AerolineasEntity> obtenerAerolineas(@PathVariable("id_aerolinea") int id){
		AerolineasEntity aerolineas = aerolineasService.getAerolineasId(id);
		if(aerolineas != null ) {
			return new ResponseEntity<AerolineasEntity>(aerolineas, HttpStatus.OK);
		}else {
			return new ResponseEntity<AerolineasEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value= "/aerolineas",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Agrega una nueva aerolinea",
            notes = "El atributo id es opcional"
    )
	public ResponseEntity<AerolineasEntity> registrarAerolineas(@RequestBody AerolineasEntity aerolineaNueva ){
		AerolineasEntity aerolineas = aerolineasService.setAerolineas(aerolineaNueva);
		if(aerolineas != null ) {
			return new ResponseEntity<AerolineasEntity>(aerolineas, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<AerolineasEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping(value= "/aerolineas",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Actualiza la informcacion de la aerolinea ingresada"
    )
	public ResponseEntity<AerolineasEntity> actualizarAerolineas(@RequestBody AerolineasEntity aerolineaNueva ){
		AerolineasEntity aerolineas = aerolineasService.updateAerolineas(aerolineaNueva);
		if(aerolineas != null ) {
			return new ResponseEntity<AerolineasEntity>(aerolineas, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<AerolineasEntity>(HttpStatus.NOT_FOUND);
		}
	}
	

}
