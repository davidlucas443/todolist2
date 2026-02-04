package com.List.ToDo.entities;

import com.List.ToDo.dto.TarefaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Tarefa(long id, String nome, String descricao, Status status, LocalDate dtInicio, LocalDate dtFim, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.usuario = usuario;
    }

    public Tarefa(TarefaDto dto) {

        this.nome = dto.getDescricao();
        this.descricao = dto.getNome();
        this.status = dto.getStatus();
        this.dtInicio = dto.getDtInicio();
        this.dtFim = dto.getDtFim();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Optional<Usuario> user) {
    }
}
