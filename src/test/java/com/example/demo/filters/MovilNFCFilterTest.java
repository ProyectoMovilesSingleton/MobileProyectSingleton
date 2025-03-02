package com.example.demo.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Movil;
import com.example.demo.repositories.MovilRepository;

@SpringBootTest
class MovilNFCFilterTest {
	
	@Autowired
	MovilRepository movilRepository;
	
	@Test
	void testFilter() {
		List<Movil> all = movilRepository.findAll();
//		all.stream().forEach(movil -> System.out.print(movil.isNFC() + "\n"));
		MovilNFCFilter filter = new MovilNFCFilter(true);
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(4, list.size());
		
		
	}

}
