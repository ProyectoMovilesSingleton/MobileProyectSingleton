package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTOs.AdminMovilDTO;
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
	public List<AdminMovilDTO> getAllMoviles();
	public Optional<AdminMovilDTO> getMovil(int id);
	public boolean updateMovil(AdminMovilDTO movilDTO);
	public boolean delete(int id);
	public boolean addNewMovil(MovilDTO movilDTO);
	
}
