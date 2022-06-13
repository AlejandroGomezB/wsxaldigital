package com.wsxaldigital.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsxaldigital.entity.VuelosEntity;
import com.wsxaldigital.repositories.VuelosRepositories;

@Service
public class VuelosService {
	
	@Autowired
	private VuelosRepositories vuelosRepositories;
	
	public VuelosEntity getMayorMovimientosAeropuertosAño(String año) {
		return vuelosRepositories.findMayorMovimientosAeropuerto(Integer.parseInt(año)).get(0);
	}
	
	public VuelosEntity getMayorVuelosAerolineaAño(String año) {
		return vuelosRepositories.findMayorNumeroVuelos(Integer.parseInt(año)).get(0);
	}
	
	public VuelosEntity getDiaMayorVuelos() {
		return vuelosRepositories.findMayorVuelosDia().get(0);
	}
	
	public List<VuelosEntity> getAerolineaMasDosVuelos(String dia) {
		try {
			Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(dia);
			return vuelosRepositories.findAerolineasMasDosVuelos(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<VuelosEntity> getVuelos(){
		return vuelosRepositories.findAll();
	}
	
	public VuelosEntity getVueloId(long idVuelo){
		return vuelosRepositories.findById(idVuelo).get();
	}
	
	public VuelosEntity setVuelos(VuelosEntity aerolineas) {
		return vuelosRepositories.save(aerolineas);
	}
	
	public VuelosEntity updateVuelo(VuelosEntity vuelo) {
		VuelosEntity vueloEntity = vuelosRepositories.findById(vuelo.getIdVuelos()).get();
		if(vueloEntity != null ) {
			vueloEntity.setIdVuelos(vuelo.getIdVuelos());
			vueloEntity.setIdAerolinea(vuelo.getIdAerolinea());
			vueloEntity.setIdAeropuerto(vuelo.getIdAeropuerto());
			vueloEntity.setIdMovimiento(vuelo.getIdMovimiento());
			vueloEntity.setDia(vuelo.getDia());
			return vuelosRepositories.save(vueloEntity);
		}
		return null;
	}
}
