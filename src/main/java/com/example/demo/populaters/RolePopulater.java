package com.example.demo.populaters;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.example.demo.entities.RoleEntity;
import com.example.demo.entities.RoleEnum;
import com.example.demo.repositories.RoleRepository;

import jakarta.annotation.PostConstruct;

@Component
@ConditionalOnProperty(name="spring.jpa.hibernate.ddl-auto",havingValue = "create",matchIfMissing = false)
public class RolePopulater {
	private final RoleRepository roleRepository;

	public RolePopulater(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}
	
	@PostConstruct
    public void init() {
        populateRoles();
    }

    private void populateRoles() {
        for (RoleEnum role : RoleEnum.values()) {
            if (roleRepository.findByName(role).isEmpty()) {
                roleRepository.save(new RoleEntity(role));
            }
        }
    }
}
