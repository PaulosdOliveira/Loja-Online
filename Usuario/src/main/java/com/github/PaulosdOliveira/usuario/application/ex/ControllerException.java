package com.github.PaulosdOliveira.usuario.application.ex;

import com.github.PaulosdOliveira.usuario.ex.erro.ErroCampo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.github.PaulosdOliveira.usuario.ex.ProdutoNaoEncontradoException;
import com.github.PaulosdOliveira.usuario.ex.EmailDuplicadoException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestControllerAdvice
public class ControllerException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public String handlerUsernameNotFoundException(UsernameNotFoundException e){
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroCampo> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var erros = e.getFieldErrors();
        List<ErroCampo> listaErros = erros.stream()
                .map(erro -> new ErroCampo(erro.getField(), erro.getDefaultMessage()))
                .toList();
        return listaErros;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(EmailDuplicadoException.class)
    public String handlerEmailDuplicadoException(EmailDuplicadoException e){
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public String handlerProdutoNaoEncontradoException(ProdutoNaoEncontradoException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String handlerInternalException(RuntimeException e){
        System.out.println(e);
        return "Algo de errado";
    }
}
