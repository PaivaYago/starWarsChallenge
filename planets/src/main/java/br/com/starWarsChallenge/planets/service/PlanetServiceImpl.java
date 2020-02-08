package br.com.starWarsChallenge.planets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.starWarsChallenge.exception.BusinessException;
import br.com.starWarsChallenge.planets.document.Planet;

import br.com.starWarsChallenge.planets.dto.OutSideApiDTO;
import br.com.starWarsChallenge.planets.helpful.Helpful;
import br.com.starWarsChallenge.planets.helpful.MessageHelpful;
import br.com.starWarsChallenge.planets.repository.PlanetRepository;

@Service
public class PlanetServiceImpl implements PlanetService{
	
	@Autowired
	PlanetRepository repository;
	
	@Autowired
	OutsideApiService outsideService;
	

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Planet createPlanet(Planet planet) throws BusinessException{
		
		if(exists(planet.getName(), planet.getId())){
			
			throw new BusinessException(MessageHelpful.EXISTS_NAME);
			
		}
		
		planet.setCountFilms(this.appearancesFilms(planet.getName()));
		
		return repository.save(planet);
		
	}

	
	@Override
	public Optional<Planet> findById(String id) throws BusinessException{
		
		if(Helpful.isEmpety(id)) {
			
			throw new BusinessException(MessageHelpful.EMPTY_ID);
			
		}
		
		
		
		return repository.findById(id);
	}

	@Override
	public Optional<Planet> findByName(String name) throws BusinessException {

		if(name.isEmpty()) {
			
			throw new BusinessException(MessageHelpful.EMPTY_NAME);
			
		}
			
		return repository.findByName(name);
	}

	@Override
	public List<Planet> findAllPlanets() throws BusinessException{
		
		List<Planet> planets = repository.findAll();
		
		if(Helpful.isEmpety(planets)) {
			
			throw new BusinessException(MessageHelpful.EMPTY);
		}
		
		return planets;
	}

	@Override
	public void deletePlanet(String id) throws BusinessException{
		
		if(Helpful.isEmpety(id)) {
			
			throw new BusinessException(MessageHelpful.EMPTY_ID);
			
		}else if(!exists(null, id)) {
			
			throw new BusinessException(MessageHelpful.NOT_FOUND);
			
		}
		
		repository.deleteById(id);
		
	}
	
	public String appearancesFilms(String name){
		
		OutSideApiDTO dto = outsideService.findByName(name);
		
		return Integer.toString(dto.getResults().stream()
                .filter(a -> a.getName().contentEquals(name))
                .mapToInt(a -> a.getFilms().size())
                .sum());
	}
	
	public Boolean exists(String name, String id) throws BusinessException {
		
		if(!Helpful.isEmpety(name) && this.findByName(name).isPresent() ||
				!Helpful.isEmpety(id) && this.findById(id).isPresent()){
			
			return true;
			
		}
		
		return false;
	}


}
