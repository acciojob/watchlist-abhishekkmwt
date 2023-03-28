package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();
    HashMap<String, List<String>> pairDb=new HashMap<>();

    public String addMovie(Movie movie){
        movieHashMap.put(movie.getName(), movie);
        return "Movie Added Successfully";
    }

    public String addDirector(Director director){
        directorHashMap.put(director.getName(), director);
        return "Director Added Successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        List<String> movies= pairDb.get(directorName);
        if(movies == null){
            movies = new ArrayList<>();
        }
        movies.add(movieName);
        pairDb.put(directorName,movies);
        return "Movie Director Pair Added Successfully";
    }

    public Movie getMovieByName(String movieName){
        return movieHashMap.get(movieName);
    }

    public Director getDirectorByName(String directorName){
        return directorHashMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        return pairDb.get(directorName);
    }

    public List<String> findAllMovies(){
        List<String> moviesList1 = new ArrayList<>();
        for(String name: movieHashMap.keySet()){
            moviesList1.add(name);
        }
        return moviesList1;
    }

    public String deleteDirectorByName(String director){
        for(String movie : pairDb.get(director)){
            movieHashMap.remove(movie);
        }
        directorHashMap.remove(director);
        pairDb.remove(director);
        return "Director and its Related Movies Deleted Successfully ";
    }

    public String deleteAllDirectors(){
        for(String director : directorHashMap.keySet()){
            for(String movie : pairDb.get(director)){
                movieHashMap.remove(movie);
            }
            directorHashMap.remove(director);
            pairDb.remove(director);
        }
        return "Director and its Related Movies Deleted Successfully ";
    }


}
