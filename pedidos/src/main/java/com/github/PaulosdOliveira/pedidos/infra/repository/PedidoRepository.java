package com.github.PaulosdOliveira.pedidos.infra.repository;

import com.github.PaulosdOliveira.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository  extends JpaRepository<Pedido, UUID> {
}
