package com.example.blockbuster_api.utility;

import com.example.blockbuster_api.models.Address;
import com.example.blockbuster_api.models.Customer;
import com.example.blockbuster_api.models.Movie;
import com.example.blockbuster_api.models.MovieGenre;
import com.example.blockbuster_api.service.CustomerService;
import com.example.blockbuster_api.service.MovieService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component // Spring annotation to indicate that this class is a component and should be managed by the Spring container
public class DataLoader{
    private final MovieService movieService; // Service for performing CRUD operations on movies
    private final CustomerService customerService;

    public DataLoader(MovieService movieService, CustomerService customerService) {
        this.movieService = movieService; // Assigning the injected service to the class variable
        this.customerService = customerService;
    }

    @PostConstruct
    // Spring annotation to indicate that this method should be executed after the bean is constructed and all dependencies are injected
    public void loadData() {
        // Check if the database is empty before loading data
        if (movieService.getAllMovies().isEmpty()) {
            // Create a list of movies to be added to the database
            List<Movie> movies = new ArrayList<>();
            movies.add(new Movie("The Shawshank Redemption", 1994, MovieGenre.DRAMA));
            movies.add(new Movie("The Godfather", 1972, MovieGenre.DRAMA));
            movies.add(new Movie("The Dark Knight", 2008, MovieGenre.ACTION));
            movies.add(new Movie("Pulp Fiction", 1994, MovieGenre.ACTION));
            movies.add(new Movie("Forrest Gump", 1994, MovieGenre.DRAMA));
            movies.add(new Movie("Inception", 2010, MovieGenre.ACTION));
            movies.add(new Movie("Fight Club", 1999, MovieGenre.DRAMA));
            movies.add(new Movie("The Matrix", 1999, MovieGenre.ACTION));
            movies.add(new Movie("The Lord of the Rings: The Return of the King", 2003, MovieGenre.ACTION));
            movies.add(new Movie("Interstellar", 2014, MovieGenre.SCI_FI));

            // Add the list of movies to the database
            movieService.addMovies(movies);
        }

        // add customers
        // Check if the database is empty before loading data
        if (customerService.getAllCustomers().isEmpty()) {

            List<Customer> customers = new ArrayList<>();

            Customer john = new Customer("John", "Doe", "john.doe@example.com");
            john.setRegistrationDate(LocalDate.of(2021, 1, 15));
            john.setAddress(new Address("Colombo", "12345"));
            customers.add(john);

            Customer jane = new Customer("Jane", "Smith", "jane.smith@example.com");
            jane.setRegistrationDate(LocalDate.of(2020, 5, 20));
            jane.setAddress(new Address("Kandy", "54321"));
            customers.add(jane);

            Customer alice = new Customer("Alice", "Johnson", "alice.johnson@example.com");
            alice.setRegistrationDate(LocalDate.of(2019, 3, 10));
            alice.setAddress(new Address("Galle", "67890"));
            customers.add(alice);

            Customer bob = new Customer("Bob", "Brown", "bob.brown@example.com");
            bob.setRegistrationDate(LocalDate.of(2022, 7, 25));
            bob.setAddress(new Address("Colombo", "12345"));
            customers.add(bob);

            customerService.saveAllCustomers(customers);
        }
    }
}