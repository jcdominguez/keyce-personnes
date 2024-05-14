package com.example.personnes;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonneService implements Annuaire {

    //private ArrayList<Personne> personnes = new ArrayList<>();
    private Map<Integer, Personne> personnes = new HashMap<>();
    private int idCount = 0;

    public List<Personne> getAll(){
        //return personnes.values().stream().collect(toCollection(ArrayList::new));
        return personnes.values().stream().collect(Collectors.toList());
    }

    public void add(Personne personne){
        idCount++; // idCount = idCount + 1;
        personne.setId(idCount);
        personnes.put(idCount, personne);
    }

    public Optional<Personne> findById(Integer id){
        Personne p = personnes.get(id);
        if(p == null)
            return Optional.empty();
        else
            return Optional.of(p);
    }

    public void update(Integer id, Personne personne){
        personnes.put(id, personne);
    }

    public void delete(Integer id){
        personnes.remove(id);
    }
}
