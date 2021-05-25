package com.joaoh.betha.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaoh.betha.domain.enums.EstadoAtendimento;
import com.joaoh.betha.domain.enums.TipoEquipamento;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class OrdemDeServico implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long timestamp;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    private String detalhe;
    private Integer estadoAtendimento;

    private String nomeEquipamento;
    private String marcaEquipamento;
    private Integer tipoEquipamento;


    public OrdemDeServico() {}


    public OrdemDeServico(Integer id, Long timestamp, Cliente cliente, String detalhe, EstadoAtendimento estadoAtendimento, String nomeEquipamento, String marcaEquipamento, TipoEquipamento tipoEquipamento) {
        this.id = id;
        this.timestamp = timestamp;
        this.cliente = cliente;
        this.detalhe = detalhe;
        this.estadoAtendimento = (estadoAtendimento == null) ? null : estadoAtendimento.getCod();
        this.nomeEquipamento = nomeEquipamento;
        this.marcaEquipamento = marcaEquipamento;
        this.tipoEquipamento = (tipoEquipamento == null) ? null : tipoEquipamento.getCod();
     }    

    public EstadoAtendimento getEstadoAtendimento() {
        return EstadoAtendimento.toEnum(estadoAtendimento);
    }

    public void setEstadoAtendimento(EstadoAtendimento estadoAtendimento) {
        this.estadoAtendimento = estadoAtendimento.getCod();
    }

    public TipoEquipamento getTipoEquipamento() {
        return TipoEquipamento.toEnum(tipoEquipamento);
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento.getCod();
    }
}
