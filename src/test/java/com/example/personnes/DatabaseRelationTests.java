package com.example.personnes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class DatabaseRelationTests {

	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private AdresseRepository adresseRepository;


	@Test
	void saveAdresse(){
		Adresse a = new Adresse();
		a.setNumero("10");
		a.setRue("rue de  la mairie");
		a.setCodePostal("75000");
		a.setVille("Paris");

		adresseRepository.save(a);
	}
}
