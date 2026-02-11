package com.List.ToDo.controller;

import com.List.ToDo.dto.TarefaDto;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.service.TarefaServic;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TarefaController {

    private final TarefaServic tarefaService;

    public TarefaController(TarefaServic tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/usuarios/{id}/tarefas")
    public ResponseEntity<Tarefa> criarTarefa(
            @PathVariable Long id,
            @Valid @RequestBody TarefaDto dto) {

        Tarefa tarefa = tarefaService.criarTarefa(id, dto);
        return ResponseEntity.status(201).body(tarefa);
    }

    @GetMapping("/usuarios/{id}/tarefas")
    public ResponseEntity<List<Tarefa>> listarTarefasPorUsuario(
            @PathVariable Long id) {

        List<Tarefa> tarefas = tarefaService.listarTarefasPorUsuario(id);
        return ResponseEntity.ok(tarefas);
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(
            @PathVariable Long id,
            @RequestBody TarefaDto dto) {

        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, dto);
        return ResponseEntity.ok(tarefaAtualizada);
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {

        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
