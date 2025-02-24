package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;

public interface MovilController {
	 public ResponseEntity<Optional<MovilDTO>> getMovil(int id); 
	 public ResponseEntity<List<SummarizedMovilDTO>> getMovilesByMarca(String marca);
}
