package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Movil;
@Mapper (componentModel = "spring")
public interface SummarizedMovilMapper{
	@Mapping(target = "nucleosProcesador", source = "movil.procesador.nucleos")
	public SummarizedMovilDTO mapToDto(Movil movil);
}
