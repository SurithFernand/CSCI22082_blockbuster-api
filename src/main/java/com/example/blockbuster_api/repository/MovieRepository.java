package com.example.blockbuster_api.repository;

import com.example.blockbuster_api.models.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    //Find all movies that are available
    List<Movie> findMoviesByAvailable(boolean available);

    List<Movie> findMoviesByReleaseYearBetween(int releaseYear, int releaseYear2);

    Movie findMovieByTitle(String title);
}
