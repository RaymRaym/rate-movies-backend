package org.example.springmongodbdemo;

import org.example.springmongodbdemo.pojo.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
class SpringMongodbDemoApplicationTests {
    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    void contextLoads() {
        Query query = new Query();
        query.addCriteria(Criteria.where("imdbId").is("tt3915174"));
        List<Movie> movies = mongoTemplate.find(query, Movie.class);
        movies.forEach(System.out::println);

    }

}
