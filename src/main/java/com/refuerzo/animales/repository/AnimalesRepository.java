package com.refuerzo.animales.repository;

import com.refuerzo.animales.model.Animal;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalesRepository extends ReactiveMongoRepository<Animal, String> {
}
