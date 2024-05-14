package com.example.personnes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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

	@Test
	void findAll(){
		List<Personne> persones = personneRepository.findAll();
		for(Personne p: persones){
			System.out.println(p);
		}
	}

	@Test
	void delete(){
		personneRepository.deleteById(2);
	}

	@Test
	void updateOK(){
		Optional<Personne> optional = personneRepository.findById(1);
		if(optional.isPresent()) {
			Personne personne = optional.get();
			personne.setNom("Tartempion");
			personneRepository.save(personne);
		}
	}

	@Test
	void searchByNom(){
		List<Personne> familleDupont = personneRepository.findAllByNom("Dupont");
		for(Personne p : familleDupont)
			System.out.println(p);
	}
}
