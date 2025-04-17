package com.example.blockbuster_api.utility;

import com.example.blockbuster_api.models.Movie;
import com.example.blockbuster_api.models.MovieGenre;
import com.example.blockbuster_api.repository.MovieRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader {
    private final MovieRepository movieRepository;

    public DataLoader(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void loadData(){
        movieRepository.saveAll(
                List.of(
                        new Movie("Inception", 2009, true, MovieGenre.DRAMA),
                        new Movie("Goodfellas", 1990, true, MovieGenre.DRAMA)
                )
        );
    }
}
