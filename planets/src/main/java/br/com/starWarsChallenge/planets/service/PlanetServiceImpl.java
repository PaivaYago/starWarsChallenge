package br.com.starWarsChallenge.planets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.starWarsChallenge.planets.document.Planet;
import br.com.starWarsChallenge.planets.dto.PlanetDTO;
import br.com.starWarsChallenge.planets.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService{
	
	@Autowired
	PlanetRepository repository;

	@Override
	public Planet createPlanet(PlanetDTO planetDTO) {
		return repository.save(PlanetDTO.toEntity(planetDTO));
		
	}

	@Override
	public Optional<Planet> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Planet findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Planet> findAllPlanets() {
		return repository.findAll();
	}

	@Override
	public void deletePlanet(String id) {
		repository.deleteById(id);
		
	}


}
