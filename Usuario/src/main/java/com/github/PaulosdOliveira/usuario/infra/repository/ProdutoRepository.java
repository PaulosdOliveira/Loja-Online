package com.github.PaulosdOliveira.usuario.infra.repository;

import com.github.PaulosdOliveira.usuario.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
