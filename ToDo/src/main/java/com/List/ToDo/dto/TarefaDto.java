package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import com.List.ToDo.entities.Usuario;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class TarefaDto {

    private long idUser;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;

    public TarefaDto(TarefaDto dto) {
        this.idUser = dto.getIdUser();
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.status = dto.getStatus();
        this.dtInicio = dto.getDtInicio();
        this.dtFim = dto.getDtFim();
    }

    public TarefaDto(String nome, String descricao, Status status, LocalDate dtInicio, LocalDate dtFim) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }
}

