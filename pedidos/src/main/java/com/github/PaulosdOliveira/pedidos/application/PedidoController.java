package com.github.PaulosdOliveira.pedidos.application;

import com.github.PaulosdOliveira.pedidos.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;


    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<Pedido>> buscarPedidosPendentesUsuario(@PathVariable Long idUsuario){
        var listaPedidos = service.buscarPedidosPendentesUsuario(idUsuario);
        return ResponseEntity.ok(listaPedidos);
    }
}
