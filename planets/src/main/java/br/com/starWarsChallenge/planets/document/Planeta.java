package br.com.starWarsChallenge.planets.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planeta")
public class Planeta {

	@Id
	private String id;
	
	private String nome;
	
	private String clima;
	
	private String terreno;
	
	public Planeta() {
		// TODO Auto-generated constructor stub
	}

	public Planeta(String id, String nome, String clima, String terreno) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	
}
