package br.localiza.aluguelcarros.excecoes;

public class AlocaoInvalidaException extends RuntimeException{

    public AlocaoInvalidaException() {
        super("O carro se encontra indisponível");
    }

    public AlocaoInvalidaException(String msg) {
        super(msg);
    }
}
