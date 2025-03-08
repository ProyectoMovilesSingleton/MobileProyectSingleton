package com.example.demo.services;

import java.util.List;

import com.example.demo.DTOs.PublicarAnuncioDTO;
import com.example.demo.entities.Anuncio;

public interface AnuncioService {
	public List<Anuncio> getAllAnuncios();
	public boolean publicarAnuncio(PublicarAnuncioDTO dto);
}
