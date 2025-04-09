package com.github.PaulosdOliveira.usuario.application.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;


    @PostMapping
    public ResponseEntity<String> fazerPedido(@PathVariable Long idProduto){
        String resultado = service.fazerPedido(idProduto);
        return ResponseEntity.ok(resultado);
    }
}
