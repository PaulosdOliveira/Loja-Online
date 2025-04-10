package com.github.PaulosdOliveira.pedidos.model;

import com.github.PaulosdOliveira.pedidos.model.dto.PedidoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDate;
import java.util.UUID;


@EntityListeners(AuditingEntityListener.class)
@Entity
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idPedido;


    private Long idUsuario;


    private Long idProduto;

    @CreatedDate
    private LocalDate dataPedido;

    @Column(nullable = false)
    private LocalDate dataEntrega;

    private String enderecoEntrega;


    private Boolean entregue;

    public Pedido() {
    }

    public Pedido(PedidoDTO dto) {
        BeanUtils.copyProperties(dto, this);
       dataEntrega = LocalDate.now().plusDays(3);
    }


    public UUID getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
    }


    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Boolean getEntregue() {
        return entregue;
    }

    public void setEntregue(Boolean entregue) {
        this.entregue = entregue;
    }
}
