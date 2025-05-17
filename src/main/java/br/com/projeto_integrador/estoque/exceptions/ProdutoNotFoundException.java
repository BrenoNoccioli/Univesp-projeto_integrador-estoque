package br.com.projeto_integrador.estoque.exceptions;

import org.springframework.http.HttpStatus;

public class ProdutoNotFoundException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public ProdutoNotFoundException(HttpStatus status, String message) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public static ProdutoNotFoundException create(String message){
        return new ProdutoNotFoundException(HttpStatus.NOT_FOUND, message);
    }
}
