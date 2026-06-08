package com.desafioprojeto.gof.services;

import com.desafioprojeto.gof.models.Treinador;

import java.util.Optional;

public interface TreinadorService {

    Iterable<Treinador> BuscarTodos();

    Optional<Treinador> BuscarPorId(Long id);

    Treinador Atualizar(Long id, Treinador treinador);

    Treinador Deletar(Long id);

    Treinador Criar(Treinador treinador);

}
