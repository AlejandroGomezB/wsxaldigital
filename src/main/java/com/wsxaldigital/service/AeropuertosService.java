package com.wsxaldigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsxaldigital.entity.AeropuertosEntity;
import com.wsxaldigital.repositories.AeropuertosRepositories;

@Service
public class AeropuertosService {
	
	@Autowired
	private AeropuertosRepositories aeropuertosRepositories;
	
	public List<AeropuertosEntity> getAeropuertos(){
		return aeropuertosRepositories.findAll();
	}
	
	public AeropuertosEntity getAeropuertoId(long idAeropuerto){
		return aeropuertosRepositories.findById(idAeropuerto).get();
	}
	
	public AeropuertosEntity setAeropuertos(AeropuertosEntity aeropuertos) {
		return aeropuertosRepositories.save(aeropuertos);
	}
	
	public AeropuertosEntity updateAeropuertos(AeropuertosEntity aeropuerto) {
		AeropuertosEntity aeropuertosEntity = aeropuertosRepositories.findById(aeropuerto.getIdAeropuerto()).get();
		if(aeropuertosEntity != null ) {
			aeropuertosEntity.setIdAeropuerto(aeropuerto.getIdAeropuerto());
			aeropuertosEntity.setNombreAeropuerto(aeropuerto.getNombreAeropuerto());
			return aeropuertosRepositories.save(aeropuertosEntity);
		}
		return null;
	}

}
