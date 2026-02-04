package com.List.ToDo.service;

import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto criarUsuario(UsuarioDto dto){
        Usuario user = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha());
        usuarioRepository.save(user);
        return dto;
    }

    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }


    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
    }

    public String deletar(Long id) {

        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Excluído com sucesso!";
        } else {
            return "Esse ID não existe";
        }
    }

    public String atualizar(Long id) {

        Optional<Usuario> UsuarioExiste = usuarioRepository.findById(id);
        if (UsuarioExiste.isPresent()) {
            Usuario usuario = UsuarioExiste.get();
            usuario.setNome(usuario.getNome());
            usuario.setSenha(usuario.getSenha());
            usuarioRepository.save(usuario);
            UsuarioDto teste = new UsuarioDto(usuario);
            return "Usuario atualizado";
        } else {
            return "Esse ID não existe";
        }
    }
}
