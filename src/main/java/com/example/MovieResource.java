package com.example;

import com.example.model.Movie;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/movies")
public class MovieResource {
    private Set<Movie> movies = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public MovieResource(){
        movies.add(new Movie("The Office", 2005));
        movies.add(new Movie("Titanic", 1999));
    }

    @GET
    public Set<Movie> list(){
        return movies;
    }

    @POST
    public Set<Movie> add(Movie movie){
        movies.add(movie);
        return movies;
    }

    @DELETE
    public Set<Movie> delete(Movie movie){
        movies.removeIf(existingMovie -> existingMovie.name.contentEquals(movie.name));
        return movies;
    }
}
