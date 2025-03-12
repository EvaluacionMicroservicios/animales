package com.refuerzo.animales.service;

import com.refuerzo.animales.model.Animal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnimalesService {

    public Flux<Animal> getAll();
    public Mono<Animal> getById(String id);
    public Mono<Animal> saveAnimal(Animal animal);
    public Mono<Animal> updateAnimal(String id, Animal animal);
    public Mono<Void> deleteAnimal(String id);

}
