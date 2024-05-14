package com.example.personnes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DatabaseTests {

	@Autowired
	private PersonneRepository personneRepository;

	@Test
	void ajoutPersonne(){
		Personne alain = new Personne("Alain", "Dupont");
		personneRepository.save(alain);
	}

}
