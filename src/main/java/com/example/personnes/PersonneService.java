package com.example.personnes;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonneService {

    //private ArrayList<Personne> personnes = new ArrayList<>();
    private Map<Integer, Personne> personnes = new HashMap<>();
    private int idCount = 0;

    public Collection<Personne> getAll(){
        return personnes.values();
    }

    public void add(Personne personne){
        idCount++; // idCount = idCount + 1;
        personne.setId(idCount);
        personnes.put(idCount, personne);
    }

    public Personne findById(Integer id){
        return personnes.get(id);
    }

    public void update(Personne personne){
        personnes.put(personne.getId(), personne);
    }

    public void delete(Integer id){
        personnes.remove(id);
    }
}
