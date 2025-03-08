package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.PublicarAnuncioDTO;
import com.example.demo.entities.Anuncio;
import com.example.demo.services.AnuncioService;


@RestController
@RequestMapping("anuncios")
public class AnunciosControllerImpl implements AnunciosController {

	private final AnuncioService anuncioService;
	
	public AnunciosControllerImpl(AnuncioService anuncioService) {
		super();
		this.anuncioService = anuncioService;
	}
	@Override
	@GetMapping("all")
	public List<Anuncio> getAnuncios() {
		// TODO
		return null;
	}
	@Override
	@PostMapping("nuevo")
	public boolean publicarAnuncio(@RequestBody PublicarAnuncioDTO dto) {
		return anuncioService.publicarAnuncio(dto);
	}

}
