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

    @OneToMany(mappedBy = "ordemDeServico")
    private List<Equipamento> equipamentos = new ArrayList<>();

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
