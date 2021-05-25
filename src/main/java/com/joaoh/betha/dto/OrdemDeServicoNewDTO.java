package com.joaoh.betha.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.domain.enums.EstadoAtendimento;
import com.joaoh.betha.domain.enums.TipoEquipamento;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemDeServicoNewDTO implements Serializable{

    private Integer id;

    private Long timestamp;
    private Integer clienteId;
    private String detalhe;
    private Integer estadoAtendimento;

    private String nomeEquipamento;
    private String marcaEquipamento;
    private Integer tipoEquipamento;

 
    
    public OrdemDeServicoNewDTO() {}
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
