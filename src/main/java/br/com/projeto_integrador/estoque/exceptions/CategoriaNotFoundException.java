package br.com.projeto_integrador.estoque.exceptions;

import org.springframework.http.HttpStatus;


public class CategoriaNotFoundException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public CategoriaNotFoundException(HttpStatus status, String message) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public static CategoriaNotFoundException create(String message){
        return new CategoriaNotFoundException(HttpStatus.NOT_FOUND, message);
    }
}
