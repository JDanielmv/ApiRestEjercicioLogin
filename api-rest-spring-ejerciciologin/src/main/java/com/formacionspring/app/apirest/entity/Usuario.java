package com.formacionspring.app.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="usuarios")
public class Usuario implements Serializable{

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id; 
	@Column(nullable=false)
	private String user;
	@Column(nullable=false, unique=true)
	private String password;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
