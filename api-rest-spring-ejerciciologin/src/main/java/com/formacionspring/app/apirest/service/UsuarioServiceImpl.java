package com.formacionspring.app.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionspring.app.apirest.dao.UsuarioDao;
import com.formacionspring.app.apirest.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDao service;

	@Override
	public Usuario findUser(String user, String password) {
		// TODO Auto-generated method stub
		return service.findUser(user,password);
	}

	
	
	
	

}
