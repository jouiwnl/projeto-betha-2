package com.joaoh.betha.domain.enums;


public enum EstadoAtendimento {

    ABERTA(1, "Em aberto"),
    ATENDIMENTO(2, "Em atendimento"),
    CONLUIDA(3, "Concluída");

    private Integer cod;
    private String descricao;
    
    EstadoAtendimento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoAtendimento toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (EstadoAtendimento x : EstadoAtendimento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
