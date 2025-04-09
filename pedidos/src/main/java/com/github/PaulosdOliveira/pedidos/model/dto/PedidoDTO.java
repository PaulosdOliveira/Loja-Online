package com.github.PaulosdOliveira.pedidos.model.dto;


public class PedidoDTO {

    private Long idUsuario;
    private Long idProduto;

    public PedidoDTO() {

    }

    public PedidoDTO(Long idUsuario, Long idProduto) {
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
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
}
