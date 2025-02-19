package com.example.demo.entities;

import java.sql.Date;

import com.example.demo.DTOs.DimensionDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private String marca;
	@NonNull
	private String modelo;
	
	@ManyToOne
	@NonNull
	private Procesador procesador;
	@ManyToOne
	@NonNull
	private Pantalla pantalla;
	@ManyToOne
	@NonNull
	private Dimension dimension;
	private double almacenamiento;
	private int ram;
	private int peso;
	private int camara;
	private int miliAmperios;
	private boolean NFC;
	private double precio;
	@NonNull
	private Date fechaLanzamiento; 
	
	
	
	
}
