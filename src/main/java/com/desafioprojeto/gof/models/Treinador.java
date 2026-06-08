package com.desafioprojeto.gof.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Vou usar Getter e Setter para evitar criar linhas desnecessarias de código
@Getter
@Setter

@Entity
public class Treinador {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String nome;
    @OneToMany //Indica que um diversos pokémons podem pertencer a esse treinador
    private List<Pokemon> pokemon;

}
