package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pantalla {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private double tamanno;
	@NonNull
	private String tecnologia;
	
	public Pantalla(double tamanno, String tecnologia) {
		super();
		this.tamanno = tamanno;
		this.tecnologia = tecnologia;
	}
}
