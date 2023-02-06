package br.localiza.aluguelcarros.excecoes;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcecoesController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity validarParametro (){
        return ResponseEntity.notFound().build();
    }

}
