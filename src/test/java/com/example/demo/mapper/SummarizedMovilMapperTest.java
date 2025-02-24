package com.example.demo.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Dimension;
import com.example.demo.entities.Movil;
import com.example.demo.entities.Pantalla;
import com.example.demo.entities.Procesador;
@SpringBootTest
class SummarizedMovilMapperTest {
	@Autowired
	SummarizedMovilMapper summarizedMovilMapper;
	
	@Test
	void testMapToDto() {
		Dimension dimension = new Dimension(1d,1d,1d);
		Procesador procesador = new Procesador("Alguno", 1, 2d);
		Pantalla pantalla = new Pantalla(1d, "OLED");
		Movil movil = new Movil("Alguna", "Alguna",Date.valueOf(LocalDate.now()), procesador, pantalla, dimension);
		SummarizedMovilDTO mapToDto = summarizedMovilMapper.mapToDto(movil);
		assertTrue(mapToDto.getClass().equals(SummarizedMovilDTO.class));
		assertEquals(movil.getAlmacenamiento(), mapToDto.almacenamiento());
	}

}
