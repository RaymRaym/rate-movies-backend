package org.example.springmongodbdemo.repository;

import org.bson.types.ObjectId;
import org.example.springmongodbdemo.pojo.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> getMovieByImdbId(String imdbId);
    Optional<List<Movie>> getMoviesByGenresContains(List<String> genres, Pageable pageable);
}
