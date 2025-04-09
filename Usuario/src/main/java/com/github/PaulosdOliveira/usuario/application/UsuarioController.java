package com.github.PaulosdOliveira.usuario.application;

import com.github.PaulosdOliveira.usuario.model.dto.LoginUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @GetMapping
    public String getStatus(){
        return "Serviço de usuários funcionando";
    }

    @PostMapping
    public String getToken(@RequestBody LoginUsuarioDTO dadosLogin) {
        return service.logarUsuario(dadosLogin);
    }
}
