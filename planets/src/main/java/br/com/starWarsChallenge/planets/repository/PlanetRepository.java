package br.com.starWarsChallenge.planets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.starWarsChallenge.planets.document.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	Planet findByName(String name);
	
}
