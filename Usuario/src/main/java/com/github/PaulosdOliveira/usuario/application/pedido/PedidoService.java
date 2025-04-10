package com.github.PaulosdOliveira.usuario.application.pedido;

import com.github.PaulosdOliveira.usuario.application.UsuarioService;
import com.github.PaulosdOliveira.usuario.application.produto.ProdutoService;
import com.github.PaulosdOliveira.usuario.infra.repository.mq.pedido.PedidoPublisher;
import com.github.PaulosdOliveira.usuario.infra.repository.openFeign.PedidoClient;
import com.github.PaulosdOliveira.usuario.model.Pedido;
import com.github.PaulosdOliveira.usuario.model.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {


    @Autowired
    private PedidoPublisher pedidoPublisher;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PedidoClient pedidoClient;


    public String fazerPedido(Long idProduto) {
        try {
            produtoService.existsById(idProduto);
            String idUsuarioSTR = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
            Long idUsuario = Long.parseLong(idUsuarioSTR);
            String enderecoEntrega = usuarioService.getEnderecoEntrega(idUsuario);
            PedidoDTO dto = new PedidoDTO(idUsuario, idProduto, enderecoEntrega);
            pedidoPublisher.fazerPedido(dto);
            return "Pedido realizado com sucesso";
        } catch (Exception e) {
            System.out.println(e.getMessage() + "  $$$$$$$$$$$$$$$");
            return "Algo deu errado";
        }

    }

    public List<Pedido> buscarPedidosPendentesUsuario() {
        String idSTR = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();
        Long idUsuario = Long.parseLong(idSTR);
        return pedidoClient.buscarPedidosPendentesUsuario(idUsuario).getBody();
    }
}
