package com.example.blockbuster_api.service;

import com.example.blockbuster_api.models.Movie;
import com.example.blockbuster_api.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    //TODO : get a single movie by ID
    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

}
