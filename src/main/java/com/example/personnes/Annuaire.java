package com.example.personnes;

import java.util.List;
import java.util.Optional;

public interface Annuaire {

    public List<Personne> getAll();
    public void add(Personne personne);
    public Optional<Personne> findById(Integer id);
    public void update(Integer id, Personne personne);
    public void delete(Integer id);
}
