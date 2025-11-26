package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TarefaDto {

    private Long Id;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;


    public TarefaDto(LocalDate dtFim, LocalDate dtInicio, Status status, String descricao, String nome) {
        this.dtFim = dtFim;
        this.dtInicio = dtInicio;
        this.status = status;
        this.descricao = descricao;
        this.nome = nome;
    }
}
