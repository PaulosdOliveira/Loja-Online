package com.github.PaulosdOliveira.usuario.application.produto;

import com.github.PaulosdOliveira.usuario.ex.ProdutoNaoEncontradoException;
import com.github.PaulosdOliveira.usuario.infra.repository.ProdutoRepository;
import com.github.PaulosdOliveira.usuario.model.dto.CadastroProdutoDTO;
import com.github.PaulosdOliveira.usuario.model.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;


    public void cadastrarProduto(CadastroProdutoDTO dto){
        repository.save(new Produto(dto));
    }

    public Produto findById(Long id){
        return repository.findById(id)
                .orElseThrow(ProdutoNaoEncontradoException::new);
    }
}
