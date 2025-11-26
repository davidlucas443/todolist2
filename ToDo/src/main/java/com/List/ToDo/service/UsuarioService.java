package com.List.ToDo.service;

import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDto criarUsuario(UsuarioDto dto){
        Usuario user = new Usuario(dto);
        usuarioRepository.save(user);
        UsuarioDto udto = new UsuarioDto(user);
        return udto;
    }
}
