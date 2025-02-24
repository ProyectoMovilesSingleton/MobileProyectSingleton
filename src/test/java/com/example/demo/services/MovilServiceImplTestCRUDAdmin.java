package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.entities.Movil;

@SpringBootTest
class MovilServiceImplTestCRUDAdmin {
	
	@MockitoBean
	MovilService movilService;
	Movil movilOne;
	Movil movilTwo;
	
	@Test
	void testAddNewMovil() {
		when(this.movilService.addNewMovil(null)).thenReturn(false);
		assertFalse(movilService.addNewMovil(null));
		//TODO
	}

	@Test
	void testGetMovil() {
		when(this.movilService.getMovil(anyInt())).thenReturn(Optional.empty());
		Optional<AdminMovilDTO> movil = movilService.getMovil(0);
		assertTrue(movil.isEmpty());
		AdminMovilDTO value = new AdminMovilDTO(0, null, null, null,
						null, null, 0, 0, 0, 0, 0, false, 0, null);
		when(this.movilService.getMovil(anyInt())).thenReturn(Optional.of(value));
		movil = movilService.getMovil(0);
		assertEquals(value, movil.get());
	}

	@Test
	void testUpdateMovil() {
		when(this.movilService.updateMovil(null)).thenReturn(false);
		assertFalse(movilService.updateMovil(null));
		when(this.movilService.updateMovil(any())).thenReturn(true);
		assertTrue(movilService.updateMovil(new AdminMovilDTO(1, "Samsung", "Xiaomi",
					null, null, null, 0, 0, 0, 0, 0, false, 0, null)));
		//TODO
	}

	@Test
	void testGetAllMoviles() {
		//TODO
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

}
