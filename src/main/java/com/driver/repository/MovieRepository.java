package com.driver.repository;

import com.driver.Director;
import com.driver.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieHashMap = new HashMap<>();
    HashMap<String, Director> directorHashMap = new HashMap<>();
    HashMap<String, String> pairDirMovie = new HashMap<>();

    public String addMovie(Movie movie){
        movieHashMap.put(movie.getName(), movie);
        return "Movie Added Successfully";
    }

    public String addDirector(Director director){
        directorHashMap.put(director.getName(), director);
        return "Director Added Successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        pairDirMovie.put(movieName,directorName);
        return "Movie Director Pair Added Successfully";
    }

    public Movie getMovieByName(String movieName){
        return movieHashMap.get(movieName);
    }

    public Director getDirectorByName(String directorName){
        return directorHashMap.get(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName){
        List<String> moviesList = new ArrayList<>();
        for(String s : pairDirMovie.keySet()){
            if(pairDirMovie.get(s) == directorName){
                moviesList.add(s);
            }
        }
        return moviesList;
    }

    public List<Movie> findAllMovies(){
        List<Movie> moviesList = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            moviesList.add(movie);
        }
        return moviesList;
    }

    public String deleteDirectorByName(String directorName){

        for(String s : pairDirMovie.keySet()){
            if(pairDirMovie.get(s).equals(directorName)){
                movieHashMap.remove(s);
                directorHashMap.remove(directorName);
                pairDirMovie.remove(s);
            }
        }
        return "Director and its Related Movies Deleted Successfully ";
    }

    public String deleteAllDirectors(){
           for(String dir : directorHashMap.keySet()){
               for(String s : pairDirMovie.keySet()){
                   if(pairDirMovie.get(s).equals(dir)){
                       movieHashMap.remove(s);
                       directorHashMap.remove(dir);
                       pairDirMovie.remove(s);
                   }
               }
           }
        return "Director and its Related Movies Deleted Successfully ";
    }


}
