package br.com.starWarsChallenge.planets.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.starWarsChallenge.planets.document.Planet;
import br.com.starWarsChallenge.planets.dto.PlanetDTO;
import br.com.starWarsChallenge.planets.helpful.Helpful;
import br.com.starWarsChallenge.planets.helpful.MessageHelpful;
import br.com.starWarsChallenge.planets.helpful.PathHelpful;
import br.com.starWarsChallenge.planets.helpful.ResponseHelpful;
import br.com.starWarsChallenge.planets.service.PlanetService;

@RestController
@RequestMapping(path = PathHelpful.API)
public class PlanetController {
	
	@Autowired
	PlanetService service;
	

	@PostMapping(path = PathHelpful.INCLUDE)
	public ResponseEntity<?> createPlanet(@Valid @RequestBody PlanetDTO planetDTO, UriComponentsBuilder uriBuilder) {
		
		Planet planet = service.createPlanet(planetDTO);
		
		URI uri = uriBuilder.path("/{id}").buildAndExpand(planet.getId()).toUri();
        return ResponseEntity.created(uri).body
        		(new ResponseHelpful<>(new PlanetDTO(planet), MessageHelpful.CREATE_SUCESS));
		
	}
	
	@GetMapping(path = PathHelpful.FIND_ALL)
	public ResponseEntity<List<PlanetDTO>> findAll(){
		
		List<Planet> planets = service.findAllPlanets();
		List<PlanetDTO> dto = PlanetDTO.toListDTO(planets);
		
		return ResponseEntity
				.status(!Helpful.isEmpety(dto) ? HttpStatus.OK : HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(dto);
		
		
	}
	
	@GetMapping(path = PathHelpful.FIND_BY_NAME)
	public ResponseEntity<PlanetDTO> findByName(@PathVariable(name = "name") String name){
		
		Planet planet = service.findByName(name);

        return ResponseEntity.
        		status(Helpful.isEmpety(planet) ? HttpStatus.OK : HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new PlanetDTO(planet));
        		
	}
	
	@GetMapping(path = PathHelpful.FIND_BY_ID)
	public ResponseEntity<PlanetDTO> findById(@PathVariable(name = "id")String id){
		
		Optional<Planet> planet = service.findById(id);

        return ResponseEntity.
        		status(Helpful.isEmpety(planet) ? HttpStatus.OK : HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new PlanetDTO(planet.get()));
		
	}
	
	
	@GetMapping(path = PathHelpful.REMOVE)
	public ResponseEntity<?> deletePlanet(@PathVariable(name = "id") String id) {
		
		service.deletePlanet(id);

		return ResponseEntity.ok(new ResponseHelpful<>(MessageHelpful.DELETE_SUCESS));

	}

}
