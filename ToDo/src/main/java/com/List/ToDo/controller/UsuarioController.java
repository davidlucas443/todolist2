package com.List.ToDo.controller;

import com.List.ToDo.dto.UsuarioDto;
import com.List.ToDo.repositories.UsuarioRepository;
import com.List.ToDo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("criar")
    public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioDto dto){

        return ResponseEntity.ok(usuarioService.criarUsuario(dto));

//        return ResponseEntity.status(HttpStatus.CREATED);


    }





}
