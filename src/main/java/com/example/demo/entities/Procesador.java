package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	int id;
	@NonNull
	String tipo;
	@NonNull
	int nucleos;
	@NonNull
	double velocidadMaxima;
}
