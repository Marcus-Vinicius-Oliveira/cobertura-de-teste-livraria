package com.americanas.testes.cobrerturatestes.exception;

public class LivroNaoDisponivelException extends RuntimeException {

    public LivroNaoDisponivelException(String message) {
        super(message);
    }

    public LivroNaoDisponivelException(String message, Throwable cause) {
        super(message, cause);
    }

}

