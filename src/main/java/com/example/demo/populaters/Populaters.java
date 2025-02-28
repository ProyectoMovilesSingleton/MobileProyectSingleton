package com.example.demo.populaters;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Dimension;
import com.example.demo.entities.Movil;
import com.example.demo.entities.Pantalla;
import com.example.demo.entities.Procesador;
import com.example.demo.repositories.DimensionRepository;
import com.example.demo.repositories.MovilRepository;
import com.example.demo.repositories.PantallaRepository;
import com.example.demo.repositories.ProcesadorRepository;

import jakarta.annotation.PostConstruct;

@Component
@ConditionalOnProperty(name="spring.jpa.hibernate.ddl-auto",havingValue = "create",matchIfMissing = false)
public class Populaters {
	
	private final MovilRepository movilRepository;
	private final DimensionRepository dimensionRepository;
	private final PantallaRepository pantallaRepository;
	private final ProcesadorRepository procesadorRepository;
	private String[] marcas = { "Samsung", "Apple", "Xiaomi", "OnePlus", "Google" };
    private String[] modelos = { "S23", "iPhone 14", "Mi 13", "Nord 2", "Pixel 7" };
    private double[] almacenamientosMoviles = {64.0, 128.0, 256.0, 512.0, 1024.0};
    private int[] ramOpciones = {1, 2, 3, 4, 6, 8, 12, 16, 32};
    private int[] baterias = {2000, 2500, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 7000};
    private boolean[] nfc= {true,false};
    
	public Populaters(MovilRepository movilRepository, DimensionRepository dimensionRepository,
			PantallaRepository pantallaRepository, ProcesadorRepository procesadorRepository) {
		super();
		this.movilRepository = movilRepository;
		this.dimensionRepository = dimensionRepository;
		this.pantallaRepository = pantallaRepository;
		this.procesadorRepository = procesadorRepository;
	}

	@PostConstruct
	public void Populate() {
		//Aun hay que hacer que llene todos los datos de moviles
		List<Dimension> dimensiones = List.of(
	            new Dimension(0.5, 10.0, 20.0),
	            new Dimension(1.0, 15.0, 25.0),
	            new Dimension(0.8, 12.5, 22.5),
	            new Dimension(0.6, 14.0, 24.0),
	            new Dimension(0.7, 11.5, 21.5),
	            new Dimension(1.2, 16.0, 26.0),
	            new Dimension(0.9, 13.0, 23.0),
	            new Dimension(1.1, 17.0, 27.0),
	            new Dimension(0.4, 9.5, 19.5),
	            new Dimension(0.3, 8.0, 18.0)
	        );
		dimensionRepository.saveAll(dimensiones);
		
        List<Pantalla> pantallas = List.of(
                new Pantalla(5.5, "OLED"),
                new Pantalla(6.1, "AMOLED"),
                new Pantalla(6.7, "LCD"),
                new Pantalla(5.8, "IPS"),
                new Pantalla(7.0, "Mini-LED"),
                new Pantalla(6.5, "Super AMOLED"),
                new Pantalla(5.0, "TFT"),
                new Pantalla(6.3, "E-Ink"),
                new Pantalla(7.2, "QLED"),
                new Pantalla(5.9, "Micro-LED")
            );
        pantallaRepository.saveAll(pantallas);
        
        List<Procesador> procesadores = List.of(
                new Procesador("Intel Core i9", 8, 5.3),
                new Procesador("AMD Ryzen 9", 12, 4.8),
                new Procesador("Apple M1", 8, 3.2),
                new Procesador("Snapdragon 8 Gen 2", 8, 3.36),
                new Procesador("Exynos 2200", 8, 3.0),
                new Procesador("MediaTek Dimensity 9000", 8, 3.05),
                new Procesador("Intel Core i7", 6, 4.9),
                new Procesador("AMD Ryzen 7", 8, 4.5),
                new Procesador("Apple M2", 10, 3.5),
                new Procesador("Intel Xeon", 16, 3.8)
            );
        procesadorRepository.saveAll(procesadores);
        
        List<Movil> moviles = List.of(
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber())),
        		new Movil(selectorRnd(marcas), selectorRnd(modelos), getRandomStorage(almacenamientosMoviles), getRandomIntArray(ramOpciones), getRndNumber(), getRndNumber(), getRandomIntArray(baterias), getRandomBoolean(nfc), getRndNumber(), Date.valueOf(LocalDate.now()), 0, procesadores.get(getRndNumber()), pantallas.get(getRndNumber()), dimensiones.get(getRndNumber()))
        		);
        movilRepository.saveAll(moviles);
	}
	
	private String selectorRnd(String [] strings) {
		Random random = new Random();
		int i = random.nextInt(5);
		return strings[i];
	}
	
	private int getRndNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}
	
	private double getRandomStorage(double[] almacenamientos) {
		Random random=new Random();
		return almacenamientos[random.nextInt(almacenamientosMoviles.length)];
	}
	
	private int getRandomIntArray(int[] arrayInt) {
	    Random random = new Random();
	    return arrayInt[random.nextInt(ramOpciones.length)];
	}
	
	private boolean getRandomBoolean(boolean[] booleans) {
	    Random random = new Random();
	    return booleans[random.nextInt(booleans.length)];  // Corregido a booleans.length
	}
}
