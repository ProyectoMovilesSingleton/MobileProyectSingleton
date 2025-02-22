package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Movil;

public interface MovilService {
	//Para el usuario
	public List<SummarizedMovilDTO> getMovilesByMarca(String marca);
	public Optional<MovilDTO> getMovilById(int id);
	//TODO
	public List<SummarizedMovilDTO> getMovilesByFilters();
	//Para el admin
	public List<MovilDTO> getAllMoviles();
	public boolean delete(int id);
	public boolean addNewMovil(MovilDTO movil);
	
	
	//Para el programa
	public boolean save(Movil movil);
	
	
}
