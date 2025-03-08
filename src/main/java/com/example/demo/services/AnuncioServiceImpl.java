package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DTOs.PublicarAnuncioDTO;
import com.example.demo.DTOs.UsuarioAnuncioDTO;
import com.example.demo.entities.Anuncio;
import com.example.demo.entities.Usuario;
import com.example.demo.mapper.AnuncioMapper;
import com.example.demo.repositories.AnuncioRepository;

@Service
public class AnuncioServiceImpl implements AnuncioService{

	private final AnuncioRepository anuncioRepository;
	private final AnuncioMapper anuncioMapper;
	private final UsuarioService usuarioService;
	
	public AnuncioServiceImpl(AnuncioRepository anuncioRepository, AnuncioMapper anuncioMapper, UsuarioService usuarioService) {
		super();
		this.anuncioRepository = anuncioRepository;
		this.anuncioMapper = anuncioMapper;
		this.usuarioService = usuarioService;
	}

	@Override
	public List<Anuncio> getAllAnuncios() {
		return anuncioRepository.findAll();
	}

	@Override
	public boolean publicarAnuncio(PublicarAnuncioDTO dto) {
		Usuario user = usuarioService.getUserByUsername(dto.username());
		Anuncio entity = anuncioMapper.mapToEntity(dto);
		entity.setUsuario(user);
		if (anuncioRepository.save(entity) != null) {
			return true;
		} else {
			return false;
		}
	}

}
