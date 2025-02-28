package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Movil;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Integer> {
	public Optional<List<Movil>> findBymarca(String marca);

//	SELECT * FROM movilesproject.movil order by visualizaciones desc limit 5;
	public Optional<List<Movil>> findTop5ByOrderByVisualizacionesDesc();
}
