package com.wsxaldigital.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "TBVUELOS")
@JsonInclude(Include.NON_NULL)
public class VuelosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id_vuelos")
	@JsonProperty("id")
	@JsonIgnore
	private long idVuelos;
	
	@ManyToOne
	@JoinColumn(name = "TBAEROLINEAS" )
	@JsonProperty("idAerolinea")
	private AerolineasEntity idAerolinea;

	@ManyToOne
	@JoinColumn(name = "TBAEROPUERTOS" )
	@JsonProperty("idAeropuertos")
	private AeropuertosEntity idAeropuerto;
	
	@ManyToOne
	@JoinColumn(name = "TBMOVIMIENTOS")
	@JsonProperty("idMovimieto")
	private MovimientosEntity idMovimiento;
	
	@Column(name = "dia")
	@JsonProperty("dia")
	private Date dia;

	public VuelosEntity() {
		super();
	}

	public VuelosEntity(long idVuelos, AerolineasEntity idAerolinea, AeropuertosEntity idAeropuerto,
			MovimientosEntity idMovimiento, Date dia) {
		super();
		this.idVuelos = idVuelos;
		this.idAerolinea = idAerolinea;
		this.idAeropuerto = idAeropuerto;
		this.idMovimiento = idMovimiento;
		this.dia = dia;
	}

	public long getIdVuelos() {
		return idVuelos;
	}

	public void setIdVuelos(long idVuelos) {
		this.idVuelos = idVuelos;
	}

	public AerolineasEntity getIdAerolinea() {
		return idAerolinea;
	}

	public void setIdAerolinea(AerolineasEntity idAerolinea) {
		this.idAerolinea = idAerolinea;
	}

	public AeropuertosEntity getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(AeropuertosEntity idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public MovimientosEntity getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(MovimientosEntity idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	
}
