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
@Table(name = "TBMOVIMIENTOS")
@JsonInclude(Include.NON_NULL)
public class MovimientosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name = "id_movimiento")
	@JsonProperty("id")
	private long idMovimiento;
	
	@Column(name  = "descripcion")
	@JsonProperty("descripcion")
	private String descripcion;

	public MovimientosEntity() {
		super();
	}

	public MovimientosEntity(long idMovimiento, String descripcion) {
		super();
		this.idMovimiento = idMovimiento;
		this.descripcion = descripcion;
	}

	public long getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
