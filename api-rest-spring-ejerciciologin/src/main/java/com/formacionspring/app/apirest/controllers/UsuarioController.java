package com.formacionspring.app.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspring.app.apirest.entity.Jefe;
import com.formacionspring.app.apirest.entity.Usuario;
import com.formacionspring.app.apirest.service.UsuarioService;

@RestController
@RequestMapping("/app")
public class UsuarioController {

	@Autowired
	private UsuarioService servicio;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Usuario user) {
		Usuario userNew=null;
		Map<String,Object> response=new HashMap<>();
		try {
			userNew=servicio.findUser(user.getUser(), user.getPassword());
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insercion en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Jefe ha sido creado con exito");
		response.put("Jefe", user);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
	
	

}
