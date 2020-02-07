package br.com.starWarsChallenge.planets.service;


import br.com.starWarsChallenge.planets.dto.OutsideApiDTO;

public interface OutsideApiService {
	
	public <T> OutsideApiDTO findByName(String name);

}
