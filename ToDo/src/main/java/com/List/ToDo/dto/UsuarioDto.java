package com.List.ToDo.dto;

import com.List.ToDo.entities.Usuario;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioDto {

    private Long Id;

    @NotBlank(message = "Digite um nome válido")
    private String nome;

    @NotBlank(message = "Digite um email válido")
    private String email;

    @Size(min = 6, max = 20, message = "Digite uma senha válido")
    private String senha;

    public  UsuarioDto(){

    }

    public UsuarioDto(Usuario user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
    }

    public UsuarioDto(Long id, String nome, String email, String senha) {
        this.Id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
