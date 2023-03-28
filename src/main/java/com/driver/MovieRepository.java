package com.driver;

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
            if(pairDirMovie.get(s).equals(directorName)){
                moviesList.add(s);
            }
        }
        return moviesList;
    }

    public List<Movie> findAllMovies(){
        List<Movie> moviesList1 = new ArrayList<>();
        for(Movie movie : movieHashMap.values()){
            moviesList1.add(movie);
        }
        return moviesList1;
    }

    public String deleteDirectorByName(String directorName){

        directorHashMap.remove(directorName);
        for(Map.Entry<String,String> entry : pairDirMovie.entrySet()){
            if(entry.getValue().equals(directorName)){
                String movieName =entry.getKey();
                movieHashMap.remove(movieName);
                pairDirMovie.remove(movieName);
            }
        }
        return "Director and its Related Movies Deleted Successfully ";
    }

    public String deleteAllDirectors(){
           for(String dir : directorHashMap.keySet()){
               directorHashMap.remove(dir);
               for(Map.Entry<String,String> entry : pairDirMovie.entrySet()){
                   if(entry.getValue().equals(dir)){
                       String movieName =entry.getKey();
                       movieHashMap.remove(movieName);
                       pairDirMovie.remove(movieName);
                   }
               }

           }
        return "Director and its Related Movies Deleted Successfully ";
    }


}
