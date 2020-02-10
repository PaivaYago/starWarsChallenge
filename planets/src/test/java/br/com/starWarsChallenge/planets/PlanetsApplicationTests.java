package br.com.starWarsChallenge.planets;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.starWarsChallenge.planets.document.Planet;
import br.com.starWarsChallenge.planets.exception.BusinessException;
import br.com.starWarsChallenge.planets.repository.PlanetRepository;

import br.com.starWarsChallenge.planets.service.PlanetServiceImpl;

@RunWith(SpringRunner.class)
class PlanetsApplicationTests {

	
	@TestConfiguration
    static class PlanetServiceTestContextConfiguration {

		@Bean
        public PlanetServiceImpl planetService() {
            return new PlanetServiceImpl();
        }
    }
	
	@Autowired
	private PlanetServiceImpl service;
	
	@MockBean
	private PlanetRepository repository;

	@Before
	public void initialiseRestAssuredMockMvcStandalone() {
		
		
		Optional<Planet> planet = Optional.of(new Planet("1", "wakawaka", "temperate","montain","0"));

	    when(repository.findById(planet.get().getId()))
	      .thenReturn(planet);
	    
	    when(repository.findByName(planet.get().getName()))
	      .thenReturn(planet);

	    List<Planet> planets = new ArrayList<>();
	    planets.add(new Planet("1", "wakawaka", "temperate","montain","0"));
	    planets.add(new Planet("2", "lumus", "tropical","jungle","0"));
	    planets.add(new Planet("3", "biruliro", "frozen","tundra","0"));

	    when(repository.findAll())
	    	.thenReturn(planets);

	    when(repository.save(new Planet("wakawaka", "temperate","montain","0")))
	    	.thenReturn(new Planet("1", "wakawaka", "temperate","montain","0"));


	    doNothing().when(repository).delete(isA(Planet.class));
		
	}
	
	@Test
	public void testFindById() throws BusinessException {
	    String id = "1";
	    Optional<Planet> found = service.findById(id);

	    assertThat(found.get().getId()).isEqualTo(id);
	 }
	
	@Test
	public void testFindByName() throws BusinessException {
	    String name = "wakawaka";
	    Optional<Planet> found = service.findByName(name);

	    assertThat(found.get().getName()).isEqualTo(name);
	 }
	
	@Test
	public void testListAll() throws BusinessException {
		List<Planet> planets = new ArrayList<>();
		planets.add(new Planet("1", "wakawaka", "temperate","montain","0"));
		planets.add(new Planet("2", "lumus", "tropical","jungle","0"));
		planets.add(new Planet("3", "biruliro", "frozen","tundra","0"));

	    List<Planet> lista = service.findAllPlanets();

	    assertThat(lista).containsAll(planets);
	} 
	
	@Test
	public void testSave() {
		Planet planet = repository.save(new Planet("wakawaka", "temperate","montain","0"));
		assertThat(planet.getId()).isEqualTo("1");
	}

	

}
