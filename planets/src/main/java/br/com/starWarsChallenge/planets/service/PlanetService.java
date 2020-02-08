package br.com.starWarsChallenge.planets.service;

import java.util.List;
import java.util.Optional;

import br.com.starWarsChallenge.exception.BusinessException;
import br.com.starWarsChallenge.planets.document.Planet;


public interface PlanetService {
	
	public Planet createPlanet(Planet planet) throws BusinessException;
	
	public Optional<Planet> findById(String id) throws BusinessException;
	
	public Optional<Planet> findByName(String name) throws BusinessException;

	public List<Planet> findAllPlanets() throws BusinessException;
	
	public void deletePlanet(String id) throws BusinessException;

}
