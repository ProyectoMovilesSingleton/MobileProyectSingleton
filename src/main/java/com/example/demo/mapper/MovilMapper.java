package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.DTOs.MovilDTO;
import com.example.demo.entities.Movil;

@Mapper (componentModel = "spring")
public interface MovilMapper {
	public MovilDTO mapToDto(Movil movil);

}
