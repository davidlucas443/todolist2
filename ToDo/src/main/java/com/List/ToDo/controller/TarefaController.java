package com.List.ToDo.controller;

import com.List.ToDo.dto.TarefaDto;
import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.service.TarefaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<?>criarTarefa(@Valid @RequestBody TarefaDto dto){
        tarefaService.criarTarefa(dto);
        return ResponseEntity.ok("Tarefa concluída com sucesso!!");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.buscarTarefaPorId(id);
        if (tarefa == null) {
            return ResponseEntity.status(404).body("Tarefa não encontrada");
        }
        return ResponseEntity.ok(tarefa);
    }
    @GetMapping
    public ResponseEntity<List<TarefaDto>> listarTodos() {
        List<TarefaDto> tarefas = tarefaService.listarTarefas()
                .stream()//o stream percorre a lista
                .map(t -> new TarefaDto(t.getNome(),t.getDescricao(),t.getStatus(),t.getDtInicio(),t.getDtFim()))// transforma o Pet no PetResponseDto
                .toList(); //Gera uma nova lista
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletarTarefa(@PathVariable Long id) {

        tarefaService.deletarTarefa(id);

        return ResponseEntity.ok("Tarefa deletada com sucesso");
    }

    @PutMapping("{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody TarefaDto dto) {
        Tarefa tarefaAtualizada = tarefaService.atualizarTarefa(id, dto);

        if (tarefaAtualizada == null) {
            return ResponseEntity.status(404).body("Tarefa não encontrada");
        }

        return ResponseEntity.ok(tarefaAtualizada);
    }

}
