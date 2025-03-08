package com.example.demo.DTOs;

import com.example.demo.entities.EstadoMovil;

public record PublicarAnuncioDTO(String modelo, EstadoMovil estado, boolean venta, String username) {

}
