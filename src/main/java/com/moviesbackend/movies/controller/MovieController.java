package com.moviesbackend.movies.controller;
import com.moviesbackend.movies.model.Movie;
import com.moviesbackend.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {


    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Movie> findMovieById(@PathVariable Long id){
        Movie movie = movieService.findMovieById(id);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @PostMapping("/add")
    //@RequestBody = indica lo que esta devolviendo el body del request
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie newMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        Movie updateMovie = movieService.updateMovie(movie);
        return new ResponseEntity<>(updateMovie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
