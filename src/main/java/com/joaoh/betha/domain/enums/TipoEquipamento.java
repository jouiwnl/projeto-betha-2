package com.joaoh.betha.domain.enums;

public enum TipoEquipamento {

    ELETRONICO(1, "Eletrônico"),
    AUTOMOTIVO(2, "Automotivo"),
    DOMESTICO(3, "Doméstico");

    private int cod;
    private String descricao;

    TipoEquipamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoEquipamento toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (TipoEquipamento x : TipoEquipamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + cod);
    }
}
