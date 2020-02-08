package br.com.starWarsChallenge.planets.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OutSideApiDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<ResultDTO> results;

	public List<ResultDTO> getResults() {
		return results;
	}

	public void setResults(List<ResultDTO> results) {
		this.results = results;
	}
	
	
	

}
