package com.github.PaulosdOliveira.Login.application;

import com.github.PaulosdOliveira.Login.model.dto.CadastroUsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody CadastroUsuarioDTO dadosUsuario){
        service.cadastrarUsuario(dadosUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
