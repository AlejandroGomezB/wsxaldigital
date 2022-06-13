package com.wsxaldigital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TBAEROLINEAS")
@JsonInclude(Include.NON_NULL)
public class AerolineasEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id_aerolinea")
	@JsonProperty("id")
	private long idAerolinea;
	
	@Column(name = "nombre_aerolinea")
	@JsonProperty("nombre")
	private String nombreAerolinea;

	public AerolineasEntity() {
		super();
	}

	public AerolineasEntity(long idAerolinea, String nombreAerolinea) {
		super();
		this.idAerolinea = idAerolinea;
		this.nombreAerolinea = nombreAerolinea;
	}

	public long getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(long idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public String getNombreAerolinea() {
		return nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}
	

}
