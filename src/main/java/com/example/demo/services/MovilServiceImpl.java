package com.example.demo.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.entities.Pantalla;
import com.example.demo.entities.Procesador;
import com.example.demo.mapper.AdminMovilMapper;
import com.example.demo.repositories.DimensionRepository;
import com.example.demo.repositories.PantallaRepository;
import com.example.demo.repositories.ProcesadorRepository;
import org.springframework.stereotype.Service;

import com.example.demo.DTOs.AdminMovilDTO;
import com.example.demo.DTOs.MovilDTO;
import com.example.demo.DTOs.MovilFilterDTO;
import com.example.demo.DTOs.SummarizedMovilDTO;
import com.example.demo.entities.Movil;
import com.example.demo.mapper.MovilMapper;
import com.example.demo.mapper.SummarizedMovilMapper;
import com.example.demo.repositories.MovilRepository;

@Service
public class MovilServiceImpl implements MovilService {

	private final MovilRepository movilRepository;
	private final MovilMapper movilMapper;
	private final SummarizedMovilMapper summarizedMovilMapper;
	private final AdminMovilMapper adminMovilMapper;
	private final DimensionRepository dimensionRepository;
	private final PantallaRepository pantallaRepository;
	private final ProcesadorRepository procesadorRepository;

	public MovilServiceImpl(MovilRepository movilRepository, MovilMapper movilMapper, SummarizedMovilMapper summarizedMovilMapper, AdminMovilMapper adminMovilMapper, DimensionRepository dimensionRepository, PantallaRepository pantallaRepository, ProcesadorRepository procesadorRepository) {
		super();
		this.movilRepository = movilRepository;
		this.movilMapper= movilMapper;
		this.summarizedMovilMapper = summarizedMovilMapper;
		this.adminMovilMapper =  adminMovilMapper;
        this.dimensionRepository = dimensionRepository;
        this.pantallaRepository = pantallaRepository;
        this.procesadorRepository = procesadorRepository;
    }

	@Override
	public List<SummarizedMovilDTO> getMovilesByMarca(String marca) {
		Optional<List<Movil>> bymarca = movilRepository.findBymarca(marca);
		if (bymarca.isPresent()) {
			return bymarca.get()
				.stream()
				.map(movil -> summarizedMovilMapper.mapToDto(movil))
				.toList();
		}
		return  null;
	}

	@Override
	public Optional<MovilDTO> getMovilById(int id) {
		Optional<Movil> byId = movilRepository.findById(id);
		if (byId.isPresent()) {
			return Optional.of(movilMapper.mapToDto(byId.get()));
		}
		return Optional.empty();
	}
	
	@Override
	public boolean delete(int id) {
		try {
		movilRepository.deleteById(id);
		return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean addNewMovil(MovilDTO movil) {
	   	Movil movilentity = movilMapper.mapToEntity(movil);
		   dimensionRepository.save(movilentity.getDimension());
		   pantallaRepository.save(movilentity.getPantalla());
		   procesadorRepository.save(movilentity.getProcesador());
		   movilentity.setVisualizaciones(0);
		   movilRepository.save(movilentity);
		   if (getMovil(movilentity.getId()).isPresent()){
			   return true;
		   }
		   return false;
	}

	@Override
	public Optional<AdminMovilDTO> getMovil(int id) {
		return Optional.of(adminMovilMapper.mapToAdminMovilDTO(movilRepository.findById(id).get()));
	}

	@Override
	public boolean updateMovil(AdminMovilDTO newMovilDTO) {
		Movil entity = adminMovilMapper.mapToEntityMovil(newMovilDTO);
		if (delete(entity.getId())){
			MovilDTO movilDTO = movilMapper.mapToDto(entity);
			addNewMovil(movilDTO);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Movil> getAllMoviles() {
		return movilRepository.findAll();
	}

	@Override
	public List<SummarizedMovilDTO> getTop5Moviles() {
		Optional<List<Movil>> moviles = movilRepository.findTop5ByOrderByVisualizacionesDesc();
		if (moviles.isPresent()) {
			return moviles.get()
				.stream()
				.map(movil -> summarizedMovilMapper.mapToDto(movil))
				.toList();
		}
		movilRepository.findTop5ByOrderByVisualizacionesDesc();
		return null;
	}

	@Override
	public Set<MovilDTO> compareTwoMoviles(int id1, int id2) {
		Set<MovilDTO> movilesDtos = new HashSet<>();
		Optional<Movil> movilOne = movilRepository.findById(id1);
		Optional<Movil> movilTwo = movilRepository.findById(id2);
		if (movilOne.isPresent() && movilTwo.isPresent()) {
			movilesDtos.add(movilMapper.mapToDto(movilOne.get()));
			movilesDtos.add(movilMapper.mapToDto(movilTwo.get()));
		}
		return movilesDtos;
	}

	@Override
	public List<SummarizedMovilDTO> getMovilesByFilters(MovilFilterDTO movilFilterDTO) {
	    if (movilFilterDTO.precioMin() == null || movilFilterDTO.precioMax() == null) {
	        throw new IllegalArgumentException("Debe proporcionar un precio mínimo y máximo.");
	    }

	    List<Movil> movilesFiltrados = movilRepository.findAll().stream()
	        .filter(movil -> movil.getPrecio() >= movilFilterDTO.precioMin() && movil.getPrecio() <= movilFilterDTO.precioMax())
	        .filter(movil -> movilFilterDTO.ram() == null || Integer.valueOf(movil.getRam()).equals(movilFilterDTO.ram())) 
	        .filter(movil -> movilFilterDTO.nfc() == null || movil.isNFC() == movilFilterDTO.nfc()) 
	        .filter(movil -> movilFilterDTO.tecnologiaPantalla() == null || movil.getPantalla().getTecnologia().equalsIgnoreCase(movilFilterDTO.tecnologiaPantalla()))
	        .filter(movil -> movilFilterDTO.marca() == null || movil.getMarca().equalsIgnoreCase(movilFilterDTO.marca()))
	        .toList();

	    return movilesFiltrados.stream()
	        .map(summarizedMovilMapper::mapToDto)
	        .toList();
	}
}
