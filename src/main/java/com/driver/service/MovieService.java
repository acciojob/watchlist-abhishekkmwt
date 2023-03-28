package com.driver.service;

import com.driver.Director;
import com.driver.Movie;
import com.driver.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository=new MovieRepository();

    public String addMovie(Movie movie){
       String ans =movieRepository.addMovie(movie);
       return ans;
    }

    public String addDirector(Director director){
        String ans =movieRepository.addDirector(director);
        return ans;
    }

    public String addMovieDirectorPair(String movieName, String directorName){
        String ans=movieRepository.addMovieDirectorPair(movieName,directorName);
        return ans;
    }

    public Movie getMovieByName(String movieName){
        return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String directorName){
        return movieRepository.getDirectorByName(directorName);
    }

    public List<String> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<Movie> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public String deleteDirectorByName(String directorName){
        return movieRepository.deleteDirectorByName(directorName);
    }

    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }
}
