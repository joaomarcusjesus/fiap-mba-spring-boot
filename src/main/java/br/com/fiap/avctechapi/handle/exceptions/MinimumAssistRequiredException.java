package br.com.fiap.avctechapi.handle.exceptions;

import lombok.Getter;

@Getter
public class MinimumAssistRequiredException extends RuntimeException{
    private String description;

    public MinimumAssistRequiredException(String message, String description){
        super(message);
        this.description =  description;
    }

}