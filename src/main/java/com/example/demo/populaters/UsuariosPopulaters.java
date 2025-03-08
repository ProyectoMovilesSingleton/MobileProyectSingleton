package com.example.demo.populaters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.example.demo.DTOs.CreateUserDTO;
import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.RoleEnum;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.UsuarioService;

import jakarta.annotation.PostConstruct;

@ConditionalOnProperty(name="spring.jpa.hibernate.ddl-auto",havingValue = "create",matchIfMissing = false)
@Component
public class UsuariosPopulaters {

	private final UsuarioService usuarioService;
	
	public UsuariosPopulaters( UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	@PostConstruct
	public void Populate() {
		//Un usuario con todos los roles
		String [] adminroles = {"ADMIN", "MODERATOR", "USER"}; 
		usuarioService.createUser(new CreateUserDTO("PepitoGrillo", "pepitoGrillo", adminroles) );
		
		String [] moderatorRoles = {"MODERATOR", "USER"};
		usuarioService.createUser(new CreateUserDTO("Juanillo", "juanillo", moderatorRoles));
		
		String [] userRoleStrings = {"USER"};
		List<CreateUserDTO> of = List.of(
			new CreateUserDTO("me1", "me1", moderatorRoles),
			new CreateUserDTO("me2", "me2", moderatorRoles),
			new CreateUserDTO("me3", "me3", moderatorRoles),
			new CreateUserDTO("me4", "me4", moderatorRoles),
			new CreateUserDTO("me5", "me5", moderatorRoles)
		);
		
		of.stream().forEach(dto -> {
			usuarioService.createUser(dto);		
		});
		
		
	}
	

}
