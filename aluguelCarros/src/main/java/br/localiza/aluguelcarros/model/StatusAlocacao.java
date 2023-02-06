package br.localiza.aluguelcarros.model;

public enum StatusAlocacao {

    ABERTA("ABERTA"),NEGOCIACAO("NEGOCIACAO"),FECHADA("FECHADA");

    private String valor;

    StatusAlocacao(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
