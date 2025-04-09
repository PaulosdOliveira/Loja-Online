package com.github.PaulosdOliveira.pedidos;

import com.github.PaulosdOliveira.pedidos.infra.repository.PedidoRepository;
import com.github.PaulosdOliveira.pedidos.model.Pedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PedidosApplicationTests {

    @Autowired
    private PedidoRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void cadastrarPedido() {

        repository.save(new Pedido());
    }

}
