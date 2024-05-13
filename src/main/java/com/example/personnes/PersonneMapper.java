package com.example.personnes;

public class PersonneMapper {

    public static PersonneDTO toDTO(Personne personne){
        PersonneDTO dto = new PersonneDTO();
        dto.setId(personne.getId());
        dto.setPrenom(personne.getPrenom());
        dto.setNom(personne.getNom());
        return dto;
    }

    public static Personne toPersonne(PersonneDTO dto){
        Personne p = new Personne();
        p.setId(dto.getId());
        p.setPrenom(dto.getPrenom());
        p.setNom(dto.getNom());
        return p;
    }
}
