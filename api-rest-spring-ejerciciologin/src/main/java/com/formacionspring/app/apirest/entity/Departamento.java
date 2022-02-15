package com.formacionspring.app.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="departamentos")
public class Departamento implements Serializable{

	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idDep;
	
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String ubicacion;
	public long getIdDep() {
		return idDep;
	}
	public void setIdDep(long idDep) {
		this.idDep = idDep;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
