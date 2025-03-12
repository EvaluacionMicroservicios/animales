package com.refuerzo.animales.service.impl;

import com.refuerzo.animales.model.Animal;
import com.refuerzo.animales.repository.AnimalesRepository;
import com.refuerzo.animales.service.AnimalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnimalesImpl implements AnimalesService {

    @Autowired
    private AnimalesRepository animalesRepository;

    @Override
    public Flux<Animal> getAll(){
        return animalesRepository.findAll();
    }

    @Override
    public Mono<Animal> getById(String id){
        return animalesRepository.findById(id);
    }

    @Override
    public Mono<Animal> saveAnimal(Animal animal){
        return animalesRepository.save(animal);
    }

    @Override
    public Mono<Animal> updateAnimal(String id, Animal animal){
        return animalesRepository.findById(id)
                .flatMap(exisstingAnimal -> {
                    exisstingAnimal.setNombre(animal.getNombre() != null ? animal.getNombre() : exisstingAnimal.getNombre());
                    exisstingAnimal.setCantidad(animal.getCantidad() != 0 ? animal.getCantidad() : exisstingAnimal.getCantidad());
                    return animalesRepository.save(exisstingAnimal);
                });
    }

    @Override
    public Mono<Void> deleteAnimal(String id){
        return animalesRepository.deleteById(id);
    }

}
