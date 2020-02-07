package br.com.starWarsChallenge.planets.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.starWarsChallenge.planets.document.Planet;

public class PlanetDTO {

	private String name;

	private String climate;

	private String terrain;

	private String countFilms;

	public PlanetDTO() {

	}

	public PlanetDTO(Planet planet) {
		super();
		this.name = planet.getName();
		this.climate = planet.getClimate();
		this.terrain = planet.getTerrain();

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getName() {
		return name;
	}

	public String getClimate() {
		return climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public String getCountFilms() {
		return countFilms;
	}

	public void setCountFilms(String countFilms) {
		this.countFilms = countFilms;
	}

	public static Planet toEntity(PlanetDTO planetDTO) {

		Planet planet = new Planet();
		planet.setName(planetDTO.getName());
		planet.setClimate(planetDTO.getClimate());
		planet.setTerrain(planetDTO.getTerrain());
		planet.setCountFilms(planetDTO.getCountFilms());

		return planet;

	}

	public static List<PlanetDTO> toListDTO(List<Planet> planets) {
		return planets.stream().map(planet -> new PlanetDTO(planet)).collect(Collectors.toList());
	}
	
	

}
