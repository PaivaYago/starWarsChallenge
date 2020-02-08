package br.com.starWarsChallenge.planets.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class OutsideApiDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("films")
	private List<String> films;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}
	
	

	

}
