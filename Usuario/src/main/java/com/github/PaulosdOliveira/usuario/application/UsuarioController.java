package com.github.PaulosdOliveira.usuario.application;

import com.github.PaulosdOliveira.usuario.model.dto.CadastroUsuarioDTO;
import com.github.PaulosdOliveira.usuario.model.dto.LoginUsuarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping
    public String getStatus() {
        return "Serviço de usuários funcionando";
    }

    @PostMapping("/login")
    public String getToken(@RequestBody LoginUsuarioDTO dadosLogin) {
        return service.logarUsuario(dadosLogin);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarUsuario(@RequestBody @Valid CadastroUsuarioDTO dadosCadastrais) {
        service.cadastrarUsuario(dadosCadastrais);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
