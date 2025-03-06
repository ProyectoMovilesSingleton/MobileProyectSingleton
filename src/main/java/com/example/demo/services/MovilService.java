package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.MovilFilterDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;

public interface MovilService {
	//Para el usuario
	public List<SummarizedMovilDTO> getMovilesByMarca(String marca);
	public Optional<MovilDTO> getMovilById(int id);
	public Set<MovilDTO> compareTwoMoviles(int id1, int id2);
	public List<SummarizedMovilDTO> getTop5Moviles();
	
	//Criterios de búsqueda obligatorios
	public List<SummarizedMovilDTO> getMovilesByFilters(MovilFilterDTO movilFilterDTO);
	
	//TODO
	//Para el admin
	public List<AdminMovilDTO> getAllMoviles();
	public Optional<AdminMovilDTO> getMovil(int id);
	public boolean updateMovil(AdminMovilDTO movilDTO);
	public boolean delete(int id);
	public boolean addNewMovil(MovilDTO movilDTO);
}
