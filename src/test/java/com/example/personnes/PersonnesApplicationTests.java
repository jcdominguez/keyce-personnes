package com.example.personnes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonnesApplicationTests {

	@Autowired
	private PersonneService personneService;

	@Test
	void contextLoads() {
	}

	@Test
	void ajoutPersonne(){
		Personne alain = new Personne("Alain", "Dupont");
		personneService.add(alain);
	}

}
