package com.joaoh.betha.services;

import java.util.Arrays;

import com.joaoh.betha.domain.Cidade;
import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.Endereco;
import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.domain.enums.EstadoAtendimento;
import com.joaoh.betha.dto.ClienteDTO;
import com.joaoh.betha.dto.ClienteNewDTO;
import com.joaoh.betha.dto.OrdemDeServicoDTO;
import com.joaoh.betha.repositories.ClienteRepository;
import com.joaoh.betha.repositories.EnderecoRepository;
import com.joaoh.betha.repositories.OrdemDeServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrdemDeServicoService {

    @Autowired
    private OrdemDeServicoRepository repo;

    @Autowired
    private ClienteRepository clienteRepo;


    @Autowired
    private EnderecoRepository enderecoRepo;

    @Transactional
	public OrdemDeServico insert(OrdemDeServico obj, Cliente objCliente) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepo.saveAll(objCliente.getEnderecos());
		return obj;
	}

}
