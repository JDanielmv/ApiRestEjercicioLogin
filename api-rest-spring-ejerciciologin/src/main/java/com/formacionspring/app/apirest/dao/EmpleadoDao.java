package com.formacionspring.app.apirest.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionspring.app.apirest.entity.Empleado;


public interface EmpleadoDao extends CrudRepository<Empleado, Long>{

}
