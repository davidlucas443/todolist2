package com.List.ToDo.controller;

import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repositories.UsuarioRepository;
import com.List.ToDo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("create")
    public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioDto dto) {

        return ResponseEntity.ok(usuarioService.criarUsuario(dto));

    }

    @GetMapping(value = "listar")
    public List<UsuarioDto> listarUsuario() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDto> listaDeUsuarios =
                usuarios.stream().map(UsuarioDto::new).toList();
        for (Usuario usuario : usuarios) {
            listaDeUsuarios.add(new UsuarioDto(usuario));
        }
        return listaDeUsuarios;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.deletar(id));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.atualizar(id));
    }
}
