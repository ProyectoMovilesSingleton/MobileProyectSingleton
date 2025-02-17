package com.example.demo.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@NonNull
	String tipo;
	@NonNull
	int nucleos;
	@NonNull
	double velocidadMaxima;
}
