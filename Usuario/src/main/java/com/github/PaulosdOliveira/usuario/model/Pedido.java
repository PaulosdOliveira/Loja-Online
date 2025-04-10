package com.github.PaulosdOliveira.usuario.model;


import java.time.LocalDate;
import java.util.UUID;

public class Pedido {
    private UUID idPedido;
    private Long idUsuario;
    private Long idProduto;
    private LocalDate dataPedido;
    private LocalDate dataEntrega;
    private String enderecoEntrega;
    private Boolean entrege;


    public UUID getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(UUID idPedido) {
        this.idPedido = idPedido;
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

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Boolean getEntrege() {
        return entrege;
    }

    public void setEntrege(Boolean entrege) {
        this.entrege = entrege;
    }
}
