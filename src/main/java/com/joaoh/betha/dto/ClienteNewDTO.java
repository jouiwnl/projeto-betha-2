package com.joaoh.betha.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteNewDTO implements Serializable {
    @NotBlank(message = "Preenchimento obrigatório")
	@Size(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;

    @NotBlank(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Preenchimento obrigatório")
    private String telefone;

    @NotBlank(message = "Preenchimento obrigatório")
    private String rua;

    @NotBlank(message = "Preenchimento obrigatório")
    private String numero;
    private String complemento;
    private String bairro;

    @NotEmpty (message = "Preenchimento obrigatório")
    private String cep;

    private Integer cidadeId;

    public ClienteNewDTO() {}



}
