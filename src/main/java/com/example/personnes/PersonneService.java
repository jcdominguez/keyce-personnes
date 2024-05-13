package com.example.personnes;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Service
public class PersonneService {

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

    public Personne findById(Integer id){
        return personnes.get(id);
    }

    public void update(Integer id, Personne personne){
        personnes.put(id, personne);
    }

    public void delete(Integer id){
        personnes.remove(id);
    }
}
