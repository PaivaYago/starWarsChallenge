package br.com.starWarsChallenge.planets.service;


import br.com.starWarsChallenge.planets.dto.OutsideApiDTO;

public interface OutsideApiService {
	

	OutsideApiDTO findByName(String nome);


}
