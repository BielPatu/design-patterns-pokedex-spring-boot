package com.desafioprojeto.gof.services.impl;

import com.desafioprojeto.gof.models.Treinador;
import com.desafioprojeto.gof.models.TreinadorRepository;
import com.desafioprojeto.gof.models.Pokemon;
import com.desafioprojeto.gof.models.PokemonRepository;
import com.desafioprojeto.gof.services.TreinadorService;
import com.desafioprojeto.gof.services.PokeApiService;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ToString
@Service
public class TreinadorServiceImpl implements TreinadorService {

    @Autowired
    private TreinadorRepository treinadorRepository;
    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private PokeApiService pokeApiService;

    @Override
    public Iterable<Treinador> BuscarTodos() {
        return treinadorRepository.findAll();
    }

    @Override
    public Optional<Treinador> BuscarPorId(Long id) {
        return treinadorRepository.findById(id);
    }

    @Override
    public Treinador Atualizar(Long id, Treinador treinador) {
        Optional<Treinador> clienteBD = treinadorRepository.findById(id);
        if(clienteBD.isPresent()){
            treinador.setId(clienteBD.get().getId());
            salvarTreinadorComPokemon(treinador);
            return treinador;
        }

        return null;
    }

    @Override
    public Treinador Deletar(Long id) {
        treinadorRepository.deleteById(id);
        return null;
    }

    @Override
    public Treinador Criar(Treinador treinador) {
        salvarTreinadorComPokemon(treinador);
        return treinador;
    }



    private void salvarTreinadorComPokemon(Treinador treinador) {
        //Pegamos os pokemons do treinador que vamos criar
        List<Pokemon> pokemonsDoTreinador = treinador.getPokemon();
        //Criamos uma lista que vai armazenar a equipe para settarmos ela mais tarde
        List<Pokemon> pokemonsParaAdicionar = new ArrayList<>();

        //Rodaremos aqui um ciclo foreach para o sistema ser capaz de detectar multiplas instancias de pokemon
        for (Pokemon pokemon : pokemonsDoTreinador) {
            //Guardar o ID aqui por praticidade
            Long pokemonID = pokemon.getId();

            Pokemon pokemonEncontrado = pokemonRepository.findById(pokemonID)
                    .orElseGet(() -> {
                        Pokemon novoPokemon = pokeApiService.procurarPokemon(String.valueOf(pokemonID));
                        return pokemonRepository.save(novoPokemon);
                    });
            //Ao final do loop sempre adicionar o pokemon encontrado
            pokemonsParaAdicionar.add(pokemonEncontrado);
        }

        treinador.setPokemon(pokemonsParaAdicionar);
        treinadorRepository.save(treinador);
    }
}
