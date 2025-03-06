package com.example.demo.mapper;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.entities.Movil;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AdminMovilMapper {

    public AdminMovilDTO mapToAdminMovilDTO(Movil movil);

    public Movil mapToEntityMovil(AdminMovilDTO adminMovilDTO);
}
