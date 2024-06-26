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
	@Autowired
	private StageRepository stageRepository;


	@Test
	void saveAdresse(){
		Adresse a = new Adresse();
		a.setNumero("10");
		a.setRue("rue de  la mairie");
		a.setCodePostal("75000");
		a.setVille("Paris");

		adresseRepository.save(a);
	}

	@Test
	void personneAvecAdresse(){
		Optional<Adresse> optionalAdresse = adresseRepository.findById(1);
		if(optionalAdresse.isPresent()){
			Adresse adresse = optionalAdresse.get();

			Optional<Personne> optionalPersonne = personneRepository.findById(1);
			if(optionalPersonne.isPresent()){
				Personne personne = optionalPersonne.get();

				personne.setAdresse(adresse);

				personneRepository.save(personne);
			}

		}
	}

	@Test
	void lecturePersonneAvecAdresse(){
		Optional<Personne> optional = personneRepository.findById(1);
		if(optional.isPresent()){
			Personne personne = optional.get();
			Adresse adresse = personne.getAdresse();
			System.out.println(adresse);
		}
	}

	@Test
	void stage(){
		Personne eric = new Personne("Eric", "Schmidt");
		personneRepository.save(eric);
		Personne julie = new Personne("Julie", "Durand");
		personneRepository.save(julie);

		Stage java = new Stage();
		java.setNom("Java");
		java.addStagiaire(eric);
		java.addStagiaire(julie);
		stageRepository.save(java);

		Stage salsa = new Stage();
		salsa.setNom("Salsa");
		salsa.addStagiaire(julie);
		stageRepository.save(salsa);
	}
}
