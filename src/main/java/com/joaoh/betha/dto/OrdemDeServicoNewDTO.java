package com.joaoh.betha.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemDeServicoNewDTO implements Serializable{
    
    private String detalhe;
    private Integer clienteId;
    private Integer estadoAtendimento;


    public OrdemDeServicoNewDTO() {}

}
