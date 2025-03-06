package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.CreateUserDTO;
import com.example.demo.services.UsuarioServiceImpl;

@RestController
@RequestMapping("moviles/usuario")
public class ControllerUsuario {
	private final UsuarioServiceImpl usuarioServiceImpl;
	
	
	public ControllerUsuario(UsuarioServiceImpl usuarioServiceImpl) {
		super();
		this.usuarioServiceImpl = usuarioServiceImpl;
	}
	
	@PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody CreateUserDTO createUserDTO) {
        if (usuarioServiceImpl.createUser(createUserDTO)) {
        	return ResponseEntity.status(HttpStatus.OK).body("Usuario creado con éxito");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al crear el usuario");        
    }
}
