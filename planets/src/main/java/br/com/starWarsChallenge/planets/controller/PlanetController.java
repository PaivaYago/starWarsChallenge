package br.com.starWarsChallenge.planets.controller;


import static org.springframework.http.ResponseEntity.status;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.badRequest;



import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.starWarsChallenge.exception.BusinessException;
import br.com.starWarsChallenge.planets.document.Planet;
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
	public ResponseEntity<?> createPlanet(@Valid @RequestBody Planet planet, UriComponentsBuilder uriBuilder) {

		try {

			Planet p = service.createPlanet(planet);

			URI uri = uriBuilder.path("/{id}").buildAndExpand(p.getId()).toUri();
			return created(uri).body(new ResponseHelpful<>((p), MessageHelpful.CREATE_SUCESS));

		} catch (BusinessException e) {

			return badRequest().body(e.getMessage());

		} catch (Exception e) {

			return status(HttpStatus.INTERNAL_SERVER_ERROR).body(MessageHelpful.UNEXPECTED);

		}

	}
	
	@GetMapping(path = PathHelpful.FIND_ALL)
	public ResponseEntity<?> findAll(){
		try {
			
			List<Planet> planets = service.findAllPlanets();
			
			return status(!Helpful.isEmpety(planets) ? HttpStatus.OK : HttpStatus.PARTIAL_CONTENT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(planets);
			
		} catch (BusinessException e) {

			return badRequest().body(e.getMessage());
			
		}catch(Exception e) {
			
			return status(HttpStatus.INTERNAL_SERVER_ERROR).body(MessageHelpful.UNEXPECTED);
		}
		
		
		
	}
	
	@GetMapping(path = PathHelpful.FIND_BY_NAME)
	public ResponseEntity<?> findByName(@PathVariable(name = "name") String name){
		
		try {
			
			Optional<Planet> planet = service.findByName(name);

	        return  status(Helpful.isEmpety(planet) ? HttpStatus.OK : HttpStatus.PARTIAL_CONTENT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(planet);
	        
		} catch (BusinessException e) {

			return badRequest().body(e.getMessage());
			
		}catch(Exception e) {
			
			
			return status(HttpStatus.INTERNAL_SERVER_ERROR).body(MessageHelpful.NOT_FOUND);
		}
		
        		
		
	}
	
	@GetMapping(path = PathHelpful.FIND_BY_ID)
	public ResponseEntity<?> findById(@PathVariable(name = "id")String id){
		
		try {
			
			Optional<Planet> planet = service.findById(id);

	        return  status(Helpful.isEmpety(planet) ? HttpStatus.OK : HttpStatus.PARTIAL_CONTENT)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body((planet));
	        
		} catch (BusinessException e) {

			return badRequest().body(e.getMessage());
			
		}catch(Exception e) {
			
			return status(HttpStatus.INTERNAL_SERVER_ERROR).body(MessageHelpful.NOT_FOUND);
			
		}
		
		
	}
	
	
	@DeleteMapping(path = PathHelpful.REMOVE)
	public ResponseEntity<?> deletePlanet(@PathVariable(name = "id") String id, UriComponentsBuilder uriBuilder) {
		
		try {
			
			service.deletePlanet(id);

			return ok(new ResponseHelpful<>(id, MessageHelpful.DELETE_SUCESS));
			
			
		} catch (BusinessException e) {

			return badRequest().body(e.getMessage());
			
		}catch(Exception e) {
			
			return status(HttpStatus.INTERNAL_SERVER_ERROR).body(MessageHelpful.UNEXPECTED);
		}
		

	}

}
