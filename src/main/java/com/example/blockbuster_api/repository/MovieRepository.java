package com.example.blockbuster_api.repository;

import com.example.blockbuster_api.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
