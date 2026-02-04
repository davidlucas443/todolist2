package com.List.ToDo.controller;

import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.entities.Tarefa;
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
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioDto dto) {
        return ResponseEntity.ok(usuarioService.criarUsuario(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuario não encontrada");
        }
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> listarTodos() {
        List<UsuarioDto> usuarios = usuarioService.listarUsuario()
                .stream()//o stream percorre a lista
                .map(u -> new UsuarioDto(u.getNome(),u.getEmail(),u.getSenha()))// transforma o Pet no PetResponseDto
                .toList(); //Gera uma nova lista
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.deletar(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.atualizar(id));
    }
}
