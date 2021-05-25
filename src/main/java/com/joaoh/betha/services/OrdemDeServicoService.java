package com.joaoh.betha.services;

import java.util.List;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.domain.enums.EstadoAtendimento;
import com.joaoh.betha.dto.OrdemDeServicoNewDTO;
import com.joaoh.betha.repositories.ClienteRepository;
import com.joaoh.betha.repositories.EnderecoRepository;
import com.joaoh.betha.repositories.OrdemDeServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OrdemDeServicoService {

    @Autowired
    private OrdemDeServicoRepository repo;


    public List<OrdemDeServico> findAll() {
        return repo.findAll();
    }


    @Transactional
	public OrdemDeServico insert(OrdemDeServico obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

    public List<OrdemDeServico> findByCliente(Integer clienteId) {
        return repo.findOrdens(clienteId);
    }

    public Page<OrdemDeServico> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

    public OrdemDeServico fromDTO(OrdemDeServicoNewDTO objDto) {
        Cliente cli = new Cliente(objDto.getClienteId(), null, null, null);

		return new OrdemDeServico(null, System.currentTimeMillis(), cli, objDto.getDetalhe(), EstadoAtendimento.ABERTA, objDto.getNomeEquipamento(), objDto.getMarcaEquipamento(), objDto.getTipoEquipamento()); 
    }
}
