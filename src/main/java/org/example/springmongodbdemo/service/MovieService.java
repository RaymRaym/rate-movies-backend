package org.example.springmongodbdemo.service;

import org.example.springmongodbdemo.pojo.Movie;
import org.example.springmongodbdemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieByImdbId(String id) {
        return movieRepository.getMovieByImdbId(id);
    }

    public Optional<List<Movie>> getMoviesByGenresContains(List<String> genres) {
        return movieRepository.getMoviesByGenresContains(genres, PageRequest.of(0, 2, Sort.by("title")));
    }

}
