package br.com.starWarsChallenge.planets.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.starWarsChallenge.planets.dto.OutSideApiDTO;


@Service
public class OusideApiServiceImpl implements OutsideApiService {

	@Value("${outside.starwars.api}")
	private String swapiUrl;


	@Override
	public <T> OutSideApiDTO findByName(String nome) {

		RestTemplate restTemplate = new RestTemplate();
		
		URI uri = UriComponentsBuilder.fromHttpUrl(swapiUrl).path("/planets/")
				.queryParam("search", nome).build().toUri();

		RequestEntity<?> request = RequestEntity.get(uri).header("user-agent", "")
                .accept(MediaType.APPLICATION_JSON).build();
		
        ResponseEntity<OutSideApiDTO> response = restTemplate.exchange(uri, HttpMethod.GET, request, OutSideApiDTO.class);
		
		return response.getBody();
	}

}
