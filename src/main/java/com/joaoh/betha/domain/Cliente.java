package com.joaoh.betha.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String telefone;
    private String email;

    @OneToMany(mappedBy="cliente", cascade= CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy="cliente", cascade= CascadeType.ALL)
    private List<Equipamento> equipamentos = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<OrdemDeServico> ordensDeServico = new ArrayList<>();

    public Cliente() {}

    public Cliente(Integer id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    
}
