package com.example.personnes;

public class PersonneDTO {

    private Integer id;
    private String prenom;
    private String nom;

    public PersonneDTO(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public PersonneDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
