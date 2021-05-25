package com.joaoh.betha.services;

import java.util.List;
import java.util.Optional;

import com.joaoh.betha.domain.Cidade;
import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.Endereco;
import com.joaoh.betha.dto.ClienteDTO;
import com.joaoh.betha.dto.ClienteNewDTO;
import com.joaoh.betha.repositories.ClienteRepository;
import com.joaoh.betha.repositories.EnderecoRepository;
import com.joaoh.betha.services.exceptions.DataIntegrityException;
import com.joaoh.betha.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Cliente> findAll() {
        return repo.findAll();
    }

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há ordens de serviço relacionadas");
		}
	}

    public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getTelefone(), objDto.getEmail());
	}

    public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getTelefone(), objDto.getEmail());
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getRua(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cid, cli);
		cli.getEnderecos().add(end);
		return cli;
	}

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

    private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}


}
