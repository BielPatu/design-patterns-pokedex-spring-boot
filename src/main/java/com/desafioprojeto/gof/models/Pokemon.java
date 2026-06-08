package com.desafioprojeto.gof.models;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Pokemon {

    @Id
    private Long id;

    private String name;

}
