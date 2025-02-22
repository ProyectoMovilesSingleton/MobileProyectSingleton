package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.DTOs.MovilDTO;

public interface MovilController {
	 public ResponseEntity<Optional<MovilDTO>> getMovil(int id); 
}
