package com.List.ToDo.controller;

import com.List.ToDo.dto.TarefaDto;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.service.TarefaService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("task")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @PostMapping("create")
    public ResponseEntity<?>criarTarefa(@Valid @RequestBody TarefaDto dto){
        tarefaService.criarTarefa(dto);
        return ResponseEntity.ok("Tarefa concluída com sucesso!!");
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        tarefaService.deletarTarefa(id);

        return ResponseEntity.ok("Tarefa deletada com sucesso");
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

        Tarefa tarefa = tarefaService.buscarTarefaPorId(id);

        if (tarefa == null) {
            return ResponseEntity.status(404).body("Tarefa não encontrada");
        }

        return ResponseEntity.ok(tarefa);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody TarefaDto dto) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, dto);

        if (tarefaAtualizada == null) {
            return ResponseEntity.status(404).body("Tarefa não encontrada");
        }

        return ResponseEntity.ok(tarefaAtualizada);
    }

}
