package com.github.PaulosdOliveira.usuario.infra.repository.openFeign;

import com.github.PaulosdOliveira.usuario.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "pedidos", path = "/pedido")
public interface PedidoClient {

    @GetMapping("/{idUsuario}")
    ResponseEntity<List<Pedido>> buscarPedidosPendentesUsuario(@PathVariable Long idUsuario);
}
