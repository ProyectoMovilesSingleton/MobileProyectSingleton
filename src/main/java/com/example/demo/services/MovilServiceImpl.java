package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Movil;
import com.example.demo.mapper.MovilMapper;
import com.example.demo.repositories.MovilRepository;

@Service
public class MovilServiceImpl implements MovilService {
	
	private MovilRepository movilRepository;
	private MovilMapper movilMapper;
	
	public MovilServiceImpl(MovilRepository movilRepository, MovilMapper movilMapper) {
		super();
		this.movilRepository = movilRepository;
		this.movilMapper= movilMapper;
	}

	@Override
	public List<SummarizedMovilDTO> getMovilesByMarca(String marca) {
		Optional<List<Movil>> bymarca = movilRepository.findBymarca(marca);
		//TODO
		return null;
	}
	@Override
	public Optional<MovilDTO> getMovilById(int id) {
		Optional<Movil> byId = movilRepository.findById(id);
		if (byId.isPresent()) {
			return Optional.of(movilMapper.mapToDto(byId.get()));
		} 
		return Optional.empty();
	}

	@Override
	public List<SummarizedMovilDTO> getMovilesByFilters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovilDTO> getAllMoviles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		try {
		movilRepository.deleteById(id); 
		return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean addNewMovil(MovilDTO movil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(Movil movil) {
		Movil save = movilRepository.save(movil);
		if (save!=null) {
			return true;
		}
		else return false;
	}

	

}
