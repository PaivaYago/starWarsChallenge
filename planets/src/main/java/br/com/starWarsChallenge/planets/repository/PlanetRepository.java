package br.com.starWarsChallenge.planets.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.starWarsChallenge.planets.document.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	Optional<Planet> findByName(String name);
	
}
