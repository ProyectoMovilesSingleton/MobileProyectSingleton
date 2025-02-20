package com.example.demo.repositories;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Movil;
@SpringBootTest
class MovilRespositoryTest {

	@Autowired
	MovilRepository movilRepository;
	
	@Test
	void testFindBymarca() {
		Optional<List<Movil>> bymarca = movilRepository.findBymarca("Samsung");
		assertTrue(!bymarca.get().isEmpty());
	}

}
