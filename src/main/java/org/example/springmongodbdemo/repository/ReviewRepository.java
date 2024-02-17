package org.example.springmongodbdemo.repository;

import org.bson.types.ObjectId;
import org.example.springmongodbdemo.pojo.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
