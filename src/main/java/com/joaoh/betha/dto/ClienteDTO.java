package com.joaoh.betha.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.OrdemDeServico;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteDTO implements Serializable {
    
    private Integer id;
    
    @NotBlank(message = "Preenchimento obrigatório")
    @Size(min = 5, max = 100, message = "O nome precisa ter entre 5 e 100 caracteres")
    private String nome;
    
    @NotBlank(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Preenchimento obrigatório")
    private String telefone;

    public ClienteDTO() {}


    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
        telefone = obj.getTelefone();
    }

    



}
