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

import com.wsxaldigital.entity.VuelosEntity;
import com.wsxaldigital.service.VuelosService;

import io.swagger.annotations.ApiOperation;

@RestController
public class VuelosController {
	
	@Autowired
	private VuelosService vuelosService;
	
	@GetMapping(value= "/vuelos/aereopuerto/{year}", produces = "application/json")
	@ApiOperation(
            value = "Devuelve el aeropuerto con mas movimientos al año ingresado"
    )
	public ResponseEntity<VuelosEntity> obtenerAeropuertoMasMovimientosAño(@PathVariable("year") String year ){
		VuelosEntity vuelos = vuelosService.getMayorMovimientosAeropuertosAño(year);
		if(vuelos != null ) {
			return new ResponseEntity<VuelosEntity>(vuelos, HttpStatus.OK);
		}else {
			return new ResponseEntity<VuelosEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/vuelos/aerolinea/{year}", produces = "application/json")
	@ApiOperation(
            value = "Devuelve la aerolinea con mas vuelos al año ingresado"
    )
	public ResponseEntity<VuelosEntity> getMayorVuelosAerolineaAño(@PathVariable("year") String year){
		VuelosEntity vuelos = vuelosService.getMayorVuelosAerolineaAño(year);
		if(vuelos != null ) {
			return new ResponseEntity<VuelosEntity>(vuelos, HttpStatus.OK);
		}else {
			return new ResponseEntity<VuelosEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/vuelos/mayor/dia", produces = "application/json")
	@ApiOperation(
            value = "Devuelve el dia que tiene mas registros de vuelos"
    )
	public ResponseEntity<VuelosEntity> obtenerDiaMasVuelos(){
		VuelosEntity vuelos = vuelosService.getDiaMayorVuelos();
		if(vuelos != null ) {
			return new ResponseEntity<VuelosEntity>(vuelos, HttpStatus.OK);
		}else {
			return new ResponseEntity<VuelosEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/vuelos/mas/aerolineas/{fecha}", produces = "application/json")
	@ApiOperation(
            value = "Devuelve las aerolineas que tienen mas de 2 vuelos de acuerdo a la fecha ingresada"
    )
	public ResponseEntity<List<VuelosEntity>> obtenerAerolineaMasDosVuelos(@PathVariable("fecha") String fecha){
		List<VuelosEntity> vuelos = vuelosService.getAerolineaMasDosVuelos(fecha);
		if(vuelos != null && !vuelos.isEmpty()) {
			return new ResponseEntity<List<VuelosEntity>>(vuelos, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<VuelosEntity>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/vuelos", produces = "application/json")
	@ApiOperation(
            value = "Devuelve todos los vuelos registrados"
    )
	public ResponseEntity<List<VuelosEntity>> obtenerVuelos(){
		List<VuelosEntity> vuelos = vuelosService.getVuelos();
		if(vuelos != null && !vuelos.isEmpty()) {
			return new ResponseEntity<List<VuelosEntity>>(vuelos, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<VuelosEntity>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/vuelos/{id_vuelos}", produces = "application/json")
	@ApiOperation(
            value = "Devuelve el vuelo con el id ingresado"
    )
	public ResponseEntity<VuelosEntity> obtenerVuelosId(@PathVariable("id_vuelos") int id){
		VuelosEntity vuelos = vuelosService.getVueloId(id);
		if(vuelos != null ) {
			return new ResponseEntity<VuelosEntity>(vuelos, HttpStatus.OK);
		}else {
			return new ResponseEntity<VuelosEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value= "/vuelos",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Agrega un nuevo vuelo",
            notes = "El atributo id es opcional"
    )
	public ResponseEntity<VuelosEntity> registrarVuelo(@RequestBody VuelosEntity vueloNuevo ){
		VuelosEntity vuelos = vuelosService.setVuelos(vueloNuevo);
		if(vuelos != null ) {
			return new ResponseEntity<VuelosEntity>(vuelos, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<VuelosEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value= "/vuelos",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Actualiza la informacion del vuelo ingresada"
    )
	public ResponseEntity<VuelosEntity> actualizarVuelo(@RequestBody VuelosEntity vueloNuevo ){
		VuelosEntity vuelos = vuelosService.updateVuelo(vueloNuevo);
		if(vuelos != null ) {
			return new ResponseEntity<VuelosEntity>(vuelos, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<VuelosEntity>(HttpStatus.NOT_FOUND);
		}
	}

}
