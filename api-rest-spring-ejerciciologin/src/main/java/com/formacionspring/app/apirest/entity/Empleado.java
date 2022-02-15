package com.formacionspring.app.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name="empleados")
public class Empleado implements Serializable{

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false, unique=true)
	private String dni;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private double salario;
	private int telefono;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_Dep")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Departamento idDep;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
	public Departamento getIdDep() {
		return idDep;
	}

	public void setIdDep(Departamento idDep) {
		this.idDep = idDep;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
