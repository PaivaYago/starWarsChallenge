package br.com.starWarsChallenge.planets.service;

import java.util.List;
import java.util.Optional;

import br.com.starWarsChallenge.planets.document.Planet;
import br.com.starWarsChallenge.planets.dto.PlanetDTO;


public interface PlanetService {
	
	public Planet createPlanet(PlanetDTO planetDTO);
	
	public Optional<Planet> findById(String id);
	
	public Planet findByName(String name);

	public List<Planet> findAllPlanets();
	
	public void deletePlanet(String id);

}
