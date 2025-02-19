package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Movil;
@Mapper (componentModel = "spring")
public interface SummarizedMovilMapper{
	//Posiblemente no se quede asi
	public SummarizedMovilDTO mapToDto(Movil movil);
}
