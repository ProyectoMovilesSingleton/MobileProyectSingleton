package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTOs.PublicarAnuncioDTO;
import com.example.demo.entities.Anuncio;

@Mapper(componentModel = "spring")
public interface AnuncioMapper {
	public PublicarAnuncioDTO mapToDto(Anuncio anuncio);
	@Mapping(target = "id", ignore =true)
	public Anuncio mapToEntity(PublicarAnuncioDTO dto);
}
