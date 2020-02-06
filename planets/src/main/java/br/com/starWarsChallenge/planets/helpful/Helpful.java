package br.com.starWarsChallenge.planets.helpful;

import java.util.List;

public class Helpful {

	public static <T> Boolean isEmpety(List<T> values) {

		Long count = values.stream().count();
		return count >= 1;
	}

	public static <T> Boolean isEmpety(T a) {

		 return a == null || a == "";
	}
	
}
