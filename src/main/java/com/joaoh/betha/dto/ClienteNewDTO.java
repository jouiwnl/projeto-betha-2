package com.joaoh.betha.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteNewDTO implements Serializable {
    @NotEmpty(message="Preenchimento obrigatório")
	@Size(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String telefone;

    @NotEmpty (message = "Preenchimento obrigatório")
    private String rua;

    @NotEmpty (message = "Preenchimento obrigatório")
    private String numero;
    private String complemento;
    private String bairro;

    @NotEmpty (message = "Preenchimento obrigatório")
    private String cep;

    private Integer cidadeId;

    public ClienteNewDTO() {}



}
