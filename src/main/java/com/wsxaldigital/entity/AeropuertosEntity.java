package com.wsxaldigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TBAEROPUERTOS")
@JsonInclude(Include.NON_NULL)
public class AeropuertosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id_aeropuerto")
	@JsonProperty("id")
	private long idAeropuerto;
	
	@Column(name = "nombre_aeropuerto")
	@JsonProperty("nombre")
	private String nombreAeropuerto;

	public AeropuertosEntity() {
		super();
	}

	public AeropuertosEntity(long idAeropuerto, String nombreAeropuerto) {
		super();
		this.idAeropuerto = idAeropuerto;
		this.nombreAeropuerto = nombreAeropuerto;
	}

	public long getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(long idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}
	

}
