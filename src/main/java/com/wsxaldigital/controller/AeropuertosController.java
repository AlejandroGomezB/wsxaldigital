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

import com.wsxaldigital.entity.AeropuertosEntity;
import com.wsxaldigital.service.AeropuertosService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AeropuertosController {
	@Autowired
	private AeropuertosService aeropuertosService;
	
	@GetMapping(value= "/aeropuertos", produces = "application/json")
	@ApiOperation(
            value = "Devuelve todas las aeropuerto registradas"
    )
	public ResponseEntity<List<AeropuertosEntity>> obtenerAeropuertos(){
		List<AeropuertosEntity> aeropuertos = aeropuertosService.getAeropuertos();
		if(aeropuertos != null && !aeropuertos.isEmpty()) {
			return new ResponseEntity<List<AeropuertosEntity>>(aeropuertos, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<AeropuertosEntity>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/aeropuertos/{id_aeropuerto}", produces = "application/json")
	@ApiOperation(
            value = "Devuelve todas la aeropuerto con el id ingresado"
    )
	public ResponseEntity<AeropuertosEntity> obtenerAeropuertosId(@PathVariable("id_aeropuerto") int id){
		AeropuertosEntity aeropuertos = aeropuertosService.getAeropuertoId(id);
		if(aeropuertos != null ) {
			return new ResponseEntity<AeropuertosEntity>(aeropuertos, HttpStatus.OK);
		}else {
			return new ResponseEntity<AeropuertosEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value= "/aeropuertos",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Agrega una nueva Aeropuerto",
            notes = "El atributo id es opcional"
    )
	public ResponseEntity<AeropuertosEntity> registrarAeropuerto(@RequestBody AeropuertosEntity aeropuertoNueva ){
		AeropuertosEntity aeropuertos = aeropuertosService.setAeropuertos(aeropuertoNueva);
		if(aeropuertos != null ) {
			return new ResponseEntity<AeropuertosEntity>(aeropuertos, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<AeropuertosEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value= "/aeropuertos",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Actualiza la informacion del aeropuerto ingresado"
    )
	public ResponseEntity<AeropuertosEntity> actualizarAeropuerto(@RequestBody AeropuertosEntity aeropuertoNueva ){
		AeropuertosEntity aeropuertos = aeropuertosService.updateAeropuertos(aeropuertoNueva);
		if(aeropuertos != null ) {
			return new ResponseEntity<AeropuertosEntity>(aeropuertos, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<AeropuertosEntity>(HttpStatus.NOT_FOUND);
		}
	}
}
