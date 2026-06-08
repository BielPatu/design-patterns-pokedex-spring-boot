package com.desafioprojeto.gof.controller;

import com.desafioprojeto.gof.models.Treinador;
import com.desafioprojeto.gof.services.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("treinador")
public class TreinadorController {

    @Autowired
    private TreinadorService treinadorService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Treinador>> BuscarPorId(@PathVariable Long id)
    {
        return ResponseEntity.ok(treinadorService.BuscarPorId(id));
    }
    @GetMapping
    public ResponseEntity<Iterable<Treinador>> BuscarTodos()
    {
        return ResponseEntity.ok(treinadorService.BuscarTodos());
    }
    @PostMapping()
    public ResponseEntity<Treinador> CriarTreinador(@RequestBody Treinador treinador)
    {
        treinadorService.Criar(treinador);
        return ResponseEntity.ok(treinador);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Treinador> AtualizarTreinador(@PathVariable Long id, @RequestBody Treinador treinador)
    {
        treinadorService.Atualizar(id, treinador);
        return ResponseEntity.ok(treinador);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarTreinador(@PathVariable Long id)
    {
        treinadorService.Deletar(id);
        return ResponseEntity.ok().build();
    }
}
