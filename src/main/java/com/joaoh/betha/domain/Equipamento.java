package com.joaoh.betha.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaoh.betha.domain.enums.TipoEquipamento;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer tipo;
    private String marca;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ordem_id")
    private OrdemDeServico ordemDeServico;

    public Equipamento() {}

    public Equipamento(Integer id, String nome, TipoEquipamento tipo, String marca, Cliente cliente, OrdemDeServico ordemDeServico) {
        this.id = id;
        this.nome = nome;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.marca = marca;
        this.cliente = cliente;
        this.ordemDeServico = ordemDeServico;
    }

    
    public TipoEquipamento getTipoEquipamento() {
        return TipoEquipamento.toEnum(tipo);
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipo = tipoEquipamento.getCod();
    }

}
