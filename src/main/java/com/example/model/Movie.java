package com.example.model;

public class Movie {
    public String name;
    public int release_year;

    public Movie(){} //required by quarkus JSON serialization layer

    public Movie(String name, int release_year){
        this.name = name;
        this.release_year = release_year;
    }
}
