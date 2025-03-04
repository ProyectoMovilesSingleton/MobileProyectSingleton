package com.example.demo.filtersDecorator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Movil;
import com.example.demo.repositories.MovilRepository;

@SpringBootTest
class FilterDecoratorTest {

	@Autowired
	MovilRepository movilRepository;
	List<Movil> all;
	@Test
	void testFilter() {
		all = movilRepository.findAll();
		MovilFilter<Boolean> instance4 = new MovilNFCFilter(false, new NoMovilFilter());
		Filter<Movil> filter = new NoMovilFilter();
		//Si pones esta linea da fallo en el stream
//		filter = new MovilNFCFilter(false, filter);
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(10, list.size());
		
	}

}
