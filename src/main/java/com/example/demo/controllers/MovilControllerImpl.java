package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.MovilFilterDTO;
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
	
	@Override
	@GetMapping("compare")
	public ResponseEntity<Set<MovilDTO>> compareTwoMoviles(@RequestParam int idMovil1,@RequestParam int idMovil2) {
		Set<MovilDTO> compareTwoMoviles = movilService.compareTwoMoviles(idMovil1, idMovil2);
		if (compareTwoMoviles.size()==2) {
			return ResponseEntity.ok(compareTwoMoviles);
		} else {
			return ResponseEntity.badRequest().eTag("No se puede realizar la comparacion").body(compareTwoMoviles);
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
	
	@Override
	@PostMapping("filtrar")
	public ResponseEntity<List<SummarizedMovilDTO>> getMovilesByFilters(@RequestBody MovilFilterDTO movilFilterDTO) {
		List<SummarizedMovilDTO> movilesByFilters = movilService.getMovilesByFilters(movilFilterDTO);
		if(movilesByFilters.isEmpty() && movilesByFilters.size()==0) {
			return ResponseEntity.noContent().eTag("No hay móviles con las características introducidas").build();	//Build porque si no hay moviles con los parámetros introducidos, no tenemos body para el ResponseEntity
		}
		return ResponseEntity.status(HttpStatus.OK).body(movilesByFilters);
	}
}
