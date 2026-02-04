package com.List.ToDo.dto;

import com.List.ToDo.entities.Usuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Getter
public class UsuarioDto {

    @NotBlank(message = "Digite um nome válido")
    private String nome;

    @NotBlank(message = "Digite um email válido")
    private String email;

    @Size(min = 6, max = 20, message = "Digite uma senha válido")
    private String senha;


    public UsuarioDto(Usuario user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
    }

    public UsuarioDto( String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

}
