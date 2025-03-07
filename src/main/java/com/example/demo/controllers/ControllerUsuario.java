package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.CreateUserDTO;
import com.example.demo.DTOs.LoginDTO;
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
	
	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        try {
            String token = usuarioServiceImpl.loginUser(loginDTO.username(), loginDTO.password());
            return ResponseEntity.ok().body("{\"token\": \"" + token + "\"}");
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}
