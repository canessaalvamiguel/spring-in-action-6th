package com.example.tacoscloud.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
public class Ingredient {

    @Id
    private final String id;
    private final String name;
    @Enumerated(EnumType.STRING)
    private final Type type;

    public enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
