package com.example.personnes;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PersonneDbService implements Annuaire {

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private StageRepository stageRepository;



    @Override
    public List<Personne> getAll() {
        return personneRepository.findAll();
    }

    @Override
    public void add(Personne personne) {
        personneRepository.save(personne);
    }

    @Override
    public Optional<Personne> findById(Integer id) {
        return personneRepository.findById(id);
    }

    @Override
    public void update(Integer id, Personne personne) {
        personneRepository.save(personne);
    }

    @Override
    public void delete(Integer id) {
        personneRepository.deleteById(id);
    }
}
