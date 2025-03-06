package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DTOs.MovilFilterDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Dimension;
import com.example.demo.entities.Movil;
import com.example.demo.entities.Pantalla;
import com.example.demo.entities.Procesador;
import com.example.demo.repositories.DimensionRepository;
import com.example.demo.repositories.MovilRepository;
import com.example.demo.repositories.PantallaRepository;
import com.example.demo.repositories.ProcesadorRepository;
@SpringBootTest
class MovilServiceImplTestFiltrosObligatorios {
	@Autowired
	MovilRepository movilRepository;
	@Autowired
	MovilServiceImpl movilServiceImpl;
    @Autowired
    private ProcesadorRepository procesadorRepository;
    @Autowired
    private PantallaRepository pantallaRepository;
    @Autowired
    private DimensionRepository dimensionRepository;
    
	@BeforeEach
    public void setUp() {
        // Crear las entidades relacionadas necesarias
        Procesador procesador = new Procesador("Snapdragon", 8, 2.84);
        Pantalla pantalla = new Pantalla(6.5, "AMOLED");
        Dimension dimension = new Dimension(0.8, 7.0, 15.0);

        // Guardar las entidades relacionadas en la base de datos
        procesadorRepository.save(procesador);
        pantallaRepository.save(pantalla);
        dimensionRepository.save(dimension);

        // Crear los objetos Movil y asociar las entidades relacionadas
        Movil movil1 = new Movil(
                "Samsung", "Galaxy S21", 128.0, 8, 170, 108, 4000, true, 10.0,
                Date.valueOf("2021-01-14"), 5000, procesador, pantalla, dimension
        );
        Movil movil2 = new Movil(
                "Apple", "iPhone 13", 128.0, 8, 150, 12, 3200, true, 10.0,
                Date.valueOf("2021-09-24"), 10000, procesador, pantalla, dimension
        );

        // Guardar los objetos Movil en la base de datos
        movilRepository.save(movil1);
        movilRepository.save(movil2);
    }
	
	@Test
	void testGetMovilesByFilters() {
		MovilFilterDTO movilFilterDTOUno=new MovilFilterDTO(1.0, 20.0, 8, true, "AMOLED", "Apple");
		List<SummarizedMovilDTO> movilesByFiltersUno = movilServiceImpl.getMovilesByFilters(movilFilterDTOUno);
		assertEquals(1, movilesByFiltersUno.size());
		MovilFilterDTO movilFilterDTODos=new MovilFilterDTO(0.0, 0.0, 8, true, "NoExiste", "Marca");		
		List<SummarizedMovilDTO> movilesByFiltersDos = movilServiceImpl.getMovilesByFilters(movilFilterDTODos);
		assertEquals(0, movilesByFiltersDos.size());
	}
}
