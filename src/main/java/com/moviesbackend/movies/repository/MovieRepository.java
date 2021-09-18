package com.moviesbackend.movies.repository;

import com.moviesbackend.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepository = Especificar el tipo de dato de la clase y el tipo de dato para el ID
public interface MovieRepository extends JpaRepository<Movie, Long> {
    void deleteMovieById(Long id);
    Optional<Movie> findMovieById(Long id);
}
