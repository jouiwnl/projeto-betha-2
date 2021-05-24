package com.joaoh.betha.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joaoh.betha.domain.enums.EstadoAtendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public OrdemDeServico() {}


    public OrdemDeServico(Integer id, Long timestamp, Cliente cliente, String detalhe, EstadoAtendimento estadoAtendimento) {
        this.id = id;
        this.timestamp = timestamp;
        this.cliente = cliente;
        this.detalhe = detalhe;
        this.estadoAtendimento = (estadoAtendimento == null) ? null : estadoAtendimento.getCod();
     }    

    public EstadoAtendimento GetEstadoAtendimento() {
        return EstadoAtendimento.toEnum(estadoAtendimento);
    }

    public void setEstadoAtendimento(EstadoAtendimento estadoAtendimento) {
        this.estadoAtendimento = estadoAtendimento.getCod();
    }
}
