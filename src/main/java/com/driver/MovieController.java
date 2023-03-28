package com.driver;

import com.driver.Director;
import com.driver.Movie;
import com.driver.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService=new MovieService();

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        String ans=movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        String ans=movieService.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name") String movieName, @RequestParam("name")String directorName){
        String ans=movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movieName){
            Movie movie=movieService.getMovieByName(movieName);
            return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String directorName){
        Director director=movieService.getDirectorByName(directorName);
        return new ResponseEntity<>(director,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String directorName){
           return new ResponseEntity<>(movieService.getMoviesByDirectorName(directorName),HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.findAllMovies(),HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name")String directorName){
        String ans=movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String ans=movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
}
