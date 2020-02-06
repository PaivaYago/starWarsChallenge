package br.com.starWarsChallenge.planets.document;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "planet")
public class Planet {

	@Id
	private String id;

	@NotBlank(message = "{name.not.blank}")
	private String name;

	@NotBlank(message = "{climate.not.blank}")
	private String climate;

	@NotBlank(message = "{terrain.not.blank}")
	private String terrain;

	public Planet() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Planet(@NotBlank(message = "{name.not.blank}") String name,
			@NotBlank(message = "{climate.not.blank}") String climate,
			@NotBlank(message = "{terrain.not.blank}") String terrain) {
		super();
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
	}



	@Override
	public String toString() {

		return super.toString();
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getClimate() {
		return climate;
	}


	public void setClimate(String climate) {
		this.climate = climate;
	}


	public String getTerrain() {
		return terrain;
	}


	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	
}
