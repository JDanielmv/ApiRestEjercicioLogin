package com.formacionspring.app.apirest.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionspring.app.apirest.entity.Usuario;


@Repository
public interface UsuarioDao extends CrudRepository<Usuario, Long>{

	@Query("SELECT u FROM usuarios u WHERE u.user = ?1 and u.password = ?2")
	public Usuario findUser(String user, String password);

	
}
