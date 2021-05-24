package com.joaoh.betha.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.OrdemDeServico;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDTO implements Serializable {
    
    private Integer id;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Size(min = 5, max = 100, message = "O nome precisa ter entre 5 e 100 caracteres")
    private String nome;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Preenchimento Obrigatório")
    private String telefone;

    private List<OrdemDeServico> ordens = new ArrayList<>();

    public ClienteDTO() {}


    public ClienteDTO(Cliente obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.email = obj.getEmail();
        this.telefone = obj.getTelefone();
        this.ordens = obj.getOrdensDeServico();
    }

    



}
