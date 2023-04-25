package com.iti.jets.sakilaJax.persistence.entities;

public enum FilmRating {
    G("G"),
    PG("PG"),
    PG13("PG-13"),
    R("R"),
    NC17("NC-17");

    private final String name;
    private FilmRating(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }
}
