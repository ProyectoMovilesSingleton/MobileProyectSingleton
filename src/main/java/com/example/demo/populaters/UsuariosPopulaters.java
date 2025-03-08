package com.example.demo.populaters;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.RoleEnum;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UsuarioRepository;

import jakarta.annotation.PostConstruct;

@ConditionalOnProperty(name="spring.jpa.hibernate.ddl-auto",havingValue = "create",matchIfMissing = false)
@Component
public class UsuariosPopulaters {

	private final UsuarioRepository usuarioRepository;
	private final RoleRepository roleRepository;
	
	public UsuariosPopulaters(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.roleRepository = roleRepository;
	}
	@PostConstruct
	public void Populate() {
		//Un usuario con todos los roles
		Set<RoleEntity> roles = new HashSet<>();
		roles.add(roleRepository.findByName(RoleEnum.ADMIN).get());
		roles.add(roleRepository.findByName(RoleEnum.MODERATOR).get());
		roles.add(roleRepository.findByName(RoleEnum.USER).get());
		//Lo añado de esta manera porque cuando intentas meterlo con el constructor entero da fallo aparentemente por el id
		Usuario admin = new Usuario("pepitogrillo@gmail.com", "PepitoGrillo", "pepitoGrillo");
		admin.setRoles(roles);
		usuarioRepository.save(admin);
		
		roles.remove(roleRepository.findByName(RoleEnum.ADMIN).get());
		Usuario moderator = new Usuario("juanito@gmail.com", "Juanito", "juanito");
		moderator.setRoles(roles);
		usuarioRepository.save(moderator);
		
		List<Usuario> of = List.of(new Usuario("me1@gmail.com", "me1", "me1"),
				new Usuario("me2@gmail.com", "me2", "me2"),
				new Usuario("me3@gmail.com", "me3", "me3"),
				new Usuario("me4@gmail.com", "me4", "me4"),
				new Usuario("me5@gmail.com", "me5", "me5")
				);
		
		roles.remove(roleRepository.findByName(RoleEnum.MODERATOR).get());
		of.stream().forEach(user -> {
			user.setRoles(roles);
		});
		usuarioRepository.saveAll(of);
		
	}
	

}
