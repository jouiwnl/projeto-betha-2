package com.joaoh.betha.domain;

import com.joaoh.betha.domain.enums.TipoEquipamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer tipo;
    private String marca;

    public Equipamento() {}

    public Equipamento(Integer id, String nome, TipoEquipamento tipo, String marca) {
        this.id = id;
        this.nome = nome;
        this.tipo = (tipo == null) ? null : tipo.getCod();
        this.marca = marca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoEquipamento getTipoEquipamento() {
        return TipoEquipamento.toEnum(tipo);
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipo = tipoEquipamento.getCod();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipamento that = (Equipamento) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
