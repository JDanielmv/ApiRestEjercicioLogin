package com.formacionspring.app.apirest.service;

import java.util.List;

import com.formacionspring.app.apirest.entity.Usuario;


public interface UsuarioService {

	public Usuario findUser(String user, String password);
}
