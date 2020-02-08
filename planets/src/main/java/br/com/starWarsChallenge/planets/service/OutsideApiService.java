package br.com.starWarsChallenge.planets.service;


import br.com.starWarsChallenge.planets.dto.OutSideApiDTO;

public interface OutsideApiService {
	

	<T> OutSideApiDTO findByName(String nome);


}
