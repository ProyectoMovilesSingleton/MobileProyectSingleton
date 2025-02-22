package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.MovilDTO;
import com.example.demo.services.MovilService;

@RestController
@RequestMapping("moviles")
public class MovilControllerImpl implements MovilController {

	private final MovilService movilService;
	
	
	
	public MovilControllerImpl(MovilService movilService) {
		super();
		this.movilService = movilService;
	}



	@GetMapping("byId")
	@Override
	public ResponseEntity<Optional<MovilDTO>> getMovil(@RequestParam int id) {
		return movilService.getMovilById(id).map(movilDTO -> 
			ResponseEntity.ok().body(Optional.of(movilDTO)))
		.orElse(ResponseEntity.badRequest().eTag("no existe").body(Optional.empty()));
	}

}
