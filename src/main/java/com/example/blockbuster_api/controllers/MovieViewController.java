package com.example.blockbuster_api.controllers;

import com.example.blockbuster_api.models.Movie;
import com.example.blockbuster_api.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovieViewController {
    private final MovieService movieService;

    public MovieViewController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public String showMoviePage(Model model){
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movie";
    }
}
