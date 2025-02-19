package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Movil;

class MovilRespositoryTest {

	@Autowired
	MovilRepository movilRepository;
	
	@Test
	void testFindBymarca() {
		//Cuando existan moviles en la bbdd
		Optional<List<Movil>> bymarca = movilRepository.findBymarca("Samsung");
		assertTrue(!bymarca.get().isEmpty());
	}

}
