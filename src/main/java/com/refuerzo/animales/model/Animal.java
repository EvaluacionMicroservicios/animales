package com.refuerzo.animales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document (collection = "Animales")
public class Animal {

    @Id
    private String id;
    private String nombre;
    private int cantidad;

}
