package com.List.ToDo.service;

import com.List.ToDo.dto.TarefaDto;
import com.List.ToDo.entities.Status;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repositories.TarefaRepository;
import com.List.ToDo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TarefaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final TarefaRepository tarefaRepository;
    @Autowired
    private ThreadPoolTaskExecutorBuilder threadPoolTaskExecutorBuilder;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public void criarTarefa(TarefaDto dto){
        Optional<Usuario> user = usuarioRepository.findById(dto.getIdUser());

        if (user.isPresent()){
            Tarefa task = new Tarefa();
            task.setUsuario(user);
            task.setNome(dto.getNome());
            task.setDescricao(dto.getDescricao());
            task.setStatus(dto.getStatus());
            task.setDtFim(dto.getDtFim());
            tarefaRepository.save(task);
        }else {
            System.out.println("tente novamente");
        }

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
