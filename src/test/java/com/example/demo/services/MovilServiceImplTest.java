package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTOs.SummarizedMovilDTO;
@SpringBootTest
class MovilServiceImplTest {

	@Autowired
	MovilService movilService;
	
	@Test
	void testGetMovilesByMarca() {
		List<SummarizedMovilDTO> movilesByMarca = movilService.getMovilesByMarca("Samsung");
		assertTrue(!movilesByMarca.isEmpty());
	}
	
	@Test
	void testGetTop5Moviles() {
		List<SummarizedMovilDTO> moviles = movilService.getTop5Moviles();
		assertTrue(!moviles.isEmpty());
		assertEquals(moviles.get(0).marca(), "Xiaomi");
	}

}
