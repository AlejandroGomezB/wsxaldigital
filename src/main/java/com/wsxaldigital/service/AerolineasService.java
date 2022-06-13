package com.wsxaldigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsxaldigital.entity.AerolineasEntity;
import com.wsxaldigital.repositories.AerolineasRepositories;

@Service
public class AerolineasService {

	@Autowired
	private AerolineasRepositories aerolineasRepositories;
	
	public List<AerolineasEntity> getAerolineas(){
		return aerolineasRepositories.findAll();
	}
	
	public AerolineasEntity getAerolineasId(long idAerolinea){
		return aerolineasRepositories.findById(idAerolinea).get();
	}
	
	public AerolineasEntity setAerolineas(AerolineasEntity aerolineas) {
		return aerolineasRepositories.save(aerolineas);
	}
	
	public AerolineasEntity updateAerolineas(AerolineasEntity aerolinea) {
		AerolineasEntity aerolineasEntity = aerolineasRepositories.findById(aerolinea.getIdAerolinea()).get();
		if(aerolineasEntity != null ) {
			aerolineasEntity.setIdAerolinea(aerolinea.getIdAerolinea());
			aerolineasEntity.setNombreAerolinea(aerolinea.getNombreAerolinea());
			return aerolineasRepositories.save(aerolineasEntity);
		}
		return null;
	}
}
