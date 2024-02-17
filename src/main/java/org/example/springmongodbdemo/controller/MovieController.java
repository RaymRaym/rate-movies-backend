package org.example.springmongodbdemo.controller;

import org.example.springmongodbdemo.pojo.Movie;
import org.example.springmongodbdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() {
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> moviesById(@PathVariable String id) {
        return new ResponseEntity<>(movieService.getMovieByImdbId(id), HttpStatus.OK);
    }

    @GetMapping("/genres")
    public ResponseEntity<Optional<List<Movie>>> moviesByGenre(@RequestBody Map<String, List<String>> payload) {
        return new ResponseEntity<>(movieService.getMoviesByGenresContains(payload.get("genres")), HttpStatus.OK);
    }

}
