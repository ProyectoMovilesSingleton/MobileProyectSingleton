package com.example.demo.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Movil;
import com.example.demo.repositories.MovilRepository;

@SpringBootTest
class MovilFilterTest {
	
	@Autowired
	MovilRepository movilRepository;
	List<Movil> all;
//El beforeEach interrumpe la ejecucion de los métodos
//	@BeforeEach
//	void beforeEach() {
//		all = movilRepository.findAll();
//	}
	
	@Test
	void testNFCFilter() {
		all = movilRepository.findAll();
		MovilNFCFilter filter = new MovilNFCFilter(true);
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(4, list.size());
	}
	
	@Test
	void testMinPrecioFilter() {
		all = movilRepository.findAll();
		MovilMinPrecioFilter filter = new MovilMinPrecioFilter(5d);
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(2, list.size());
	}
	
	@Test
	void testMaxPrecioFilter() {
		all = movilRepository.findAll();
		MovilMaxPrecioFilter filter = new MovilMaxPrecioFilter(2d);
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(5, list.size());
	}
	
	@Test
	void testMinRamFilter() {
		all = movilRepository.findAll();
		MovilMinRAMFilter filter = new MovilMinRAMFilter(4);
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(4, list.size());
	}
	
	@Test
	void testMaxRamFilter() {
		all = movilRepository.findAll();
		MovilMaxRAMFilter filter = new MovilMaxRAMFilter(4);
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(6, list.size());
	}
	
	@Test
	void testPantallaFilter() {
		all = movilRepository.findAll();
		MovilPantallaFilter filter = new MovilPantallaFilter("Mini-LED");
		List<Movil> list = all.stream().filter(movil -> {
			return filter.filter(movil);
		}).toList();
		assertEquals(2, list.size());
	}
}
