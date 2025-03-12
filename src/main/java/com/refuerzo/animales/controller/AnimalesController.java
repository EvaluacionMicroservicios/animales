package com.refuerzo.animales.controller;

import com.refuerzo.animales.model.Animal;
import com.refuerzo.animales.service.AnimalesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/animales")
public class AnimalesController {

    private final AnimalesService animalesService;

    public AnimalesController(AnimalesService animalesService) {
        this.animalesService = animalesService;
    }

    @GetMapping
    public Flux<Animal> getAll(){
        return animalesService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Animal> getBydId(@PathVariable String id){
        return animalesService.getById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Animal no encontrado")));
    }

    @PostMapping("/save-animales")
    public Mono<Animal> saveAnimal(@RequestBody Animal animal){
        return animalesService.saveAnimal(animal);
    }

    @PutMapping("/update-animales/{id}")
    public Mono<Animal> updateAnimal(@PathVariable String id, @RequestBody Animal animal){
        return animalesService.updateAnimal(id, animal)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"Animal no encontrado")));
    }

    @DeleteMapping("/delete-animales/{id}")
    public Mono<Void> deleteAnimal(@PathVariable String id){
        return animalesService.deleteAnimal(id);
    }

}
