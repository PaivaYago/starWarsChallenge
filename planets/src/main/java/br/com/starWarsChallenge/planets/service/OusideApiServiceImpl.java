package br.com.starWarsChallenge.planets.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.starWarsChallenge.planets.dto.OutsideApiDTO;

@Service
public class OusideApiServiceImpl implements OutsideApiService{

	
	@Value("${outside.starwars.api}")
	private String starWarsApi;
	
	   @Autowired
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	
	@Override
	public <T> OutsideApiDTO findByName(String name) {
		

		URI uri = UriComponentsBuilder.fromHttpUrl(starWarsApi)
				.path("/planets/").queryParam("search", name)
				.build().toUri();

		RequestEntity<?> request = RequestEntity.get(uri).header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36")
                .accept(MediaType.APPLICATION_JSON).build();
		
		
		ResponseEntity<OutsideApiDTO> dto = restTemplate().exchange(uri, HttpMethod.GET, request, OutsideApiDTO.class);
		

		
		return dto.getBody();
	}
	

}
