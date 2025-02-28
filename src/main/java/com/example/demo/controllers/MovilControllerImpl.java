package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;
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


	@GetMapping("byMarca")
	@Override
	public ResponseEntity<List<SummarizedMovilDTO>> getMovilesByMarca(@RequestParam String marca) {
		List<SummarizedMovilDTO> movilesByMarca = movilService.getMovilesByMarca(marca);
		if (!movilesByMarca.isEmpty()) {
			return ResponseEntity.ok().body(movilesByMarca);
		} else {
			return ResponseEntity.badRequest().eTag("No existen moviles con la marca" + marca).body(movilesByMarca);
		}
	}


	//Poner para que solo pueda acceder el administrador a estos métodos

	@Override
	public ResponseEntity<Boolean> deleteMovil(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResponseEntity<Boolean> saveMovil(AdminMovilDTO movilDTO) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResponseEntity<Boolean> updateMovil(AdminMovilDTO movilDTO) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResponseEntity<AdminMovilDTO> getMovilAdmin(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResponseEntity<List<SummarizedMovilDTO>> getTop5Moviles() {
		List<SummarizedMovilDTO> moviles = movilService.getTop5Moviles();
		if (!moviles.isEmpty()) {
			return ResponseEntity.ok().body(moviles);
		} else {
			return ResponseEntity.badRequest().eTag("No se encontraron moviles").body(moviles);
		}
	}
	
	

}
