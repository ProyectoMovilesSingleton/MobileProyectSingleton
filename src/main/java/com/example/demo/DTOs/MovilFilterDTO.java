package com.example.demo.DTOs;

public record MovilFilterDTO(Double precioMin,Double precioMax,Integer ram,Boolean nfc,String tecnologiaPantalla,String marca) {	//Double, Integer y Boolean para compararlo con null en MovilServiceImpl

}
