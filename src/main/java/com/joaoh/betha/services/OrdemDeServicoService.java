package com.joaoh.betha.services;

import java.util.List;
import java.util.Optional;

import com.joaoh.betha.domain.Cliente;
import com.joaoh.betha.domain.OrdemDeServico;
import com.joaoh.betha.domain.enums.EstadoAtendimento;
import com.joaoh.betha.dto.OrdemDeServicoDTO;
import com.joaoh.betha.dto.OrdemDeServicoNewDTO;
import com.joaoh.betha.repositories.OrdemDeServicoRepository;
import com.joaoh.betha.services.exceptions.DataIntegrityException;
import com.joaoh.betha.services.exceptions.ObjectNotFoundException;

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

    public OrdemDeServico find(Integer id){
        Optional<OrdemDeServico> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
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

    public OrdemDeServico fromDTO(OrdemDeServicoDTO objDto) { 
		return new OrdemDeServico(null, null, null, objDto.getDetalhe(), objDto.getEstadoAtendimento(), null, null, null);
    }

    public OrdemDeServico fromDTO(OrdemDeServicoNewDTO objDto) {
        Cliente cli = new Cliente(objDto.getClienteId(), null, null, null);
       
        return new OrdemDeServico(null, System.currentTimeMillis(), cli, objDto.getDetalhe(), EstadoAtendimento.ABERTA, objDto.getNomeEquipamento(), objDto.getMarcaEquipamento(), objDto.getTipoEquipamento());
    }

    public void delete(Integer id) {
        OrdemDeServico obj = find(id);
        if (obj.getEstadoAtendimento() == EstadoAtendimento.ABERTA || obj.getEstadoAtendimento() == EstadoAtendimento.ATENDIMENTO) {
            throw new DataIntegrityException("E necessário concluir a ordem de serviço antes de excluí-la");
        
        } else if (obj.getEstadoAtendimento() == EstadoAtendimento.CONLUIDA) {
            repo.deleteById(id);
        }
	}

    public OrdemDeServico update(OrdemDeServico obj) {
		OrdemDeServico newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

    private void updateData(OrdemDeServico newObj, OrdemDeServico obj) {
		newObj.setDetalhe(obj.getDetalhe());
		newObj.setEstadoAtendimento(obj.getEstadoAtendimento());
	}

}
