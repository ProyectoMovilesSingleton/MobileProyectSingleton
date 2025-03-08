package com.example.demo.controllers;

import java.util.List;

import com.example.demo.DTOs.PublicarAnuncioDTO;
import com.example.demo.entities.Anuncio;

public interface AnunciosController {
	public List<Anuncio> getAnuncios();
	public boolean publicarAnuncio(PublicarAnuncioDTO dto);
}
