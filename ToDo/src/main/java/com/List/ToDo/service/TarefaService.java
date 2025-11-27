package com.List.ToDo.service;

import com.List.ToDo.dto.TarefaDto;
import com.List.ToDo.entities.Status;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.repositories.TarefaRepository;
import com.List.ToDo.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public void criarTarefa(TarefaDto dto){
        Tarefa task = new Tarefa(dto);
        tarefaRepository.save(task);

    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }


    public Tarefa buscarTarefaPorId(Long id) {
        return tarefaRepository.findById(id).orElse(null);
    }


    public Tarefa atualizarTarefa(Long id, TarefaDto dto) {

        Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

        if (tarefa == null) {
            return null;
        }
        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDtFim(dto.getDtFim());
        return tarefaRepository.save(tarefa);
    }



}
