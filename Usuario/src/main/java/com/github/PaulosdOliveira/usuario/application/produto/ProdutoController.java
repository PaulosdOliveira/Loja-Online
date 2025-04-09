package com.github.PaulosdOliveira.usuario.application.produto;

import com.github.PaulosdOliveira.usuario.model.dto.CadastroProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarProduto(@RequestBody @Valid CadastroProdutoDTO produtoDTO) {
        service.cadastrarProduto(produtoDTO);
    }
}
