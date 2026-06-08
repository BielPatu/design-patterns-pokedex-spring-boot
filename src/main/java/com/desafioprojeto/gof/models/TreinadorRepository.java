package com.desafioprojeto.gof.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends CrudRepository<Treinador, Long> {
}
