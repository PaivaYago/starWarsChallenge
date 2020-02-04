package br.com.starWarsChallenge.planets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.starWarsChallenge.planets.document.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String>{
	
	
	Planeta findByNome(String nome);
	
}
