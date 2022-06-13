package com.wsxaldigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsxaldigital.entity.MovimientosEntity;
import com.wsxaldigital.repositories.MovimientosRepositories;

@Service
public class MovimientosService {

	@Autowired
	private MovimientosRepositories movimientosRepositories;
	
	public List<MovimientosEntity> getMovimiento(){
		return movimientosRepositories.findAll();
	}
	
	public MovimientosEntity getMovimientoId(long idMovimiento){
		return movimientosRepositories.findById(idMovimiento).get();
	}
	
	public MovimientosEntity setMovimiento(MovimientosEntity movimiento) {
		return movimientosRepositories.save(movimiento);
	}
	
	public MovimientosEntity updateMovimiento(MovimientosEntity movimiento) {
		MovimientosEntity movimientoEntity = movimientosRepositories.findById(movimiento.getIdMovimiento()).get();
		if(movimientoEntity != null ) {
			movimientoEntity.setIdMovimiento(movimiento.getIdMovimiento());
			movimientoEntity.setDescripcion(movimiento.getDescripcion());
			return movimientosRepositories.save(movimientoEntity);
		}
		return null;
	}
}
