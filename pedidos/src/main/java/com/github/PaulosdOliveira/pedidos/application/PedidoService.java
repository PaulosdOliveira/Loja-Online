package com.github.PaulosdOliveira.pedidos.application;

import com.github.PaulosdOliveira.pedidos.infra.repository.PedidoRepository;
import com.github.PaulosdOliveira.pedidos.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.PaulosdOliveira.pedidos.model.dto.PedidoDTO;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public void fazerPedido(PedidoDTO dto){
        repository.save(new Pedido(dto));
    }

    public List<Pedido> buscarPedidosPendentesUsuario(Long idUsuario){
        return repository.buscarPedidosPendentesUsuario(idUsuario);
    }
}
