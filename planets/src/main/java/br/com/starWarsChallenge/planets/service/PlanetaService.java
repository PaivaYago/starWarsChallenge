package br.com.starWarsChallenge.planets.service;

import java.util.List;
import java.util.Optional;

import br.com.starWarsChallenge.planets.document.Planeta;

public interface PlanetaService {
	
	public void createPlaneta(Planeta planeta);
	
	public Optional<Planeta> findById(String id);
	
	public Planeta findByNome(String nome);

	public List<Planeta> findAllPlanetas();
	
	public void deletePlaneta(String id);

}
