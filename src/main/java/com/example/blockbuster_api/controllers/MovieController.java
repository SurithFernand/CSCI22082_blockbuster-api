package com.example.blockbuster_api.controllers;

import com.example.blockbuster_api.models.Movie;
import com.example.blockbuster_api.models.MovieGenre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private Map<Long, Movie> movies = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public MovieController() {
        Movie m1 = new Movie("100", 2007, true, MovieGenre.ACTION);
        Movie m2 = new Movie("Iron Man", 2004, true, MovieGenre.ACTION);
        Movie m3 = new Movie("Beekeeper", 2023, true, MovieGenre.ACTION);
        Movie m4 = new Movie("Nun", 2017, true, MovieGenre.THRILLER);
        Movie m5 = new Movie("In War", 2025, true, MovieGenre.WAR);

        m1.setId(idCounter.incrementAndGet());
        movies.put(m1.getId(), m1);
        m2.setId(idCounter.incrementAndGet());
        movies.put(m2.getId(), m2);
        m3.setId(idCounter.incrementAndGet());
        movies.put(m3.getId(), m3);
        m4.setId(idCounter.incrementAndGet());
        movies.put(m4.getId(), m4);
        m5.setId(idCounter.incrementAndGet());
        movies.put(m5.getId(), m5);
    }

    @GetMapping
    public Map<Long, Movie> getMovies(){
        return movies;
    }

}

