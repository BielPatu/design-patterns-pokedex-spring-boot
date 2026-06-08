package com.desafioprojeto.gof.services;

import com.desafioprojeto.gof.models.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "pokeapi", url = "https://pokeapi.co")
public interface PokeApiService {
    //Usamos Get com o mesmo ID passado durante a busca
    @GetMapping("api/v2/pokemon/{pokeID}")
    //Variavel vai ser o ID do pokémon
    Pokemon procurarPokemon(@PathVariable String pokeID);
}
