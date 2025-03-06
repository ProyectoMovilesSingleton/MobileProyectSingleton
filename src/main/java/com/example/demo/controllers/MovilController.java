package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.MovilFilterDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;

public interface MovilController {
	 public ResponseEntity<Optional<MovilDTO>> getMovil(int id); 
	 public ResponseEntity<List<SummarizedMovilDTO>> getMovilesByMarca(String marca);
	 public ResponseEntity<Set<MovilDTO>> compareTwoMoviles(int idMovil1, int idMovil2);
	 public ResponseEntity<List<SummarizedMovilDTO>> getTop5Moviles();
	 
	 //CRUD Admin
	 //A modo de referencia (cambiar si es necesario)
	 public ResponseEntity<Boolean> deleteMovil(int id);
	 public ResponseEntity<Boolean> saveMovil(AdminMovilDTO movilDTO);
	 public ResponseEntity<Boolean> updateMovil(AdminMovilDTO movilDTO);
	 public ResponseEntity<AdminMovilDTO> getMovilAdmin(int id);
	 
	 //Para los filtros de búsqueda obligatorios
	 public ResponseEntity<List<SummarizedMovilDTO>> getMovilesByFilters(MovilFilterDTO movilFilterDTO);
}
