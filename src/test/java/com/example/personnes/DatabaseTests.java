package com.example.personnes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DatabaseTests {

	@Autowired
	private PersonneRepository personneRepository;

	@Test
	void ajoutPersonne(){
		Personne alain = new Personne("Alain", "Dupont");
		personneRepository.save(alain);
	}

	@Test
	void lirePersonne(){
		Optional<Personne> optional = personneRepository.findById(1);
		if(optional.isEmpty())
			System.out.println("Personne non trouvée");
		else {
			Personne personne = optional.get();
			System.out.println(personne);
		}
	}

}
