package com.eventrest.model;

/**
 *
 * @author renan
 */
public enum Resposta {

    SIM("Sim"), NAO("Não"), TALVEZ("Talvez");
    private final String descricao;

    private Resposta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
