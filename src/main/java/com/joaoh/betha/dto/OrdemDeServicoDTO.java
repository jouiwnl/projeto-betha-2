package com.joaoh.betha.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.domain.enums.EstadoAtendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemDeServicoDTO implements Serializable{

    private Integer id;

    private Long timestamp;
    private Cliente cliente;
    private String detalhe;
    private Integer estadoAtendimento;

 
    
    public OrdemDeServicoDTO() {}



    public OrdemDeServicoDTO(Integer id, Long timestamp, Cliente cliente, String detalhe, EstadoAtendimento estadoAtendimento) {
        this.id = id;
        this.timestamp = timestamp;
        this.cliente = cliente;
        this.detalhe = detalhe;
        this.estadoAtendimento = (estadoAtendimento == null) ? null : estadoAtendimento.getCod();
    }
    
    public EstadoAtendimento getEstadoAtendimento() {
        return EstadoAtendimento.toEnum(estadoAtendimento);
    }

    public void setEstadoAtendimento(EstadoAtendimento estadoAtendimento) {
        this.estadoAtendimento = estadoAtendimento.getCod();
    }


}
