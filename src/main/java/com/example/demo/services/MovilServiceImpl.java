package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Movil;
import com.example.demo.mapper.MovilMapper;
import com.example.demo.mapper.SummarizedMovilMapper;
import com.example.demo.repositories.MovilRepository;

@Service
public class MovilServiceImpl implements MovilService {
	
	private final MovilRepository movilRepository;
	private final MovilMapper movilMapper;
	private final SummarizedMovilMapper summarizedMovilMapper;
	
	public MovilServiceImpl(MovilRepository movilRepository, MovilMapper movilMapper, SummarizedMovilMapper summarizedMovilMapper) {
		super();
		this.movilRepository = movilRepository;
		this.movilMapper= movilMapper;
		this.summarizedMovilMapper = summarizedMovilMapper;
	}

	@Override
	public List<SummarizedMovilDTO> getMovilesByMarca(String marca) {
		Optional<List<Movil>> bymarca = movilRepository.findBymarca(marca);
		if (bymarca.isPresent()) {
			return bymarca.get()
				.stream()
				.map(movil -> summarizedMovilMapper.mapToDto(movil))
				.toList();
		}
		return  null;
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
	public Optional<AdminMovilDTO> getMovil(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean updateMovil(AdminMovilDTO movilDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<AdminMovilDTO> getAllMoviles() {
		// TODO Auto-generated method stub
		return null;
	}

}
