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

import com.wsxaldigital.entity.MovimientosEntity;
import com.wsxaldigital.service.MovimientosService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MovimientosController {
	
	@Autowired
	public MovimientosService movimientosService;
	
	@GetMapping(value= "/movimientos", produces = "application/json")
	@ApiOperation(
            value = "Devuelve todos los movimiento registradas"
    )
	public ResponseEntity<List<MovimientosEntity>> obtenerMovimientos(){
		List<MovimientosEntity> movimiento = movimientosService.getMovimiento();
		if(movimiento != null && !movimiento.isEmpty()) {
			return new ResponseEntity<List<MovimientosEntity>>(movimiento, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<MovimientosEntity>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value= "/movimientos/{id_movimiento}", produces = "application/json")
	@ApiOperation(
            value = "Devuelve el movimiento con el id ingresado"
    )
	public ResponseEntity<MovimientosEntity> obtenerMovimientoId(@PathVariable("id_movimiento") int id){
		MovimientosEntity movimiento = movimientosService.getMovimientoId(id);
		if(movimiento != null ) {
			return new ResponseEntity<MovimientosEntity>(movimiento, HttpStatus.OK);
		}else {
			return new ResponseEntity<MovimientosEntity>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value= "/movimientos",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Agrega un nuevo Movimiento",
            notes = "El atributo id es opcional"
    )
	public ResponseEntity<MovimientosEntity> registrarMovimiento(@RequestBody MovimientosEntity movimientoNuevo ){
		MovimientosEntity movimiento = movimientosService.setMovimiento(movimientoNuevo);
		if(movimiento != null ) {
			return new ResponseEntity<MovimientosEntity>(movimiento, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<MovimientosEntity>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value= "/movimientos",consumes ="application/json",  produces = "application/json")
	@ApiOperation(
            value = "Actualiza la informcacion del movimiento ingresada"
    )
	public ResponseEntity<MovimientosEntity> actualizarMovimiento(@RequestBody MovimientosEntity movimientoNuevo ){
		MovimientosEntity movimiento = movimientosService.updateMovimiento(movimientoNuevo);
		if(movimiento != null ) {
			return new ResponseEntity<MovimientosEntity>(movimiento, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<MovimientosEntity>(HttpStatus.NOT_FOUND);
		}
	}

}
