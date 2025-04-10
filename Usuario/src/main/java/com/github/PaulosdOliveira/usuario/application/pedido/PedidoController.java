package com.github.PaulosdOliveira.usuario.application.pedido;

import com.github.PaulosdOliveira.usuario.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;


    @PostMapping("/{idProduto}")
    public ResponseEntity<String> fazerPedido(@PathVariable Long idProduto){
        String resultado = service.fazerPedido(idProduto);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarPedidosPendentesUsuario(){
        var pedidos = service.buscarPedidosPendentesUsuario();
        return pedidos != null? ResponseEntity.ok(pedidos) : ResponseEntity.notFound().build();
    }
}
