package br.com.starWarsChallenge.planets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.starWarsChallenge.planets.document.Planet;
import br.com.starWarsChallenge.planets.dto.OutsideApiDTO;
import br.com.starWarsChallenge.planets.dto.PlanetDTO;
import br.com.starWarsChallenge.planets.helpful.NotFoundException;
import br.com.starWarsChallenge.planets.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService{
	
	@Autowired
	PlanetRepository repository;
	
	@Autowired
	OutsideApiService outsideService;
	

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Planet createPlanet(PlanetDTO planetDTO) {
		
		planetDTO.setCountFilms(this.appearancesFilms(planetDTO.getName()));
		
		System.out.println(planetDTO.getCountFilms());
		
		return repository.save(PlanetDTO.toEntity(planetDTO));
		
	}

	
	@Override
	public Planet findById(String id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException());
	}

	@Override
	public Planet findByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public List<Planet> findAllPlanets() {
		
		return repository.findAll();
	}

	@Override
	public void deletePlanet(String id) {
		repository.deleteById(id);
		
	}
	
	public String appearancesFilms(String name) {
		
		OutsideApiDTO dto = outsideService.findByName(name);
		
		return Integer.toString(dto.getFilms().stream()
                .filter(a -> dto.getName().equalsIgnoreCase(name))
                .mapToInt(a -> dto.getFilms().size())
                .sum());
	}


}
