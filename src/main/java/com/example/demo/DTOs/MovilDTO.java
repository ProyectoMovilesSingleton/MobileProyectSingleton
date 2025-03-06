package com.example.demo.DTOs;

import java.sql.Date;

public record MovilDTO(String marca, String modelo, ProcesadorDTO procesador,
		PantallaDTO pantalla, DimensionDTO dimension, Double almacenamiento, Integer ram,
					   Integer peso, Integer camara, Integer miliAmperios, Boolean NFC, Double precio, Date fechaLanzamiento) {

}
