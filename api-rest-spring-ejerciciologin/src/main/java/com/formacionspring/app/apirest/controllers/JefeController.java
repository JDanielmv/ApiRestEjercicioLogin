package com.formacionspring.app.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacionspring.app.apirest.entity.Jefe;
import com.formacionspring.app.apirest.service.JefeService;


@RestController
@RequestMapping("/app")
public class JefeController {

	
	@Autowired
	private JefeService servicio;
	
	@GetMapping("/jefes")
	public List<Jefe> jefes(){
		return servicio.findAll();
	}
	
	
	@GetMapping("/jefes/{id}")
	public ResponseEntity<?> mostrarJefes(@PathVariable Long id){
		Jefe jefe=null;
		Map<String,Object> response=new HashMap<>();
		
		try {
			jefe=servicio.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(jefe==null) {
			response.put("mensaje", "El Jefe ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<Jefe>(jefe,HttpStatus.OK);
	}
	
	
	@PutMapping("/jefes/{id}")
	public ResponseEntity<?> updateJefe( @RequestBody Jefe jefe, @PathVariable long id) {
		Jefe jefeActual=servicio.findById(id);
		Map<String,Object> response=new HashMap<>();
		try {
			jefeActual.setNombre(jefe.getDni());
			jefeActual.setNombre(jefe.getNombre());
			jefeActual.setSalario(jefe.getSalario());
			jefeActual.setTelefono(jefe.getTelefono());
			servicio.save(jefeActual);
		
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar modificacion en el Jefe ");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Jefe ha sido modificado  con exito");
		response.put("Jefe", jefeActual);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/jefes/{id}")
	public ResponseEntity<?> deleteJefe(@PathVariable Long id) {
		Jefe jefeBorrado=null;
		
		Map<String,Object> response=new HashMap<>();
				
		jefeBorrado=servicio.findById(id);
			if(jefeBorrado==null) {
				response.put("mensaje", "El Jefe ID: ".concat(id.toString().concat(" no existe en la base de datos")));
				return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

			}else {
				try {
					servicio.delete(id);
					
				} catch (DataAccessException e) {
					response.put("mensaje", "Error al borrar el Jefe ");
					response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

		response.put("mensaje", "El Jefe ha sido borrado con exito");
		response.put("cliente", jefeBorrado);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/jefes")
	public ResponseEntity<?> save(@RequestBody Jefe jefe) {
		Jefe jefeNew=null;
		Map<String,Object> response=new HashMap<>();
		try {
			jefeNew=servicio.save(jefe);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar insercion en la base de datos");
			response.put("error", e.getMessage().concat("_ ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Jefe ha sido creado con exito");
		response.put("Jefe", jefeNew);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
	}
	
}
