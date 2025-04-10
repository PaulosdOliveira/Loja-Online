package com.github.PaulosdOliveira.pedidos.infra.repository;

import com.github.PaulosdOliveira.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository  extends JpaRepository<Pedido, UUID> {

    @Query("Select p from Pedido p where p.idUsuario = :idUsuario")
    List<Pedido> buscarPedidosPendentesUsuario(@Param("idUsuario") Long idUsuario);
}
