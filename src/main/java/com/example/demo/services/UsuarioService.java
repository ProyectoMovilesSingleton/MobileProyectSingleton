package com.example.demo.services;

import com.example.demo.DTOs.CreateUserDTO;
import com.example.demo.entities.Usuario;

import jakarta.servlet.http.HttpServletResponse;

public interface UsuarioService {
	public boolean createUser(CreateUserDTO createUserDTO);
	boolean delete(String username);         // Método para eliminar un usuario por nombre de usuario
    void refreshingToken(HttpServletResponse response, String authorizationHeader) throws Exception; // Método para refrescar el token
    Usuario getUserByUsername(String username); // Método para obtener un usuario por nombre de usuario
}
