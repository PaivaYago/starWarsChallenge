package br.com.starWarsChallenge.planets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.starWarsChallenge.planets.document.Planeta;
import br.com.starWarsChallenge.planets.repository.PlanetaRepository;

public class PlanetaServiceImpl implements PlanetaService{
	
	@Autowired
	PlanetaRepository repository;

	@Override
	public void createPlaneta(Planeta planeta) {
		repository.save(planeta);
		
	}

	@Override
	public Optional<Planeta> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Planeta findByNome(String nome) {
		return repository.findByNome(nome);
	}

	@Override
	public List<Planeta> findAllPlanetas() {
		return repository.findAll();
	}

	@Override
	public void deletePlaneta(String id) {
		repository.deleteById(id);
		
	}


}
