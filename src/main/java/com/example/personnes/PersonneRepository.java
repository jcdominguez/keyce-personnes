package com.example.personnes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Integer> {

    List<Personne> findAllByNom(String nom);
}
