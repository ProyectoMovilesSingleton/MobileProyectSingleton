package com.example.demo.DTOs;

import java.sql.Date;

public record MovilDTO(String marca, String modelo, ProcesadorDTO procesador,
		PantallaDTO pantalla, DimensionDTO dimension, double almacenamiento, int ram,
		int peso, int camara, int miliAmperios, boolean NFC, double precio, Date fechaLanzamiento) {

}
