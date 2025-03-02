package com.example.demo.entities;

import java.sql.Date;

import com.example.demo.DTOs.DimensionDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Movil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int id;
	@NonNull
	private String marca;
	@NonNull
	private String modelo;
	private double almacenamiento;
	private int ram;
	private int peso;
	private int camara;
	private int miliAmperios;
	private boolean NFC;
	private double precio;
	@NonNull
	private Date fechaLanzamiento;
	private int visualizaciones;
	@ManyToOne
	@NonNull
	private Procesador procesador;
	@ManyToOne
	@NonNull
	private Pantalla pantalla;
	@ManyToOne
	@NonNull
	private Dimension dimension;
	
	
	//Para Populaters
	public Movil(@NonNull String marca, @NonNull String modelo, double almacenamiento, int ram, int peso, int camara,
			int miliAmperios, boolean nFC, double precio, @NonNull Date fechaLanzamiento, int visualizaciones,
			@NonNull Procesador procesador, @NonNull Pantalla pantalla, @NonNull Dimension dimension) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.miliAmperios = miliAmperios;
		NFC = nFC;
		this.precio = precio;
		this.fechaLanzamiento = fechaLanzamiento;
		this.visualizaciones = visualizaciones;
		this.procesador = procesador;
		this.pantalla = pantalla;
		this.dimension = dimension;
	}
}
