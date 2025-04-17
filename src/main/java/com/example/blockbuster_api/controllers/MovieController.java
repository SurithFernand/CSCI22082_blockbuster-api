package com.example.blockbuster_api.controllers;

import com.example.blockbuster_api.models.Movie;
import com.example.blockbuster_api.models.MovieGenre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping
//    public Map<Long, Movie> getMovies(){
//        return movies;
//    }

    @GetMapping
    public ResponseEntity<Map<Long, Movie>> getMovies(){
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")               //curly braces to say this is a variable
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Movie movie = movies.get(id);
        if(movie != null){
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();    //This line for not found(404)
    }

    @PostMapping
    public ResponseEntity<Movie> createNewMovie(@RequestBody Movie movieDetails){
        movieDetails.setId(idCounter.incrementAndGet());
        movies.put(movieDetails.getId(), movieDetails);
        return ResponseEntity.ok(movieDetails);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovieById(@PathVariable Long id, @RequestBody Movie movieDetails){
        Movie movie = movies.get(id);
        if(movie == null){
            return ResponseEntity.notFound().build();
        }
        movieDetails.setId(id);
        movies.put(id, movieDetails);
        return ResponseEntity.ok(movieDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movies.remove(id);
    }

    @GetMapping("/rent/{id}")
    public ResponseEntity<Movie> rentMovieById(@PathVariable Long id){
        Movie movie = movies.get(id);
        if(movie != null && movie.isAvailable()){
            movie.setAvailable(false);
            return ResponseEntity.ok(movie);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/return/{id}")
    public ResponseEntity<Movie> returnMovieById(@PathVariable Long id){
        Movie movie = movies.get(id);
        if(movie != null && !movie.isAvailable()){
            movie.setAvailable(true);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}

