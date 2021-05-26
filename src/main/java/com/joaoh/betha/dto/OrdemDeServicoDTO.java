package com.joaoh.betha.dto;

import java.io.Serializable;

import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.domain.enums.EstadoAtendimento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemDeServicoDTO implements Serializable{

    private Integer id;

    private String detalhe;
    private Integer estadoAtendimento;
    
    public OrdemDeServicoDTO(OrdemDeServico obj) {
        id = obj.getId();
        detalhe = obj.getDetalhe();
        estadoAtendimento = obj.getEstadoAtendimento().getCod();
    }

    public EstadoAtendimento getEstadoAtendimento() {
        return EstadoAtendimento.toEnum(estadoAtendimento);
    }

    public void setEstadoAtendimento(EstadoAtendimento estadoAtendimento) {
        this.estadoAtendimento = estadoAtendimento.getCod();
    }
}
