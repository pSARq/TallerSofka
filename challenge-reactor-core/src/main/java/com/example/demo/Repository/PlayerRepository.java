package com.example.demo.Repository;

import com.example.demo.Collection.PlayerCollection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends ReactiveMongoRepository<PlayerCollection, String> {
}
